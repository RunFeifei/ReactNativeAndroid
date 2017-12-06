/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */
import AndroidReactRefreshLayout from './src/PullRefreshLayout';
import {AppRegistry, Dimensions, ScrollView, Text} from 'react-native';
import React, {Component} from 'react';


const KEY_REFRESH = "key_refresh";
const {width: SCREEN_WIDTH, height: SCREEN_HEIGHT,} = Dimensions.get('window');

export default class App extends Component {
    constructor(props, context) {
        super(props, context);
    }

    onRefreshStart = () => {
        console.log("-->onRefreshStart")
    }
    onRefreshIng = () => {
        console.log("-->onRefreshIng")
    }
    onRefreshEnd = () => {
        console.log("-->onRefreshEnd")
    }

    render() {
        return (
            <AndroidReactRefreshLayout
                ref={KEY_REFRESH}
                onRefreshStart={() => {
                    this.onRefreshStart()
                }}
                onRefreshIng={() => {
                    this.onRefreshIng()
                }}
                onRefreshEnd={() => {
                    this.onRefreshEnd()
                }}
            >
                <ScrollView
                    style={{width: SCREEN_WIDTH, height: SCREEN_HEIGHT}}
                >
                    <Text
                        style={{
                            width: SCREEN_WIDTH,
                            height: 50,
                            backgroundColor: 'red',
                            textAlign: 'center',
                            textAlignVertical: 'center'
                        }}
                        onPress={() => {
                            this.refs[KEY_REFRESH].doRefreshing()
                        }}>
                        TEST1
                    </Text>
                    <Text
                        style={{
                            width: SCREEN_WIDTH,
                            height: 50,
                            backgroundColor: 'blue',
                            textAlign: 'center',
                            textAlignVertical: 'center'
                        }}
                    >
                        TEST2
                    </Text>
                    <Text
                        style={{
                            width: SCREEN_WIDTH,
                            height: 50,
                            backgroundColor: 'red',
                            textAlign: 'center',
                            textAlignVertical: 'center'
                        }}
                    >
                        TEST3
                    </Text>
                    <Text
                        style={{
                            width: SCREEN_WIDTH,
                            height: 50,
                            backgroundColor: 'blue',
                            textAlign: 'center',
                            textAlignVertical: 'center'
                        }}
                    >
                        TEST4
                    </Text>
                    <Text
                        style={{
                            width: SCREEN_WIDTH,
                            height: 50,
                            backgroundColor: 'red',
                            textAlign: 'center',
                            textAlignVertical: 'center'
                        }}
                    >
                        TEST5
                    </Text>
                    <Text
                        style={{
                            width: SCREEN_WIDTH,
                            height: 50,
                            backgroundColor: 'blue',
                            textAlign: 'center',
                            textAlignVertical: 'center'
                        }}
                    >
                        TEST6
                    </Text>
                    <Text
                        style={{
                            width: SCREEN_WIDTH,
                            height: 50,
                            backgroundColor: 'red',
                            textAlign: 'center',
                            textAlignVertical: 'center'
                        }}
                    >
                        TEST7
                    </Text>
                    <Text
                        style={{
                            width: SCREEN_WIDTH,
                            height: 50,
                            backgroundColor: 'blue',
                            textAlign: 'center',
                            textAlignVertical: 'center'
                        }}
                    >
                        TEST8
                    </Text>
                    <Text
                        style={{
                            width: SCREEN_WIDTH,
                            height: 50,
                            backgroundColor: 'red',
                            textAlign: 'center',
                            textAlignVertical: 'center'
                        }}
                    >
                        TEST9
                    </Text>
                    <Text
                        style={{
                            width: SCREEN_WIDTH,
                            height: 50,
                            backgroundColor: 'blue',
                            textAlign: 'center',
                            textAlignVertical: 'center'
                        }}
                    >
                        TEST10
                    </Text>
                    <Text
                        style={{
                            width: SCREEN_WIDTH,
                            height: 50,
                            backgroundColor: 'red',
                            textAlign: 'center',
                            textAlignVertical: 'center'
                        }}
                    >
                        TEST11
                    </Text>
                    <Text
                        style={{
                            width: SCREEN_WIDTH,
                            height: 50,
                            backgroundColor: 'blue',
                            textAlign: 'center',
                            textAlignVertical: 'center'
                        }}
                    >
                        TEST12
                    </Text>
                    <Text
                        style={{
                            width: SCREEN_WIDTH,
                            height: 50,
                            backgroundColor: 'red',
                            textAlign: 'center',
                            textAlignVertical: 'center'
                        }}
                    >
                        TEST13
                    </Text>
                    <Text
                        style={{
                            width: SCREEN_WIDTH,
                            height: 50,
                            backgroundColor: 'blue',
                            textAlign: 'center',
                            textAlignVertical: 'center'
                        }}
                    >
                        TEST14
                    </Text>
                    <Text
                        style={{
                            width: SCREEN_WIDTH,
                            height: 50,
                            backgroundColor: 'red',
                            textAlign: 'center',
                            textAlignVertical: 'center'
                        }}
                    >
                        TEST15
                    </Text>
                    <Text
                        style={{
                            width: SCREEN_WIDTH,
                            height: 50,
                            backgroundColor: 'blue',
                            textAlign: 'center',
                            textAlignVertical: 'center'
                        }}
                    >
                        TEST16
                    </Text>
                    <Text
                        style={{
                            width: SCREEN_WIDTH,
                            height: 50,
                            backgroundColor: 'red',
                            textAlign: 'center',
                            textAlignVertical: 'center'
                        }}
                    >
                        TEST17
                    </Text>
                    <Text
                        style={{
                            width: SCREEN_WIDTH,
                            height: 50,
                            backgroundColor: 'blue',
                            textAlign: 'center',
                            textAlignVertical: 'center'
                        }}
                    >
                        TEST18
                    </Text>
                    <Text
                        style={{
                            width: SCREEN_WIDTH,
                            height: 50,
                            backgroundColor: 'red',
                            textAlign: 'center',
                            textAlignVertical: 'center'
                        }}
                    >
                        TEST19
                    </Text>
                    <Text
                        style={{
                            width: SCREEN_WIDTH,
                            height: 50,
                            backgroundColor: 'blue',
                            textAlign: 'center',
                            textAlignVertical: 'center'
                        }}
                    >
                        TEST20
                    </Text>
                </ScrollView>

            </AndroidReactRefreshLayout>
        );
    }
}

AppRegistry.registerComponent('Reacttest', () => App);
