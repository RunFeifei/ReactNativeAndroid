package com.example.mylibrary.refresh;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by PengFeifei on 2017/11/17.
 * Only surppor SrcollerView!!!
 * Only surppor PullDown!!!
 */

public class PullRefreshLayout extends LinearLayout {

    private final int TOUCH_SLOP;
    private OnRefreshListner onRefreshListner;

    private DefaultLoadIngView loadingView;
    private View contentView;
    @LoadingType
    private int status = LoadingType.INIT;

    private float touchDownYposition;
    private float touchMoveDistance;

    private boolean isFirstInit = true;

    public PullRefreshLayout(Context context) {
        super(context);
        TOUCH_SLOP = ViewConfiguration.get(context).getScaledTouchSlop();
        init(context);
    }

    public PullRefreshLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TOUCH_SLOP = ViewConfiguration.get(context).getScaledTouchSlop();
        init(context);
    }

    private void init(Context context) {
        setOrientation(VERTICAL);
        setClickable(true);
        setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        initLottieView(context);
    }

    private void initLottieView(Context context) {
        loadingView = new DefaultLoadIngView(context);
        addView(loadingView);
        loadingView.setClickable(true);
        loadingView.setAutoPlay(false);
        loadingView.setAnimation("lender4_pull.json");
    }

    private void resetLottieView() {
        loadingView.setClickable(true);
        loadingView.setAutoPlay(false);
        loadingView.setAnimation("lender4_pull.json");
    }

    private void reset() {
        status = LoadingType.INIT;
        touchMoveDistance = 0;
        requestLayout();
        resetLottieView();
        if (onRefreshListner != null) {
            onRefreshListner.onRefreshEnd();
            Log.d("onRefreshListner-->", "onRefreshEnd");
        }
    }

    private void initContentView() {
        int viewCount = getChildCount();
        if (viewCount <= 1 || viewCount > 2) {
            Log.e("initContentView-->", "wrong child view count");
            return;
        }
        for (int i = 0; i < viewCount; i++) {
            View view = getChildAt(i);
            if (view != null && view != loadingView) {
                contentView = view;
                contentView.setClickable(true);
                isFirstInit = false;
            }
        }
        if (contentView == null) {
            throw new IllegalStateException("no content view??");
        }
    }

    private boolean isContentViewReadyPullDown() {
        if (contentView == null) {
            throw new IllegalStateException("content view is null");
        }
        contentView.setOverScrollMode(View.OVER_SCROLL_NEVER);
        if (contentView instanceof ScrollView) {
            ScrollView scrollView = (ScrollView) contentView;
            return scrollView.getScrollY() == 0;
        }
        if (contentView instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) contentView;
            View child = recyclerView.getChildAt(0);
            return null != child && child.getTop() >= 0;
        }
        return true;
    }

    private boolean isContentViewReadyPullUp() {
        if (contentView == null) {
            throw new IllegalStateException("content view is null");
        }
        if (contentView instanceof ScrollView) {
            ScrollView scrollView = (ScrollView) contentView;
            return scrollView.getScrollY() >= (scrollView.getChildAt(0).getHeight() - scrollView.getMeasuredHeight());
        }
        return true;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getActionMasked();
        if (status == LoadingType.LOAD_ING) {
            motionEvent.setAction(MotionEvent.ACTION_CANCEL);
        }
        switch (action) {
            case MotionEvent.ACTION_DOWN: {
                touchDownYposition = motionEvent.getY();
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                if (status == LoadingType.LOAD_ING) {
                    break;
                }
                float moveDistance = motionEvent.getY() - touchDownYposition;
                boolean pullDown = moveDistance > 0;
                boolean canPullDown = pullDown && isContentViewReadyPullDown();
                boolean validPullDown = canPullDown && moveDistance > TOUCH_SLOP;
                if (validPullDown && status != LoadingType.LOAD_START && onRefreshListner != null) {
                    onRefreshListner.onRefreshStart();
                    Log.d("onRefreshListner-->", "onRefreshStart");
                }
                if (validPullDown) {
                    touchMoveDistance = moveDistance - TOUCH_SLOP;
                    status = LoadingType.LOAD_START;
                    requestLayout();
                    motionEvent.setAction(MotionEvent.ACTION_CANCEL);
                }
                break;
            }
            case MotionEvent.ACTION_UP: {
                if (status == LoadingType.LOAD_START) {
                    onActionUp();
                }
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override
    public void requestLayout() {
        super.requestLayout();
        post(measureAndLayout);
    }

    private final Runnable measureAndLayout = new Runnable() {
        @Override
        public void run() {

            if (isFirstInit) {
                initContentView();
            }
            int moveDistance = (status == LoadingType.LOAD_START || status == LoadingType.LOAD_ING) ? (int) touchMoveDistance : 0;
            setLottieViewProgress(moveDistance);
            loadingView.layout(0, moveDistance - loadingView.getMeasuredHeight(), loadingView.getMeasuredWidth(), moveDistance);
            contentView.layout(0, moveDistance, contentView.getMeasuredWidth(), moveDistance + contentView.getMeasuredHeight());
        }
    };

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (isFirstInit) {
            initContentView();
        }
        int moveDistance = (status == LoadingType.LOAD_START || status == LoadingType.LOAD_ING) ? (int) touchMoveDistance : 0;
        setLottieViewProgress(moveDistance);
        loadingView.layout(0, moveDistance - loadingView.getMeasuredHeight(), loadingView.getMeasuredWidth(), moveDistance);
        contentView.layout(0, moveDistance, contentView.getMeasuredWidth(), moveDistance + contentView.getMeasuredHeight());
    }

    private void onActionUp() {
        final float moveDistance = touchMoveDistance;
        float loadingViewHeight = loadingView.getMeasuredHeight();
        final boolean doLoading = moveDistance > loadingViewHeight;
        ValueAnimator animator = ValueAnimator.ofFloat(moveDistance, doLoading ? loadingViewHeight : 0);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator.setDuration(doLoading ? 300 : 100);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                touchMoveDistance = (Float) animation.getAnimatedValue();
                requestLayout();
            }
        });
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                if (doLoading) {
                    if (loadingView.getLottieView().isAnimating()) {
                        loadingView.getLottieView().cancelAnimation();
                    }
                    loadingView.setAnimation("lender4_refresh.json");
                    loadingView.getLottieView().loop(true);
                    loadingView.getLottieView().playAnimation();
                    //超时恢复原样
                    resetInDelay(5000);
                }
            }

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                if (doLoading) {
                    status = LoadingType.LOAD_ING;
                    if (onRefreshListner != null) {
                        onRefreshListner.onRefreshIng();
                        Log.d("onRefreshListner-->", "onRefreshIng");
                    }
                }
            }
        });
        animator.start();
    }

    private void setLottieViewProgress(float moveDistance) {
        if (moveDistance == 0) {
            return;
        }
        float progress = Math.min(Math.abs(touchMoveDistance / loadingView.getMeasuredHeight()), 1.0f);
        loadingView.setProgress(progress);
    }

    private void resetInDelay(int delay) {
        //超时恢复原样
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                new Handler(Looper.getMainLooper()) {
                    @Override
                    public void handleMessage(Message msg) {
                        super.handleMessage(msg);
                        reset();
                    }
                }.obtainMessage().sendToTarget();
            }
        }, delay);
    }

    public void doRefreshing() {
        if (touchMoveDistance > 0) {
            touchMoveDistance = 0;
            requestLayout();
        }
        if (onRefreshListner != null) {
            onRefreshListner.onRefreshStart();
            Log.d("onRefreshListner-->", "onRefreshStart");
        }
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 500);
        valueAnimator.setDuration(500);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                status = LoadingType.LOAD_START;
                touchMoveDistance = (Float) animation.getAnimatedValue();
                requestLayout();
            }
        });
        valueAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                if (status == LoadingType.LOAD_START) {
                    onActionUp();
                }
            }
        });
        valueAnimator.start();
    }

    public void stopRefreshing() {
        if (touchMoveDistance == 0) {
            return;
        }
        reset();
    }

    public void setOnRefreshListner(@NonNull OnRefreshListner onRefreshListner) {
        this.onRefreshListner = onRefreshListner;
    }
}
