typedef struct no {
    int dado;
    struct no *prox;
} pilha;

pilha *cria_pilha ();
int empilha (pilha *topo, int x);
int desempilha (pilha *topo, int *y);
void destroi_pilha (pilha *topo);
void imprime_pilha (pilha *topo);