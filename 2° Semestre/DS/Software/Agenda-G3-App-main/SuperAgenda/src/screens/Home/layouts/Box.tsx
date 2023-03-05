import React from "react";
import { View, Text } from 'react-native'

export default function Box(props: { color: any; event1: any; event2: any; event01: any; event02: any;  }){
    return(
        <View style={{
            borderRadius: 15,
            height: 180,
            width: 262,
            backgroundColor: props.color || '#000',
            paddingVertical: 30,
            paddingHorizontal: 30,
        }}>
        <EventBox 
            event1= {props.event01}
            event2= {props.event02} 
        />
        </View>
    );
}

const EventBox = (props: { event1: any; event2: any  }) => {
    return(
        <>
        <Text style={{
            fontSize: 20,
            fontWeight: 'bold',
        }}> 
            {props.event1}
        </Text>

        <Text style={{
            fontSize: 14,
            fontWeight: 'bold',
        }}> 
            <LittleBall/>    {props.event2} 
        </Text>
        </>
    )
}



function LittleBall(){
    return(
        <View 
        style={{borderRadius: 20,
                backgroundColor: '#000',
                height: 14,
                width: 14,}
            }/>
    )
}
