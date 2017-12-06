'use strict';

import React, {Component} from 'react';
import {requireNativeComponent} from 'react-native';
const ReactNative = require('ReactNative');
const UIManager = require('UIManager');
let AndroidReactRefreshLayout=requireNativeComponent('ReactRefreshLayout',PullRefreshLayout,{});
const KEY_REF = "ReactRefreshLayoutKey";

export default class PullRefreshLayout extends Component {
    constructor(props, context) {
        super(props, context);
    }

    getPluImageHandle = () => {
        return ReactNative.findNodeHandle(this.refs[KEY_REF]);
    }

    doRefreshing = () => {
        UIManager.dispatchViewManagerCommand(
            this.getPluImageHandle(),
            0,
            null
        );
    }

    stopRefresh = () => {
        UIManager.dispatchViewManagerCommand(
            this.getPluImageHandle(),
            1,
            null
        );
    }

    render() {
        return (
            <AndroidReactRefreshLayout
                ref={KEY_REF}
                {...this.props}
                onRefreshStart={()=>{
                    this.props.onRefreshStart&&this.props.onRefreshStart();
                }}
                onRefreshIng={()=>{
                    this.props.onRefreshIng&&this.props.onRefreshIng();
                }}
                onRefreshEnd={()=>{
                    this.props.onRefreshEnd&&this.props.onRefreshEnd();
                }}
            >
            </AndroidReactRefreshLayout>
        );
    }
}

module.exports=PullRefreshLayout;
