import React, { useState, useEffect, } from "react";
import AsyncStorage from '@react-native-async-storage/async-storage';
import {KeyboardAvoidingView,Platform,RefreshControl} from "react-native";
import {StyleSheet,View,FlatList,Image} from "react-native";
import { MaterialCommunityIcons } from '@expo/vector-icons';
import { Button,  Center, NativeBaseProvider, Text } from "native-base"

export default function App() {
   
  const [task, setTask] = useState([]);

  useEffect(() => {
    async function carregaDados() {
      const task = await AsyncStorage.getItem("task");

      if (task) {
        setTask(JSON.parse(task));
      }
    }
    carregaDados();
  }, []);

  return (
    <>


<NativeBaseProvider>
<View style={styles.container1}>
      <Image 
            source={require('../../assets/Marcador.png')}
            style={styles.Logo}
      />
      <View style={styles.container2}>
          <View style={styles.box} >
           
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                

          <KeyboardAvoidingView
        keyboardVerticalOffset={0}
        behavior="padding"
        style={{ flex: 1 }}
        enabled={Platform.OS === "ios"}
      >
        <View style={styles.container}>
          <View style={styles.Body}>
            <Text style={styles.TextoTi}>
              Eventos Próximos :
            </Text>

            <FlatList
              data={task}
              keyExtractor={item => item.toString()}
              showsVerticalScrollIndicator={true}
              style={styles.FlatList}
              renderItem={({ item }) => (
            

                <View style={styles.ContainerView}>

                  <Text style={styles.Texto}>
                  <MaterialCommunityIcons name="play" color={"black"} size={20} />
                    
                    {item}</Text>

                </View>
              )}
                
            />
          </View>
        </View>
      </KeyboardAvoidingView>



          </View>

      </View>
      </View>

      <Center
        flex={1}
        style={styles.contin}
      >
        <Button
        style={styles.button}
        onPress={() =>console.log('help')}>
        <MaterialCommunityIcons name="sync" color={"white"} size={25} />
      </Button>
      </Center>          


      </NativeBaseProvider>

    </>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    paddingHorizontal: 20,
    paddingVertical: 20,
    backgroundColor: "#FFF",
    borderRadius: 50,
    borderWidth: 1,
    borderColor: "black"
  },
  Body: {
    flex: 1
  },
  FlatList: {
    flex: 1,
    marginTop: 5
  },
  Texto: {
    fontSize: 20,
    color: "black",
    fontWeight: "bold",
    marginTop: 4,
    textAlign: "left"
  },
  ContainerView: {
    marginBottom: 0,
    padding: 10,
    borderRadius: 5,
    display: "flex",
    flexDirection: "row",
    justifyContent: "space-between",
    borderWidth: 1,
    borderColor: "#FFFFFF"
  },
  TextoTi: {
    paddingVertical:5,
    fontSize: 25,
    color: "black",
    fontWeight: "bold",
    marginTop: 4,
    textAlign: "left"
  },






  container1: {
    flex: 1,
    justifyContent: 'flex-start',
  },
Logo: {
    height: '20%',
    width: '65%',
    marginTop: 20,
    marginVertical: 20,
    
  },
  container2: {
    alignItems: 'center',
    justifyContent: 'space-evenly',
  },
  flat: {
    height: 40,
    width: 250,
    borderRadius: 50,
    // paddingVertical: 30,
    // paddingHorizontal: 30,

  },
  box: {
    borderRadius: 50,
    height: 300,
    width: 300,
    backgroundColor: "black",
    paddingVertical: 1,
    paddingHorizontal: 1,
  },

  button: {
    opacity: 100,
    width: 50,
    height: 50,
    backgroundColor: "#CF4646",
    justifyContent: 'center',
    borderRadius: 50,
    borderWidth: 1,
    borderColor:"#FFFFFF"
  },
  contin: {
    alignItems: 'flex-end',
    justifyContent: 'flex-end',
    paddingVertical: 30,
    paddingHorizontal: 30
  },


  
});