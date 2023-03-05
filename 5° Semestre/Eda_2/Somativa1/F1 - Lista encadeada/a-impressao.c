#include <stdio.h>
#include <stdlib.h>

typedef struct celula {
    int dado;
    struct celula *prox;
} celula;

void imprime (celula *le){
    celula * elemento;
    for (elemento = le -> prox; elemento!= NULL; elemento= elemento->prox) 
        printf ("%d -> ", elemento -> dado);
    printf ("NULL\n");
};

void imprime_rec (celula *le){
    if (le -> prox!=NULL){
        printf ("%d -> ", le -> prox -> dado);
        imprime_rec(le -> prox);
        // Inversão da impressão
        // imprime_rec(le -> prox);
        // printf ("%d -> ", le -> prox -> dado);
    } else {
        printf ("NULL\n");
    }
};