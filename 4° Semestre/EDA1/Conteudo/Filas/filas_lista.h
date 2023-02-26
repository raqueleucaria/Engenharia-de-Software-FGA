typedef struct no {
    int dado;
    struct no *prox;
} no;

typedef struct {
    no *le;
} fila;

fila *cria_fila ();
int enfileira (fila *f, int x);
int desenfileira (fila *f, int *y);
void destroi_fila (fila *f);
void imprime_fila (fila *f);