#include <stdio.h>
#include <stdlib.h>

typedef struct celula {
  int dado;
  struct celula *prox;
} celula;

celula *busca (celula *le, int x){
  celula *elem;
elem=le;
 while (elem != NULL && elem->dado != x) 
      elem = elem->prox; 
return elem;
}


celula *busca_rec (celula *le, int x){
if (le == NULL)  return NULL;
   if (le->dado == x)  return le;
   return busca_rec ( le->prox,x);
   }