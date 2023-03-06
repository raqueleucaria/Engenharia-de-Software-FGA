import React, {useState} from 'react';

import { 
  SafeAreaView,
  ScrollView,
  StatusBar,
  StyleSheet,
  Text, 
  View 
} from 'react-native';
import { Calendar, LocaleConfig, CalendarList , Agenda} from 'react-native-calendars';

LocaleConfig.locales['br'] = {
  monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
  monthNamesShort: ['Jan.','Fev.','Mar.','Abr.','Maio','Jun.','Jul.','Ago.','Set.','Out.','Nov.','Dec.'],
  dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado'],
  dayNamesShort: ['D','S','T','Q','Q','S','S'],
  today: 'hoje'
};
LocaleConfig.defaultLocale = 'br';

export default function Dates() {
  return (
    <Calendar
      markedDates={{
        '2021-10-16': {selected: true, marked: true, selectedColor: 'blue'},
        '2021-10-17': {marked: true},
        '2021-10-18': {marked: true, dotColor: 'red', activeOpacity: 0},
        '2021-10-19': {disabled: true, disableTouchEvent: true}
      }}
      onChange={(range) => console.log(range)}
      minDate={new Date(2018, 3, 20)}
      startDate={new Date(2018, 3, 30)}
      endDate={new Date(2018, 4, 5)}
      theme={{
        /*activeDayColor: {},
        monthTitleTextStyle: {
          color: '#6d95da',
          fontWeight: '300',
          fontSize: 16,
        },
        emptyMonthContainerStyle: {},
        emptyMonthTextStyle: {
          fontWeight: '200',
        },
        weekColumnsContainerStyle: {},
        weekColumnStyle: {
          paddingVertical: 10,
        },
        weekColumnTextStyle: {
          color: '#b6c1cd',
          fontSize: 13,
        },
        nonTouchableDayContainerStyle: {},
        nonTouchableDayTextStyle: {},
        startDateContainerStyle: {},
        endDateContainerStyle: {},
        dayContainerStyle: {},
        dayTextStyle: {
          color: '#2d4150',
          fontWeight: '200',
          fontSize: 15,
        },
        dayOutOfRangeContainerStyle: {},
        dayOutOfRangeTextStyle: {},
        todayContainerStyle: {},
        todayTextStyle: {
          color: '#6d95da',
        },
        activeDayContainerStyle: {
          backgroundColor: '#6d95da',
        },
        activeDayTextStyle: {
          color: 'white',
        },
        nonTouchableLastMonthDayTextStyle: {},*/
      }}
    />
  );
}

