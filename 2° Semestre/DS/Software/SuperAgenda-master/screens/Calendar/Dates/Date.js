import * as React from 'react';

import { Calendar, LocaleConfig} from 'react-native-calendars';

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
      '2021-10-22': {selected: true, marked: true, selectedColor: "#CF4646"},
      '2021-10-12': {marked: true, dotColor: "#CF4646", activeOpacity: 0},
      '2021-10-28': {marked: true, dotColor: "#CF4646", activeOpacity: 0},
      '2021-10-15': {marked: true, dotColor: "#CF4646", activeOpacity: 0},
      '2021-10-31': {marked: true, dotColor: "#CF4646", activeOpacity: 0},
      '2021-11-02': {marked: true, dotColor: "#F0F0F0F0", activeOpacity: 0},
      
    }}
    
  

    />
  );
}

