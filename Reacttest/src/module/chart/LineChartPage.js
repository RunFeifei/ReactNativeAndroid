import React from 'react';import {processColor, StyleSheet, Text, View} from 'react-native';import update from 'immutability-helper';import LineChart from '../../view/chart/LineChart';class LineChartScreen extends React.Component {    constructor() {        super();        this.state = {            data: {},            legend: {                enabled: false,            },            marker: {                enabled: true,                digits: 2,                backgroundTint: processColor('white'),                markerColor: processColor('red'),                textColor: processColor('black'),                offsetY:-20,                xOffsetStartEnd:-2,            }        };    }    componentDidMount() {        this.setState(            update(this.state, {                data: {                    $set: {                        dataSets: [{                            values: [{x: 20,y: 0.88888888888}, {x: 30,y: 77},{x: 40,y: 0.77},{x: 50,y: 0.747},{x: 60,y: 105}, {x: 70,y: 115}],                            label: '',                            config: {                                lineWidth: 2,                                drawCircles: true,                                highlightEnabled: true,                                highlightColor: processColor('transparent'),                                color: processColor('#00bc8d'),                                drawFilled: false,                                valueTextSize: 15,                                valueFormatter: "##0.00000000",                                circleColor: processColor('#00bc8d'),                                circleRadius: 5,                                drawCircleHole:false,                                drawValues:false                            }                        }],                    }                },                xAxis: {                    $set: {                        drawAxisLine:false,                        drawGridLines: false,                        position:'BOTTOM',                        avoidFirstLastClipping: false,                        valueFormatter: "#日",                    }                },                yAxis: {                    $set: {                        left: {                            enabled: false,                            leftAxisMaximum: 300,                        },                        right: {                            enabled: false,                        }                    }                }            })        );    }    handleSelect(event) {        let entry = event.nativeEvent        if (entry == null) {            this.setState({...this.state, selectedEntry: null})        } else {            this.setState({...this.state, selectedEntry: JSON.stringify(entry)})        }    }    render() {        return (            <View style={{flex: 1}}>                <View style={{height: 80}}>                    <Text> selected entry</Text>                    <Text> {this.state.selectedEntry}</Text>                </View>                <View style={styles.container}>                    <LineChart                        style={styles.chart}                        data={this.state.data}                        chartDescription={{text: ''}}                        legend={this.state.legend}                        marker={this.state.marker}                        xAxis={this.state.xAxis}                        yAxis={this.state.yAxis}                        drawGridBackground={false}                        drawBorders={false}                        touchEnabled={true}                        dragEnabled={false}                        scaleEnabled={false}                        keepPositionOnRotation={false}                        onSelect={this.handleSelect.bind(this)}                    />                </View>            </View>        );    }}const styles = StyleSheet.create({    container: {        flex: 1,        marginBottom:20,        marginLeft:20,        marginRight:20    },    chart: {        backgroundColor: 'white',        height:150,    }});export default LineChartScreen;