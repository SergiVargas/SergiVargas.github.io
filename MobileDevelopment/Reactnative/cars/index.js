//import libraries
import React from 'react';
import {Text, AppRegistry,} from 'react-native';

//create component

const App = () => {

    return (

        <Text>Bienvenido a la App</Text>
    );
}


//render component to screen

AppRegistry.registerComponent('cars', () => App);