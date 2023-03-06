#include <stdio.h>
#include <stdlib.h>

typedef struct celula {
    int dado;
    struct celula *prox;
} celula;

void insere_inicio (celula *le, int x){
    celula *n = malloc(sizeof(celula)); // conversão forçada cast
    n -> dado = x;
    n -> prox = le -> prox; // apontando sucessor
    le -> prox = n; // anterior apontando para o novo
};

void insere_antes (celula *le, int x, int y){
    celula *a = malloc(sizeof(celula));
    a -> dado = x;
    celula *p = le -> prox;
    
    if(p -> dado == y)
    {
        a -> prox = p;
        le -> prox = a;
        return;
    }
    
    if(le -> prox == NULL)
    {
        le -> prox = a;
        return;
    }

    while(p -> prox != NULL)
    {
        celula *t = p;
        p = p -> prox;
        if (p -> dado == y){
            a -> prox = p;
            t -> prox = a;
            return;
        }
    }
    p -> prox = a;
}