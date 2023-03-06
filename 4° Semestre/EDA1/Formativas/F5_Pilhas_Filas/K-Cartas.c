#include <stdio.h>
#include <stdlib.h>

typedef struct cel
{
    int dado;
    struct cel *prox;
} cel;

cel *cria_pilha()
{
    cel *novo = malloc(sizeof(cel));
    novo->prox = novo;
    return novo;
}

cel *empilhar(cel *pilha, int x)
{
    cel *ponteiro = malloc(sizeof(cel));
    ponteiro->prox = pilha->prox;
    pilha->prox = ponteiro;
    pilha->dado = x;
    return ponteiro;
}

int desempilhar(cel *f)
{
    int numero = 0;
    cel *retirar = f->prox;
    if (f->prox == f)
    {
        return 0;
    }
    else
    {
        numero = retirar->dado;
        f->prox = retirar->prox;
        free(retirar);
        return numero;
    }
}

int main()
{

    int cartas, num = 0;
    int i = 0, contador = 0;
    cel *pilha = cria_pilha();

    scanf("%d", &cartas);

    for (i = 1; i <= cartas; i++)
    {
        pilha = empilhar(pilha, i);
    }

    printf("Cartas descartadas:");
    contador = 1;

    for (contador = cartas; contador >= 1; contador--)
    {
        if (contador > 2)
        {
            printf(" %d", desempilhar(pilha));
            printf(",");
            num = desempilhar(pilha);
            pilha = empilhar(pilha, num);
        }

        if (contador == 2)
        {
            printf(" %d\n", desempilhar(pilha));
        }

        if (contador == 1)
        {
            printf("Carta restante:");
            printf(" %d\n", desempilhar(pilha));
        }
    }

    return 0;
}