//importar librerias
import React from 'react';
import {Text, AppRegistry,} from 'react-native';

//crear componentes

const App = () => {

    return (

        <Text>HOla guapo</Text>
    );
}


//renderizar a componentes a pantalla

AppRegistry.registerComponent('cars', () => App);