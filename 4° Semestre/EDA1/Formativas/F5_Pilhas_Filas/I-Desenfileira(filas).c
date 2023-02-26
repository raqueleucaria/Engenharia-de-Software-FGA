#include <stdio.h>
#include <stdlib.h>


typedef struct celula {
  int dado;
  struct celula *prox;
} celula;

typedef struct {
    celula *le;
} fila;


int desenfileira (celula *f, int *y) {
    celula *lixo = f->le->prox;
    if (lixo == f->le) return 1;
    *y = lixo->dado;
    f->le->prox = lixo->prox;
    free (lixo);
    return 0;
}
