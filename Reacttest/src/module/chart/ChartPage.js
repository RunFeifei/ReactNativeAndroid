import React from 'react';import {processColor, StyleSheet, Text, View,} from 'react-native';import {SafeAreaView} from 'react-navigation';import PieChart from './PieChartLegend';export default class ChartPage extends React.Component {    constructor() {        super();        this.colors01 = ['#C0FF8C', '#FFF78C', '#FFD08C', '#8CEAFF', '#FF8C9D'];        this.values01 = [{value: 40, label: 'Sandwiches'},            {value: 21, label: 'Salads'},            {value: 15, label: 'Soup'},            {value: 9, label: 'Beverages'},            {value: 15, label: 'Desserts'}];        this.tags01=["1","2","3","4","5"]        this.colors02 = ['red', 'black', 'blue', 'yellow', 'green'];        this.values02 = [{value: 40, label: '111'},            {value: 200, label: '222'},            {value: 15, label: '333'},            {value: 90, label: '444'},            {value: 150, label: '555'}];        this.tags02=["6","7","8","9","10"]        this.state = {            selectedEntry: null,            colors:this.colors01,            tags:this.tags01,            values:this.values01        }    }    handleSelect = (event) => {        let entry = event.nativeEvent        console.log("22222222", JSON.stringify(entry));        if (!entry.value) {            this.setState({selectedEntry: "111"})        } else {            this.setState({selectedEntry: JSON.stringify(entry)})        }    }    animateY = () => {        this.pieChart.animateY()    }    changeState = () => {        this.setState({            colors:this.colors02,            tags:this.tags02,            values:this.values02})    }    render() {        return (            <SafeAreaView style={{flex: 1}}>                <Text                    onPress={() => {                        this.changeState()                    }}                >changeState</Text>                <Text                    onPress={() => {                        this.animateY()                    }}                >animateY</Text>                <Text style={{color: 'red', fontSize: 20}}> {this.state.selectedEntry}</Text>                <View style={styles.container}>                    <PieChart                        ref={(c) => {                            this.pieChart = c;                        }}                        colors={this.state.colors}                        chartBackgroundColor={processColor('transparent')}                        values={this.state.values}                        entryLabelColor={processColor('black')}                        entryLabelTextSize={0}                        holeRadius={20}                        onSelect={this.handleSelect}                        tags={this.state.tags}                    />                </View>            </SafeAreaView>        );    }}const styles = StyleSheet.create({    container: {        flex: 1,    },    chart: {        flex: 1    }});