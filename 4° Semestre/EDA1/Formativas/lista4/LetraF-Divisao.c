#include <stdio.h>
#include <stdlib.h>

typedef struct celula {
  int dado;
  struct celula *prox;
} celula;

void divide_lista (celula *l, celula *l1, celula *l2){
if(l->prox==NULL)
{
return;
}
  if(l->prox->dado%2!=0)
    {
      l1->prox=l->prox;
      l->prox=l->prox->prox;
      l1->prox->prox=NULL;
      divide_lista(l,l1->prox,l2);
    }
  else{
      l2->prox=l->prox;
      l->prox=l->prox->prox;
      l2->prox->prox=NULL;
    divide_lista(l,l1,l2->prox);
    }
}