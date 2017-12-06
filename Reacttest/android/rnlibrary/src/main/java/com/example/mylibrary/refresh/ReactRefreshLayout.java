package com.example.mylibrary.refresh;

import android.support.annotation.Nullable;
import android.util.Log;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

import java.util.Map;

/**
 * Created by PengFeifei on 2017/12/6.
 */

public class ReactRefreshLayout extends ViewGroupManager<PullRefreshLayout> {

    private static final int DO_REFRESH = 0;
    private static final int STOP_REFRESH = 1;

    @Override
    public String getName() {
        return "ReactRefreshLayout";
    }

    @Override
    protected PullRefreshLayout createViewInstance(ThemedReactContext reactContext) {
        final PullRefreshLayout pullRefreshLayout = new PullRefreshLayout(reactContext);
        return pullRefreshLayout;
    }

    @Nullable
    @Override
    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.of("doRefresh",DO_REFRESH,"stopRefresh", STOP_REFRESH);
    }

    @Override
    public void receiveCommand(PullRefreshLayout root, int commandId, @Nullable ReadableArray args) {
        switch (commandId) {
            case DO_REFRESH: {
                root.doRefreshing();
                Log.e("TAG-->","DO_REFRESH");
                break;
            }
            case STOP_REFRESH: {
                root.stopRefreshing();
                Log.e("TAG-->","STOP_REFRESH");
                break;
            }
        }
    }

    @Override
    protected void addEventEmitters(final ThemedReactContext reactContext, final PullRefreshLayout view) {
        super.addEventEmitters(reactContext, view);
        view.setOnRefreshListner(new OnRefreshListner() {
            @Override
            public void onRefreshStart() {
                reactContext.getNativeModule(UIManagerModule.class).getEventDispatcher()
                        .dispatchEvent(new Event(view.getId()) {
                            @Override
                            public String getEventName() {
                                return "onRefreshStart";
                            }

                            @Override
                            public void dispatch(RCTEventEmitter rctEventEmitter) {
                                rctEventEmitter.receiveEvent(getViewTag(), getEventName(), null);

                            }
                        });
            }

            @Override
            public void onRefreshIng() {
                reactContext.getNativeModule(UIManagerModule.class).getEventDispatcher()
                        .dispatchEvent(new Event(view.getId()) {
                            @Override
                            public String getEventName() {
                                return "onRefreshIng";
                            }

                            @Override
                            public void dispatch(RCTEventEmitter rctEventEmitter) {
                                rctEventEmitter.receiveEvent(getViewTag(), getEventName(), null);

                            }
                        });
            }

            @Override
            public void onRefreshEnd() {
                reactContext.getNativeModule(UIManagerModule.class).getEventDispatcher()
                        .dispatchEvent(new Event(view.getId()) {
                            @Override
                            public String getEventName() {
                                return "onRefreshEnd";
                            }

                            @Override
                            public void dispatch(RCTEventEmitter rctEventEmitter) {
                                rctEventEmitter.receiveEvent(getViewTag(), getEventName(), null);
                            }
                        });
            }
        });
    }

    @Override
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.<String, Object>builder()
                .put("onRefreshStart", MapBuilder.of("registrationName", "onRefreshStart"))
                .put("onRefreshIng", MapBuilder.of("registrationName", "onRefreshIng"))
                .put("onRefreshEnd", MapBuilder.of("registrationName", "onRefreshEnd"))
                .build();
    }

}
