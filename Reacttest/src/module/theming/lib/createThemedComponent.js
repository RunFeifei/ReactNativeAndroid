import React, {Component} from 'react';
import PropTypes from 'prop-types';

import {getCurrentTheme, registerComponent} from './Theme';
import ThemedStyle from './ThemedStyle';

export default function createThemedComponent(C, themedProps = []) {
    class ThemedComponent extends Component {
        static displayName = `Theme.${C.displayName}`;

        static propTypes = {
            style: PropTypes.oneOfType([
                PropTypes.number,                       // For StyleSheet.create
                PropTypes.instanceOf(ThemedStyle),      // For Themed styles
                PropTypes.object,                       // For inline styles
                PropTypes.arrayOf(PropTypes.oneOfType([
                    PropTypes.number,
                    PropTypes.instanceOf(ThemedStyle),
                    PropTypes.object,
                ])),
            ]),
            children: PropTypes.oneOfType([
                PropTypes.node,
                PropTypes.arrayOf(PropTypes.node),
            ]),
        };

        static defaultProps = {
            style: undefined,
            children: undefined,
        };

        constructor(props) {
            super(props);

            const theme = getCurrentTheme();
            console.log("constructor--getCurrentTheme", theme);
            this.state = {
                theme,
                props: themedProps.reduce((res, key) => {
                    res[key] = theme.getProp(props[key]);
                    console.log("constructor--key", key);
                    console.log("constructor--reduce", res[key]);
                    return res;
                }, {}),
            };
        }

        componentWillMount() {
            this.unregister = registerComponent(this);
        }

        componentWillReceiveProps(nextProps) {
            const {theme, props} = this.state;

            let changed = false;
            // See if props have changed, only in which case change the state
            const newPropsState = themedProps.reduce((res, key) => {
                const newValue = theme.getProp(nextProps[key]);
                if (props[key] !== newValue) {
                    changed = true;
                }
                res[key] = newValue;
                return res;
            }, {});

            if (changed) {
                this.setState({
                    props: newPropsState,
                });
            }
        }

        componentWillUnmount() {
            this.unregister();
        }

        setTheme(newTheme) {
            this.setState({
                theme: newTheme,
                props: themedProps.reduce((res, key) => {
                    res[key] = newTheme.getProp(this.props[key]);
                    return res;
                }, {}),
            });
        }

        render() {
            const {style, children, ...other} = this.props;
            const {theme, props} = this.state;
            //console.log("render--theme", theme);
            const themedStyle = theme.getStyle(style);
            //console.log("render--themedStyle", themedStyle);
            console.log("render--props", props);
            return (
                <C style={themedStyle} {...other} {...props}>
                    {children}
                </C>
            );
        }
    }

    return ThemedComponent;
}
