import React from 'react';
import { Image, StyleSheet ,View } from 'react-native';
import BoxChat from './layouts/Box';

/*
---------------------------------------------------------------------------------------------------------
                    **  TROCAR A COR DOS QUADRADOS PARA BRANCO
                        APÓS OS TESTES
                    **  COLOCAR O NOTEBOOKBACKGROUND NA MESMA POSIÇÃO DO MAIN
---------------------------------------------------------------------------------------------------------
*/
export default function Home({  }) {
  return (
    <>
    <Main />
    {/* <NotebookBackground /> */}
    </>
  );
}

/*
---------------------------------------------------------------------------------------------------------
                            Funções
---------------------------------------------------------------------------------------------------------
*/

const Main = () => {
  return(
    <>
    <View>
      <Image 
            source={require('../../assets/aplication/marcador.png')}
            style={styles.Logo}
      />
      <View style={styles.container}>
          {/* LOGO */}
          
          

          <View style={styles.shadows}>
            <BoxChat 
              color='#FFF'
              event01='Eventos Próximos: '
              event02='04/07 - PROVA 01 - Cálculo' event1={undefined} event2={undefined} />
          </View>

          <View style={styles.shadows}>
            <BoxChat 
              color='#FFF'
              event01='Tarefas:'
              event02='Fazer a lista 1' event1={undefined} event2={undefined} />
          </View>
        </View>
      </View>
    </>
  )
}

const NotebookBackground = () => {
  return(
    <View>
      <Image 
        source={require('../../assets/aplication/notebook.jpg')}
        style={styles.background}
      />
    </View>
  )
}
const styles = StyleSheet.create({
  shadows: {
    borderRadius: 15,
    shadowOpacity: 0.5,
    shadowColor: "#000",
    shadowOffset: {
      width: 0,
      height: 4,
    },
    shadowRadius: 10,
    elevation: 10,
    marginVertical: 10,
  },
  container: {
    flexGrow: 1,
    alignItems: 'center',
    justifyContent: 'space-evenly',
    //backgroundColor: 'E5E5E5',
  },
  Logo: {
    //alignItems:'stretch',
    //justifyContent:'space-between',
    //right: '10%',
    height: '10%',
    width: '50%',
    marginTop: 25,
    marginVertical: 20,
    
  },
  background:{
    height: '100%',
    width: '100%',
    position:'absolute',
  }
});
