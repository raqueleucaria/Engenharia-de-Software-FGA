#include <stdio.h>
#include <stdlib.h>

typedef struct celula {
    int dado;
    struct celula *prox;
} celula;

void insere_inicio (celula *le, int x) {
    celula *new = malloc(sizeof(celula));
    new->dado=x;
    new->prox=le->prox;
    le->prox=new;
}

void insere_antes (celula *le, int x, int y){
    celula *new=malloc(sizeof(celula));
    new ->dado=x;

    celula *temp;
    for(temp=le;temp!=NULL;temp=temp->prox){
        if(temp->prox==NULL){
            new->prox=temp->prox;
            temp->prox=new;
            break;
        }
        if(temp->prox->dado==y){
            new->prox=temp->prox;
            temp->prox=new;
            break;
            }
    }
    le=temp;
}
