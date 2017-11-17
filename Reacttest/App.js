/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */
import ToastForAndroid from './ToastForAndroid';
import {AppRegistry, Dimensions, Text, TouchableHighlight} from 'react-native';
import React, {Component} from 'react';


let deviceWidth = Dimensions.get('window').width;

export default class App extends Component {
    render() {
        return (
            <TouchableHighlight onPress={() => ToastForAndroid.show('I am clicked ', ToastForAndroid.LONG)}>
                <Text style={{
                    width: deviceWidth,
                    height: 50,
                    backgroundColor: 'red',
                    textAlign: 'center',
                    textAlignVertical: 'center'
                }}>点击调用Native方法</Text>
            </TouchableHighlight>
        );
    }
}

AppRegistry.registerComponent('Reacttest', () => App);
