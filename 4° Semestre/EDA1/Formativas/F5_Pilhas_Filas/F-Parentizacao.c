#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct cel
{
    int dado;
    struct cel *prox;
} cel;

cel *cria_pilha()
{
    cel *topo = malloc(sizeof(cel));
    topo->prox = NULL;
    return topo;
}

void empilha(cel *p, int x)
{
    cel *ponteiro = malloc(sizeof(cel));
    ponteiro->dado = x;
    ponteiro->prox = p->prox;
    p->prox = ponteiro;
}

int desempilha(cel *p)
{
    char desempilhado;
    cel *lixo = p->prox;

    if (lixo == NULL)
    {
        return 0;
    }

    desempilhado = lixo->dado;
    p->prox = lixo->prox;
    return desempilhado;
    free(lixo);
}

int main()
{
    int i = 0, balanceado = 0, abre = 0, objeto = 0, fecha = 0;
    char exp[500];
    cel *p = cria_pilha();

    scanf("%[^\n]", exp);

    for (i = 0; i < strlen(exp); i++)
    {
        if (exp[i] == '(')
        {
            empilha(p, exp[i]);
            abre++;
        }

        if (exp[i] == '[')
        {
            empilha(p, exp[i]);
            abre++;
        }

        if (exp[i] == '{')
        {
            empilha(p, exp[i]);
            abre++;
        }

        if (exp[i] == ')')
        {
            fecha++;
            objeto = desempilha(p);
            if (objeto == 0)
            {
                balanceado++;
            }
            if (objeto == 40)
            {
                balanceado++;
            }
        }

        if (exp[i] == ']')
        {
            fecha++;
            objeto = desempilha(p);
            if (objeto == 0)
            {
                balanceado++;
            }
            if (objeto == 91)
            {
                balanceado++;
            }
        }

        if (exp[i] == '}')
        {
            fecha++;
            objeto = desempilha(p);
            if (objeto == 0)
            {
                balanceado++;
            }
            if (objeto == 123)
            {
                balanceado++;
            }
        }
    }

    if (balanceado == abre && fecha == abre)
    {
        printf("sim\n");
    }
    else
    {
        printf("nao\n");
    }

    return 0;
}