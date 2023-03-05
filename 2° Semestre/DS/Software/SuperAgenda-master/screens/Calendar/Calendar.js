import React, {useState} from 'react';
import { KeyboardAvoidingView, 
          StyleSheet,
          Dimensions, 
          Text, 
          View, 
          TextInput, 
          TouchableOpacity, 
          Keyboard, ScrollView, 
          Platform, 
          ViewPropTypes,
          SafeAreaView,
           
        } from 'react-native';
import { Button, Modal, Center, NativeBaseProvider, TextArea } from "native-base"
import { MaterialCommunityIcons } from '@expo/vector-icons';




import Dates from './Dates/Date';

const Event = (props) => {
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
            <Text style={styles.description}>{props.text}</Text>
          </View>
          
        </View>
      </View>
    </View>
    </View>
    </NativeBaseProvider>

  )

}

const windowHeight = (Dimensions.get("window").height) - 110;
export default function Calendario (){
  const [showModal, setShowModal] = useState(false);
  
  const [titulo, setTitulo] = useState();
  const [tituloItems, setTituloItems] = useState([]);

  


  // função que pega o input escreve na função task e depois é zerado para criar nova tarefa
  const handleAddTitulo = () => {
    Keyboard.dismiss(); {/* Faz com que o teclado desça quando aperto o + */}
    setTituloItems([...tituloItems, titulo])
    setTitulo(null);
    setShowModal(false);
  }
  const completeTitulo = (index) => {
    let itemsCopy = [...tituloItems];
    itemsCopy.splice(index, 1);
    setTituloItems(itemsCopy)
  }

  const [data, setData] = useState();
  const [dataItems, setDataItems] = useState([]);

  const handleAddData = () => {
    Keyboard.dismiss(); {/* Faz com que o teclado desça quando aperto o + */}
    setDataItems([...dataItems, data])
    setData(null);
  }

  return (
    <NativeBaseProvider>
      <SafeAreaView style={styles.container1}>
        <View style={styles.calendario}>
          <Dates></Dates>
        </View>

          <ScrollView
              contentContainerStyle={{
                flexGrow: 1
              }}
              keyboardShouldPersistTaps='handled'
            >

            <View >
              <View style={styles.items}>
                {/* Onde as tarefas vão ficar */}
                {
                  tituloItems.map((item, index, item2) => {
                    return (
                      /*Consegui mudar para click longo */
                      <TouchableOpacity 
                        key={index}  
                        onLongPress={() => completeTitulo(index)}> 
                        <Event 
                          text={item}
                          /> 
                      </TouchableOpacity>
                    )
                  })
                }
              </View>
            </View>
              
            </ScrollView>

      
          <Center
            flex={1}
            style={styles.contin}
          > 
            <Button 
              style={styles.button}
              onPress={() => setShowModal(true)}
            >
              <MaterialCommunityIcons style={styles.plus} name="plus" color={"white"} size={25} />
            </Button>
            <Modal 
              isOpen={showModal} 
              onClose={() => setShowModal(false)}  
            >
              <Modal.Content height={windowHeight} maxHeight={windowHeight}>
                <Modal.CloseButton />
                  <Modal.Header>Registro de Evento</Modal.Header>
                  <Modal.Body>
                  
                    <NativeBaseProvider>
                     <Center flex={1} px="3">
                        <Text>
                        Título
                        </Text>
                            
                          <TextInput
                            style={styles.input}
                            placeholder={'Ex: 25/10 - Prova de C1'}
                            value={titulo} 
                            onChangeText={text => setTitulo(text)}
                          />
                            
                      </Center>
                    </NativeBaseProvider>

                        
                       
                  </Modal.Body>
                  <Modal.Footer>
                    <Button.Group variant="ghost" space={2}>
                      <Button
                        onPress={() => handleAddTitulo() && handleAddData() }
                        >
                        <Text>Salvar</Text>
                      </Button>
                    </Button.Group>
                  </Modal.Footer>
              </Modal.Content>
            </Modal>
          </Center> 
          
                
      
      </SafeAreaView>
    </NativeBaseProvider>


  );
}


const styles = StyleSheet.create({
  contin: {
    alignItems: 'flex-end',
    justifyContent: 'flex-end',
    paddingVertical: 30,
    paddingHorizontal: 30
  },
  container1: {
    flex: 1,
    justifyContent: 'center',
    backgroundColor: "#FFF",
   
  },

  button: {
    height: 50,
    width: 50,
    justifyContent: "center",
    alignItems: "center",
    backgroundColor: "#CF4646",
    borderRadius: 50,
    borderWidth: 1,
    borderColor:"#FFFFFF"
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
  input: {
    paddingVertical: 15,
    paddingHorizontal: 30,
    backgroundColor: '#FFF',
    borderRadius: 50,
    borderColor: '#C0C0C0',
    borderWidth: 1,
    width: 200,
    height: 45,
    marginTop:5,
  },
  But: {
    backgroundColor: "#CF4646",
  },
  container: {
    backgroundColor: "#CF4646",
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
  writeTaskWrapper: {
    position: 'absolute',
    bottom: 30,
    width: '100%',
    flexDirection: 'row',
    justifyContent: 'space-around',
    alignItems: 'center',
    paddingHorizontal: 10,

  },
  
});