import {Dimensions, View, Text} from 'react-native';
import React, {Component} from 'react';

const {width: SCREEN_WIDTH, height: SCREEN_HEIGHT,} = Dimensions.get('window');

export default class Home extends Component {
    constructor(props, context) {
        super(props, context);
    }

    toToast = () => {
        const { navigate } = this.props.navigation;
        navigate('ToastPage');
    }

    toRefresh = () => {
        const { navigate } = this.props.navigation;
        navigate('PullRefreshPage');
    }


    render() {
        return (
            <View style={{width: SCREEN_WIDTH, height: SCREEN_HEIGHT, flex: 1}}>
                <Text
                    onPress={() => this.toToast()}
                >
                    toToast
                </Text>
                <Text
                    onPress={() => this.toRefresh()}
                >
                    toRefresh
                </Text>
            </View>
        );
    }
}