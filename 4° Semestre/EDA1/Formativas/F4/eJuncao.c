#include <stdio.h>
#include <stdlib.h>

typedef struct celula {
    int dado;
    struct celula *prox;
} celula;

void mescla_listas (celula *l1, celula *l2, celula *l3){
    l1 = l1 -> prox;
    l2 = l2 -> prox;
    
    while(l1 != NULL && l2 != NULL){ // Termina quando UM chegar no NULL
        if (l1 -> dado < l2 -> dado) {
            //inserir o l1 em l3
            l3 -> prox = l1; // tras o 1 ...
            l1 = l1 -> prox;

        }
        else {
            // inserir l2 em l3
            l3 -> prox = l2; // tras o 2 ...
            l2 = l2 -> prox;
        }

        l3 = l3 -> prox;
    }
    // depois que um chega ao null, pega o restante da outra que não terminou 
    if (l1 == NULL) l3 -> prox =l2;
    else l3 -> prox = l1;

}

int main (){
    celula l1;

    celula l11;
    l11.dado = 1;
    celula l12;
    l12.dado = 7;
    celula l13;
    l13.dado = 9;
    celula l14;
    l14.dado = 10;

    l1.prox = &l11;
    l11.prox = &l12;
    l12.prox = &l13;
    l13.prox = &l14;
    l14.prox = NULL;

    // ---------------
    
    celula l2;

    celula l21;
    l21.dado = 2;
    celula l22;
    l22.dado = 3;
    celula l23;
    l23.dado = 8;

    l2.prox = &l21;
    l21.prox = &l22;
    l22.prox = &l23;
    l23.prox = NULL;

    celula l3;

    mescla_listas (&l1, &l2, &l3);

    printf("l3 -> ");
        for(celula *p = l3.prox; p != NULL; p = p -> prox)
            printf ("%d -> ", p -> dado);
        printf ("NULL\n");
    
    return 0;

}