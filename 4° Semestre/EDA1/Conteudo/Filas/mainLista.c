#include <stdio.h>
#include "filas_lista.h"

int main () {
    int op, valor;
    fila *f = cria_fila ();

    do {
        printf ("MENU\n");
        printf ("1 - Enfileira\n");
        printf ("2 - Desenfileira\n");
        printf ("3 - Imprimir\n");
        printf ("4 - Sair\n");
        printf ("Escolha uma opcao: ");
        scanf ("%d", &op);

        switch (op) {
        case 1:
            printf ("Digite o valor a ser enfileirado: ");
            scanf ("%d", &valor);
            if (enfileira (f, valor) == 0)
                printf ("Elemento enfileirado com sucesso.\n\n");
            else
                printf ("Nao foi possivel enfileirar o elemento.\n\n");
            break;
        case 2:
            if (desenfileira (f, &valor) == 0)
                printf ("Valor desenfileirado: %d\n\n", valor);
            else 
                printf ("Fila vazia.\n\n");
            
            break;
        case 3:
            imprime_fila (f);
            break;
        }
    } while (op != 4);

    destroi_fila (f);

    return 0;
}