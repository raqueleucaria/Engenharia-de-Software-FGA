#include <stdio.h>
#include <stdlib.h>


typedef struct celula {
    int dado;
    struct celula *prox;
} celula;

void insere_inicio (celula *le, int x){
    celula *novo = (celula *) malloc(sizeof(celula)); // conversão forçada cast
    novo -> dado = x;
    novo -> prox = le ->prox;
    le -> prox = novo;
};

void insere_antes (celula *le, int x, int y){
    celula *antes = le;
    
    for (celula *p = le -> prox; p != NULL && p -> dado !=y ; p = p -> prox){ // percorre até não chegar a null ou = y
        antes == p; // a cada interação o 'antes' armazena o local antes do y ou do null
   
        insere_inicio (antes, x);


    };

    //antes nunca vai ser igual a null - se a lista estiver vazia antes = le
   
    //celula *novo = (celula *) malloc(sizeof(celula)); /*b*/ //malloc cria uma nova caixinha
	//novo -> dado = x;
	//novo -> prox = antes -> prox; 
	//antes -> prox = novo;	
};


