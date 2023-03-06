import * as React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import { MaterialCommunityIcons } from '@expo/vector-icons';

import Home from './screens/Home/Home'
import Tarefas from './screens/ToDo/ToDo'
import Discipline from './screens/Discipline/Discipline';
import Calendar from './screens/Calendar/Calendar';
import { LogBox } from 'react-native';


LogBox.ignoreLogs(['Warning: ...']); // Ignore log notification by message
LogBox.ignoreAllLogs();//Ignore all log notifications

const Tab = createBottomTabNavigator();





function MyTabs() {

  return (
    <Tab.Navigator
      initialRouteName="Home"
      screenOptions={{
        tabBarActiveTintColor: '#FFFFFF',
      }}
    >
      <Tab.Screen
        name="Home"
        component={Home}
        options={{
          tabBarLabel: 'Home',
          tabBarIcon: ({ color, size }) => (
            <MaterialCommunityIcons name="home" color={color} size={size} />
          ),
        }}
      />
      <Tab.Screen
        name="Tarefas"
        component={Tarefas}
        options={{
          tabBarLabel: 'Tarefas',
          tabBarIcon: ({ color, size }) => (
            <MaterialCommunityIcons name="check" color={color} size={size} />
          ),
        }}
      />
      <Tab.Screen
        name="Disciplinas"
        component={Discipline}
        options={{
          tabBarLabel: 'Disciplinas',
          tabBarIcon: ({ color, size }) => (
            <MaterialCommunityIcons name="book" color={color} size={size} />
          ),
        }}
      />
      <Tab.Screen
        name="Calendário"
        component={Calendar}
        options={{
          tabBarLabel: 'Calendário',
          tabBarIcon: ({ color, size }) => (
            <MaterialCommunityIcons name="calendar" color={color} size={size} />
          ),
        }}
      />
    </Tab.Navigator>
  );
}

export default function App() {
  return (
    <NavigationContainer theme={MyTheme}>
      <MyTabs />
    </NavigationContainer>
  );
}

const MyTheme = {
  dark: false,
  colors: {
    primary: 'rgb(207, 70, 70)',
    background: 'rgb(255, 255, 255)',
    card: 'rgb(207, 70, 70)',
    text: 'rgb(255, 255, 255)',
    border: 'rgb(207, 70, 70)',
    notification: 'rgb(207, 70, 70)',
  },
};