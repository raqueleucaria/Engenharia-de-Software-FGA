#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct no
{
    char *palavra;
    struct no *prox;
} no;

no *cria_pilha()
{
    no *topo;
    topo = malloc(sizeof(no));
    topo->prox = NULL;
    return topo;
}

int empilha(no *topo, char *str)
{
    no *novo = malloc(sizeof(no));

    if (novo == NULL)
        return 1;

    novo->palavra = str;
    novo->prox = topo->prox;
    topo->prox = novo;

    return 0;
}

int desempilha(no *topo)
{
    no *lixo = topo->prox;
    if (lixo == NULL)
    {
        printf("NULL\n");
        return 1;
    }
    printf("%s\n", lixo->palavra);
    topo->prox = lixo->prox;
    free(lixo);
    return 0;
}

int op(char *s)
{
    char *insere = "inserir";
    char *desfaz = "desfazer";

    int inserir;
    int desfazer;

    inserir = strcmp(s, insere);
    desfazer = strcmp(s, desfaz);

    if (inserir == 0)
    {
        return 1;
    }
    else if (desfazer == 0)
    {
        return 2;
    }
    else
    {
        return 0;
    }
}

int main()
{
    no *topo = cria_pilha();
    char a[10] = "";
    int opcao;

    while (scanf("%s", a) != EOF)
    {
        opcao = op(a);
        if (opcao == 1)
        {
            char *str = calloc(101, sizeof(char));
            scanf("%[^\n]s", str);
            empilha(topo, str);
        }
        else if (opcao == 2)
        {
            desempilha(topo);
        }
        else
        {
            printf("Operacao invalida\n");
        }
    }

    return 0;
}