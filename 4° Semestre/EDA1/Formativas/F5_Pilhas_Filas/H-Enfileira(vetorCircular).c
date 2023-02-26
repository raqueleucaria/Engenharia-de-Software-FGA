
#include <stdlib.h>
#include <stdio.h>

typedef struct fila {
  int *dados;
  int N, p, u;
} fila;



int redimensiona (fila *f) {
    // retorna 0 se der certo, 1 se der errado
    f->dados = realloc (f->dados, 2*f->N*sizeof (int));
    if (f->dados == NULL) return 1;
    for (int i = f->N; i < 2*f->N; i++) f->dados[i] = 0;
    if (f->p != 0) {
        if (f->N - f->p < f->u) {
            for (int i = f->N-1; i >= f->p; i--)
                f->dados[i+f->N] = f->dados[i];
            f->p += f->N;
        }
        else {
            for (int i = 0; i < f->u; i++)
                f->dados[i+f->N] = f->dados[i];
            f->u += f->N;
        }
    }
    f->N *= 2;
    return 0;
}

int enfileira (fila *f, int x) {
    if ((f->u+1)%f->N == f->p) // fila cheia
        if (redimensiona (f) != 0) return 1;
    f->dados[f->u] = x;
    f->u = (f->u + 1)%f->N;
    return 0;
}
