typedef struct {
    int *dados;
    int N, p, u;
} fila;

fila *cria_fila ();
int enfileira (fila *f, int x);
int desenfileira (fila *f, int *y);
void destroi_fila (fila *f);
void imprime_fila (fila *f);