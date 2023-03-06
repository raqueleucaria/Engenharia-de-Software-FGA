#include<stdio.h>

typedef struct celula {
  int dado;
  struct celula *prox;
} celula;

int empilha (celula *p, int x){
celula *extra=malloc(sizeof(celula));
if (extra==NULL){
  return 0;
}
extra->dado=x;
extra->prox=p->prox;
p->prox=extra;

return 1;

}