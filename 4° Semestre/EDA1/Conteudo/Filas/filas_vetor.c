#include <stdio.h>
#include <stdlib.h>
#include "filas_vetor.h"

fila *cria_fila () {
    fila *f = malloc (sizeof (fila));
    f->dados = calloc (5, sizeof (int));
    f->p = f->u = 0; // fila vazia
    f->N = 5;
    return f;
}

int redimensiona (fila *f) {
    return 1;
}

int enfileira (fila *f, int x) {
    if ((f->u+1)%f->N == f->p) // fila cheia
        if (redimensiona (f) != 0) return 1;
    f->dados[f->u] = x;
    f->u = (f->u + 1)%f->N;
    return 0;
}

int desenfileira (fila *f, int *y) {
    if (f->p == f->u) return 1;
    *y = f->dados[f->p];
    f->p = (f->p + 1)%f->N;
    return 0;
}

void destroi_fila (fila *f) {
    free (f->dados);
    free (f);
}

void imprime_fila (fila *f) {
    int i;
/*
 ----- -----
|  10 | -30 |
 ----- -----
  p u               
 */
    for (i = 0; i < f->N; i++)
        printf (" -----");
    printf ("\n");
    
    for (i = 0; i < f->N; i++)
        printf ("| %3d ", f->dados[i]);
    printf ("\n");

    for (i = 0; i < f->N; i++)
        printf (" -----");
    printf ("\n");

    if (f->p < f->u) {
        for (i = 0; i < f->p; i++)
            printf ("      ");
        printf ("   p  ");
        for (i = f->p+1; i < f->u; i++)
            printf ("      ");
        printf ("   u\n");
    }
    else if (f->p > f->u) {
        for (i = 0; i < f->u; i++)
            printf ("      ");
        printf ("   u  ");
        for (i = f->u+1; i < f->p; i++)
            printf ("      ");
        printf ("   p\n");
    }
    else {
        for (i = 0; i < f->u; i++)
            printf ("      ");
        printf ("  p u\n");
    }
}