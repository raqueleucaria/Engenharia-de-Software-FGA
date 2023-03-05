import React from "react"
import { Button, Modal, Center, NativeBaseProvider, Text, TextArea,Image, } from "native-base"
import { Dimensions, StyleSheet, View, FlatList } from "react-native"
import { useState } from "react"
import { MaterialCommunityIcons } from '@expo/vector-icons';

import Dates from './Dates/index';



const windowHeight = (Dimensions.get("window").height) - 110;
export const Botao = () => {




  const [showModal, setShowModal] = useState(false)

  
  return (
    <>
      <Button
        style={styles.button}
        onPress={() => setShowModal(true)}>
        <MaterialCommunityIcons name="plus" color={"white"} size={25} />
      </Button>
      <Modal isOpen={showModal} onClose={() => setShowModal(false)}>
        <Modal.Content height={windowHeight} maxHeight={windowHeight}>
          <Modal.CloseButton />
          <Modal.Header>Registro de Evento</Modal.Header>
          <Modal.Body>

            <NativeBaseProvider>
              <Center flex={1} px="3">
              <Text>
              Título :
              </Text>
                <EventName />
              </Center>
            </NativeBaseProvider>

            <NativeBaseProvider>
              <Center flex={1} px="3">
              <Text>
              Data :
              </Text>
                <EventDay />
              </Center>
            </NativeBaseProvider>

            <NativeBaseProvider>
              <Center flex={1} px="3">
              <Text>
              Disciplina (Opcional) :
              </Text>
                <Dis />
              </Center>
            </NativeBaseProvider>




            <NativeBaseProvider>
              <Center flex={1} px="3">
              <Text>
              Descrição :
              </Text>
                <Description />
              </Center>
            </NativeBaseProvider>


            <NativeBaseProvider>
              <Center flex={1} px="3">
              <Text>
              Horário :
              </Text>
                <EventTime />
              </Center>
            </NativeBaseProvider>



          </Modal.Body>
          <Modal.Footer>
            <Button.Group variant="ghost" space={2}>
              <Button

                onPress={() => {
                  setShowModal(false)
                }}
              >
                <Text>
                 Salvar
                </Text>
              </Button>
            </Button.Group>
          </Modal.Footer>
        </Modal.Content>
      </Modal>
    </>
  )
}
export const EventName = () => {
  return (
    <TextArea
      h={10}
      placeholder="Ex: Prova 1"
      w={{
        base: "80%",
        md: "85%",
      }}
    />
  )
}



export const EventDay = () => {
  return (
    <TextArea
      h={10}
      placeholder="Ex: 04/08/2021"
      w={{
        base: "80%",
        md: "85%",
      }}
    />
  )
}

export const Dis = () => {
  return (
    <TextArea
      h={10}
      placeholder="Ex: Cálculo"
      w={{
        base: "80%",
        md: "85%",
      }}
    />
  )
}

export const EventTime = () => {
  return (
    <TextArea
      h={10}
      placeholder="Ex: 14:30"
      w={{
        base: "80%",
        md: "85%",
      }}
    />
  )
}

export const Description = () => {
  return (
    <TextArea
      h={10}
      placeholder="Ex: Limites e Derivadas"
      w={{
        base: "80%",
        md: "85%",
      }}
    />
  )
}







export default () => {
  return (


    <NativeBaseProvider>
      <View style={styles.calendario}><Dates></Dates></View>
        <View style={styles.cont}>
          <View style={styles.container}>
            <View style={styles.topContainer}>
              <View style={styles.metaContainer}>
                <View>
                  <Text style={styles.timings}>24/09  16:00</Text>
                  <Text style={styles.description}>Evento 1</Text>
                </View>
              </View>
            </View>
          </View>
        </View>

        <View style={styles.cont0}>
          <View style={styles.container2}>
            <View style={styles.topContainer}>
              <View style={styles.metaContainer}>
                <View>
                  <Text style={styles.timings}>28/09  10:00</Text>
                  <Text style={styles.description}>Evento 2</Text>
                </View>
              </View>
            </View>
          </View>
        </View>

    <Center
      flex={1}
      style={styles.contin}
    >
      <Botao />
    </Center>
    </NativeBaseProvider>
  )
}

const styles = StyleSheet.create({
  contin: {
    alignItems: 'flex-end',
    justifyContent: 'flex-end',
    paddingVertical: 30,
    paddingHorizontal: 30
  },

  button: {
    opacity: 100,
    width: 50,
    height: 50,
    backgroundColor: "#CF4646",
    justifyContent: 'center',
    borderRadius: 50,
  },
  
  cont4: {
    height: 10,
    alignItems: 'flex-start',
    backgroundColor: "#fcfcfc",
  },
  cont: {
    //alignItems: 'flex-start',
    justifyContent: 'space-evenly',
    paddingVertical: 20,
    paddingHorizontal: 30
  },
  cont0: {
    alignItems: 'flex-start',
    justifyContent: 'flex-start',
    paddingHorizontal: 30,
    
  },

  But: {
    backgroundColor: "#CF4646",
  },
  container: {
    backgroundColor: '#0891b2',
    paddingVertical: 16,
    paddingHorizontal: 12,
    borderRadius: 5,
    alignSelf: 'flex-start',
    width: 375,
    maxWidth: '100%',
  },
  container2: {
    backgroundColor: '#46C379',
    paddingVertical: 16,
    paddingHorizontal: 12,
    borderRadius: 5,
    alignSelf: 'flex-start',
    width: 375,
    maxWidth: '100%',
  },
  timings: {
    color: '#fff',
    fontSize: 14,
  },
  metaContainer: {
    justifyContent: 'space-between',
  },
  topContainer: {
    flexDirection: 'row',
    justifyContent: 'space-between',
  },
  avatar: {
    height: 100,
    width: 100,
    borderRadius: 100,
  },
  description: {
    color: 'white',
    marginTop: 5,
    fontSize: 20,
  },
  calendario: {
    
    width: "100%",
    height: "auto",
    justifyContent: 'space-evenly',
    paddingTop:30,
    paddingVertical:10,
    paddingHorizontal: 30
  },

});