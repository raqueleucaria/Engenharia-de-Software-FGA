#include<stdio.h>
#include<stdlib.h>

typedef struct celula {
   int dado;
   struct celula *prox;
} celula;

int remove_depois (celula *p){
if(p->prox==NULL){
   return 1;
}
else{
   celula *lixo;
   lixo=p->prox;   
   p->prox=lixo->prox;
   return 0;
}
}


void remove_elemento (celula *le, int x){
if (le->prox!=NULL){
if (le->prox->dado!=x){
remove_elemento(le->prox,x);
}else{
   le->prox=le->prox->prox;
}
}
}


void remove_todos_elementos (celula *le, int x){
if (le->prox!=NULL){
if (le->prox->dado!=x){
remove_todos_elementos(le->prox,x);
}else{
 remove_todos_elementos(le->prox,x);  
   le->prox=le->prox->prox;
}
}
}