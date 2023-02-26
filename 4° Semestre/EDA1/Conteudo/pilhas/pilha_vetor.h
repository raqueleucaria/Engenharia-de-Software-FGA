typedef struct {
    int *dado;
    int topo, N;
} pilha;

void cria_pilha (pilha *p);
int empilha (pilha *p, int x);
int desempilha (pilha *p, int *y);
void destroi_pilha (pilha *p);
void imprime_pilha (pilha p);