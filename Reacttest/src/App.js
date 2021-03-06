import React, { Component } from 'react';
import {
    TouchableHighlight,
    Image
} from 'react-native';
import { StackNavigator } from 'react-navigation';

import HomePage from './module/home/Home.page';
import ToastPage from './module/toast/Toast.page';
import PullRefreshPage from './module/pull/PullRefresh.page';
import FlatList from './module/pull/FlatList.page';
import PullScroll from './module/pull/PullScrollpage';
import ChartPage from './module/chart/ChartPage';
import LineChartPage from './module/chart/LineChartPage';
import TemingPage from './module/theming/Teming.page';
import ZipPage from './module/zip/ZipDemo.page';
import DownLoadPage from './module/download/DownLoad.page';
import SKinPage from './module/skin/Skin.page';
import LanguagePage from './module/laguage/Laguage.page';

export default class App extends Component {
    constructor(props, context) {
        super(props, context);
    }
    render() {
        return <Navigator />;
    }
}

const Navigator = StackNavigator(
    {
        HomePage: { screen: HomePage },
        ToastPage: { screen: ToastPage },
        PullRefreshPage: { screen: PullRefreshPage },
        FlatList: { screen: FlatList },
        PullScroll: { screen: PullScroll },
        ChartPage: { screen: ChartPage },
        LineChartPage: { screen: LineChartPage },
        TemingPage: { screen: TemingPage },
        ZipPage: { screen: ZipPage },
        DownLoadPage: { screen: DownLoadPage },
        SKinPage: { screen: SKinPage },
        LanguagePage: { screen: LanguagePage },
    },
    {
        initialRouteName: 'HomePage',
        navigationOptions: ({ navigation }) => ({
            headerStyle: { elevation: 0, shadowOpacity: 0, backgroundColor: 'white' },
            headerTitleStyle: {
                color: '#687785',
                fontSize: 18,
            },
            headerBackTitle: null,
            headerLeft: (
                <TouchableHighlight
                    style={{ marginLeft: 15 }}
                    underlayColor='transparent'
                    onPress={() => { navigation.goBack(null) }}>
                    <Image
                        resizeMode='center'
                        source={require('./imgs/ArrowBack.png')}
                    />
                </TouchableHighlight>
            )
        })
    },
);