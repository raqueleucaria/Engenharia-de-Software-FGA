#include <stdio.h>
#include <stdlib.h>
#include "filas_lista.h"

fila *cria_fila () {   
    fila *f = malloc (sizeof (fila));
    f->le = malloc (sizeof (no));
    f->le->prox = f->le;
    return f;
}

int enfileira (fila *f, int x) {
    no *novo = malloc (sizeof (no));
    novo->prox = f->le->prox;
    f->le->prox = novo;
    f->le->dado = x;
    f->le = novo;
    return 0;
}

int desenfileira (fila *f, int *y) {
    no *lixo = f->le->prox;
    if (lixo == f->le) return 1;
    *y = lixo->dado;
    f->le->prox = lixo->prox;
    free (lixo);
    return 0;
}

void destroi_fila (fila *f) {
    int dummy;
    while (desenfileira (f, &dummy) == 0);
    free (f->le);
    free (f);
}

void imprime_fila (fila *f) {
    no *p;
    for (p = f->le->prox; p != f->le; p = p->prox)
        printf (" -----");
    printf ("\n");
    
    for (p = f->le->prox; p != f->le; p = p->prox)
        printf ("| %3d ", p->dado);
    printf ("|\n");

    for (p = f->le->prox; p != f->le; p = p->prox)
        printf (" -----");
    printf ("\n");

    printf ("   p  ");
    
    for (p = f->le->prox; p->prox != f->le; p = p->prox)
        printf ("      ");
    printf ("   u\n");
}