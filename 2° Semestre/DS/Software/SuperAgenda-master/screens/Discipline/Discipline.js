import React, {useState} from 'react';
import { KeyboardAvoidingView,SafeAreaView,StyleSheet,Dimensions,Text,View,TextInput,TouchableOpacity,Keyboard, ScrollView,Platform,ViewPropTypes} from 'react-native';
import { Button, Modal, Center, NativeBaseProvider, TextArea } from "native-base"
import { MaterialCommunityIcons } from '@expo/vector-icons';



/* 
aparência da tarefa
quando coloca text="tarefa 1" o texto dessa função muda
criando outra função que pega o texto do input e joga pra cá -> temos uma noa tarefa
*/


const Discipline = (props) => {
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

            <Text style={styles.description}>{props.text}</Text>
          

          
        </View>
      </View>
    </View>
    </View>
    </NativeBaseProvider>

  )
}

const windowHeight = (Dimensions.get("window").height) - 110;
export default function App() {

  const [showModal, setShowModal] = useState(false);
  // ========================== DISCIPLINA ============================
  const [discipline, setDiscipline] = useState();
  const [disciplineItems, setDisciplineItems] = useState([]);

  //============================== PROFESSOR ======================
  const [teacher, setTeacher] = useState();
  const [teacherItems, setTeacherItems] = useState([]);

//=================================================================


// função que exclui a tarefa
// pega a tarefa com base no index e exclui -> n entendi mt bem
// um click exclui -> (excluir arrastando para o lado seria melhor)
const completeDiscipline = (index) => {
    let itemsCopy = [...disciplineItems];
    itemsCopy.splice(index, 1);
    setDisciplineItems(itemsCopy)

  }

  
 // função que pega o input escreve na função task e depois é zerado para criar nova tarefa
  const handleAddDiscipline = () => {
    Keyboard.dismiss(); {/* Faz com que o teclado desça quando aperto o + */}
    setDisciplineItems([...disciplineItems, discipline])
    setDiscipline(null);
    setShowModal(false);
  
  }


  
  return (
    
    <NativeBaseProvider> 
      <SafeAreaView style={styles.container1}>
        {/* Rolagem da tela 
        Arrumar para que o botão de adicionar tarefa n tenha rolagem por baixo dele
        (ter um fundo e ficar fixo)
        */}
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
              disciplineItems.map((item, index) => {
                return (
                  /*Consegui mudar para click longo */
                  <TouchableOpacity 
                    key={index}  
                    onLongPress={() => completeDiscipline(index)}> 
                    <Discipline text={item}  /> 
                  </TouchableOpacity>
                )
              })
              
              
              
            }
          </View>
          
          {/*
          <View style={styles.items}>

            {
              teacherItems.map((item2, index) => {
                return (
                  
                  <TouchableOpacity 
                  key={index}  
                  onLongPress={() => completeDiscipline(index)}> 
                  <Discipline text2={item2} /> 
                  </TouchableOpacity>
                )
              })
              

              
            }
          </View>

          */}

          
          
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
                  <Modal.Header>Registro de Disciplina</Modal.Header>
                  <Modal.Body>

                    <NativeBaseProvider>
                      <Center flex={1} px="3">
                        <Text>
                        Disclipina
                        </Text>
                          <TextInput
                            style={styles.input}
                            placeholder={'Ex: Cálculo 1'}
                            value={discipline} 
                            onChangeText={text => setDiscipline(text)}
                          />
                      </Center>
                    </NativeBaseProvider>

                    {/* <NativeBaseProvider>
                      <Center flex={1} px="3">
                        <Text>
                        Professor
                        </Text>
                          <TextInput
                            style={styles.input}
                            placeholder={'Ex: Raquel'}
                            value={teacher} 
                            onChangeText={text => setTeacher(text)}
                          />
                      </Center>
                    </NativeBaseProvider> */}
                      

                  </Modal.Body>

                  <Modal.Footer>
                    <Button.Group variant="ghost" space={2}>
                      <Button
                        onPress={() => handleAddDiscipline() }
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
    marginLeft: 10,
    borderRadius: 50,
    borderWidth: 1,
    borderColor:"#FFFFFF"


  },
  plus:{
    textAlign: 'center',
  
  },
  item: {
    backgroundColor: '#FFF',
    padding: 15,
    borderRadius: 10,
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'space-between',
    marginBottom: 20
  },
  itemLeft:{
    flexDirection: 'row',
    alignItems: 'center',
    flexWrap: 'wrap'

  },
  square: {
    width: 24,
    height: 24,
    backgroundColor: 'red',
    opacity: 0.4,
    borderRadius: 5,
    marginRight: 15
  },
  itemText: {
    maxWidth: '80%'
  },
  circular: {
    width: 12,
    height: 12,
    borderColor: 'black',
    borderWidth: 2,
    borderRadius: 5
  },
  tasksWrapper: {
    paddingTop: 80,
    paddingHorizontal: 20,
  },
  sectionTitle: {
    fontSize: 24,
    fontWeight: 'bold'
  },
  items: {
    marginTop: 30,
  },
  writeTaskWrapper: {
    position: 'absolute',
    bottom: 60,
    width: '100%',
    flexDirection: 'row',
    justifyContent: 'space-around',
    alignItems: 'center',
    paddingHorizontal: 10,
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
  addWrapper: {
    width: 60,
    height: 60,
    backgroundColor: '#FFF',
    borderRadius: 60,
    justifyContent: 'center',
    alignItems: 'center',
    borderColor: '#C0C0C0',
    borderWidth: 1,
  },
  addText: {},
  contin: {
    alignItems: 'flex-end',
    justifyContent: 'flex-end',
    paddingVertical: 30,
    paddingHorizontal: 30
  },

  button2: {
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
    backgroundColor: "#CF4646",
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



