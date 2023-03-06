#include <stdio.h>
#include <stdlib.h>


typedef struct {
    int *dado;
    int topo, N;
} pilha;


pilha *cria_pilha () {
    pilha *p = malloc (sizeof (pilha));
    p->N = 3;
    p->dado = malloc (p->N * sizeof (int));
    p->topo = -1;
    return p;
}

int empilha (pilha *p, int x) {
    p->topo++;
    if (p->topo == p->N) {
        p->dado = realloc (p->dado, 2*p->N*sizeof (int));
        if (p->dado != NULL) p->N *= 2;
        else return 1;
    }
    p->dado[p->topo] = x;
    return 0;
}

int desempilha (pilha *p, int *y) {
    if (p->topo == -1) return 1;
    *y = p->dado[p->topo];
    p->topo--;
    return 0;
}

void destroi_pilha (pilha *p) {
    free (p->dado);
    free (p);
}

void imprime_pilha (pilha *p) {
    printf (" ---\n");
    for (int i = p->N-1; i >= 0; i--)
        if (i <= p->topo)
            printf("|%3d|\n ---\n", p->dado[i]);
        else
            printf("|   |\n ---\n");
    printf ("\n");
}