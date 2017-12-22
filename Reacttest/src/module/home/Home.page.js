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

    toFlatList = () => {
        const { navigate } = this.props.navigation;
        navigate('FlatList');
    }
    PullScroll = () => {
        const { navigate } = this.props.navigation;
        navigate('PullScroll');
    }
    ChartPage = () => {
        const { navigate } = this.props.navigation;
        navigate('ChartPage');
    }
    LineChartPage = () => {
        const { navigate } = this.props.navigation;
        navigate('LineChartPage');
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
                <Text
                    onPress={() => this.toFlatList()}
                >
                    toFlatList
                </Text>
                <Text
                    onPress={() => this.PullScroll()}
                >
                    PullScroll
                </Text>
                <Text
                    onPress={() => this.ChartPage()}
                >
                    ChartPage
                </Text>
                <Text
                    onPress={() => this.LineChartPage()}
                >
                    LineChartPage
                </Text>
            </View>
        );
    }
}