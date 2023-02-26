#include <stdio.h>
#include "pilha_lista.h"

int main () {
    int op, valor;
    pilha *p = cria_pilha ();

    do {
        printf ("MENU\n");
        printf ("1 - Empilha\n");
        printf ("2 - Desempilha\n");
        printf ("3 - Imprimir\n");
        printf ("4 - Sair\n");
        printf ("Escolha uma opcao: ");
        scanf ("%d", &op);

        switch (op) {
        case 1:
            printf ("Digite o valor a ser empilhado: ");
            scanf ("%d", &valor);
            if (empilha (p, valor) == 0)
                printf ("Elemento empilhado com sucesso.\n\n");
            break;
        case 2:
            if (desempilha (p, &valor) == 0)
                printf ("Valor desempilhado: %d\n\n", valor);
            else 
                printf ("Pilha vazia.\n\n");
            
            break;
        case 3:
            imprime_pilha (p);
            break;
        }
    } while (op != 4);

    destroi_pilha (p);

    return 0;
}