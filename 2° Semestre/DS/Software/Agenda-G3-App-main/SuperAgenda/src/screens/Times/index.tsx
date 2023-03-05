import React, {useState} from 'react';
import { KeyboardAvoidingView, StyleSheet, Text, View, TextInput, TouchableOpacity, Keyboard, ScrollView, Platform, Button } from 'react-native';
import { MaterialCommunityIcons } from '@expo/vector-icons';

/* 
aparência da tarefa
quando coloca text="tarefa 1" o texto dessa função muda
criando outra função que pega o texto do input e joga pra cá -> temos uma noa tarefa
*/
const Task = (props) => {
  return (
      <View style={styles.item}>
      <View style={styles.itemLeft}>
        <View style={styles.square}/>
      </View>
      <Text style={styles.itemText}>{props.text}</Text>
      <View style={styles.circular}/>
    </View>
  )
}
export default function App() {
  const [task, setTask] = useState();
  const [taskItems, setTaskItems] = useState([]);

  // função que pega o input escreve na função task e depois é zerado para criar nova tarefa
  const handleAddTask = () => {
    Keyboard.dismiss(); {/* Faz com que o teclado desça quando aperto o + */}
    setTaskItems([...taskItems, task])
    setTask(null);
  }

  // função que exclui a tarefa
  // pega a tarefa com base no indez e exclui -> n entendi mt bem
  // um click exclui -> (excluir arrastando para o lado seria melhor)
  const completeTask = (index) => {
    let itemsCopy = [...taskItems];
    itemsCopy.splice(index, 1);
    setTaskItems(itemsCopy)
  }

  return (
    <View style={styles.container}>
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
            taskItems.map((item, index) => {
              return (
                /*Consegui mudar para click longo */
                <TouchableOpacity key={index}  onLongPress={() => completeTask(index)}> 
                  <Task text={item} /> 
                </TouchableOpacity>
              )
            })
          }
        </View>
      </View>
        
      </ScrollView>

      {/* Adicionando nova tarefa*/}
      {/* esses KeyboardAvoidingView faz com que o teclado n atrapalhe*/}
      <KeyboardAvoidingView 
        behavior={Platform.OS === "ios" ? "padding" : "height"}
        style={styles.writeTaskWrapper}
      >
        <TextInput style={styles.input} 
        placeholder={'Adicionar tarefa'} 
        value={task} 
        onChangeText={text => setTask(text)} 
        />
        <TouchableOpacity 
          style={styles.button}
          onPress={() => handleAddTask()}
        >
          <MaterialCommunityIcons style={styles.plus} name="plus" color={"white"} size={25} />
        </TouchableOpacity>
      </KeyboardAvoidingView>
      
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
   
  },
  button: {
    opacity: 100,
    width: 50,
    height: 50,
    backgroundColor: "#CF4646",
    justifyContent: 'center',
    borderRadius: 50,
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
    bottom: 30,
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
    borderRadius: 60,
    borderColor: '#C0C0C0',
    borderWidth: 1,
    width: 250,
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
});



/* O B S E R V A Ç Õ E S:

MELHORAS:
- apertar no circula a direita e ele ficar preenchido
- o quadrado a esquerda ficar transparente -> Deixando em vermelho as tarefas mais importantes
- 
 

VÍDEOS FONTE:
- https://www.youtube.com/watch?v=0kL6nhutjQ8
- https://www.youtube.com/watch?v=00HFzh3w1B8
GITHUB:
- https://github.com/mattfrances/simpleReactNativeTodoList
 */
