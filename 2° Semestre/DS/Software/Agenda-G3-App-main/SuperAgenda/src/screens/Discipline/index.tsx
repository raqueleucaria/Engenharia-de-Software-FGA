import React from "react"
import { Button, Modal, Center, NativeBaseProvider, Text, TextArea } from "native-base"
import { Dimensions, StyleSheet, View } from "react-native"
import { useState } from "react"
import { MaterialCommunityIcons } from '@expo/vector-icons';



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
          <Modal.Header>Registro de Disciplina</Modal.Header>
          <Modal.Body>

            <NativeBaseProvider>
              <Center flex={1} px="3">
              <Text>
              Nome da diclipina :
              </Text>
                <SubName />
              </Center>
            </NativeBaseProvider>
            <View >
              <Text>

              </Text>
            </View>
            <NativeBaseProvider>
              <Center flex={1} px="3">
              <Text>
              Nome do Professor(a) :
              </Text>
                <ProfName />
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
                <Text

                >
                  Registrar a materia
                </Text>
              </Button>
            </Button.Group>
          </Modal.Footer>
        </Modal.Content>
      </Modal>
    </>
  )
}
export const SubName = () => {
  return (
    <TextArea
      h={10}
      placeholder="Nome da diclipina :"
      w={{
        base: "80%",
        md: "85%",
      }}
    />
  )
}
export const ProfName = () => {
  return (
    <TextArea
      h={10}
      placeholder="Nome do Professor(a) :"
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
      <View style={styles.cont}>
      <View style={{
            height: 22,
            width: 22,
            borderColor:'#000',
        }}/>
     <View style={styles.container}>
      <View style={styles.topContainer}>
        <View style={styles.metaContainer}>
          <View>
            <Text style={styles.description}>Disciplina 1</Text>
            <Text style={styles.timings}>Professor x</Text>
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
          <Text style={styles.description}>Disciplina 2</Text>
            <Text style={styles.timings}>Professor y</Text>
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
    alignItems: 'flex-start',
    justifyContent: 'flex-start',
    paddingVertical: 20,
    paddingHorizontal: 30
  },
  cont0: {
    alignItems: 'flex-start',
    justifyContent: 'flex-start',
    paddingHorizontal: 30
  },
 
  But: {
    backgroundColor: "#CF4646",
  },
  container: {
    backgroundColor: '#E73CA8',
    paddingVertical: 16,
    paddingHorizontal: 12,
    borderRadius: 5,
    alignSelf: 'flex-start',
    width: 375,
    maxWidth: '100%',
  },
  container2: {
    backgroundColor: '#E08F28',
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

});