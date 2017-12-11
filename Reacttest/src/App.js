import React, { Component } from 'react';
import {
    AppRegistry,
    TouchableHighlight,
    Image
} from 'react-native';
import { StackNavigator } from 'react-navigation';

import HomePage from './module/home/Home.page';
import ToastPage from './module/toast/Toast.page';
import PullRefreshPage from './module/pull/PullRefresh.page';

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