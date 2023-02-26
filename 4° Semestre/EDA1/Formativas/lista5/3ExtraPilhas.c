#include <stdio.h>
#include <stdlib.h>


typedef struct no {
    int dado;
    struct no *prox;
} pilha;


pilha *cria_pilha () {
    pilha *topo = malloc (sizeof (pilha));
    topo->prox = NULL;
    return topo;
}

int empilha (pilha *topo, int x) {
    // Inserir no inicio da lista encadeada
    pilha *novo = malloc (sizeof (pilha));
    if (novo == NULL) return 1;
    novo->dado = x;
    novo->prox = topo->prox;
    topo->prox = novo;
    return 0;
}

int desempilha (pilha *topo, int *y) {
    // Remove do inicio da lista
    pilha *lixo = topo->prox;
    if (lixo == NULL) return 1;
    *y = lixo->dado;
    topo->prox = lixo->prox;
    free (lixo);
    return 0;
}

void destroi_pilha (pilha *topo) {
    int dummy;
    while (desempilha (topo, &dummy) == 0);
    free (topo);
}

void imprime_pilha (pilha *topo) {
    printf ("topo\n  |\n  v\n ---\n");
    for (pilha *p = topo->prox; p != NULL; p = p->prox)
        printf("|%3d|\n ---\n", p->dado);
    printf ("\n");
}