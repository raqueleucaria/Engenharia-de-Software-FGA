#include <stdlib.h>
#include <stdio.h>
#include <string.h>



typedef struct pilha
{
   int *vetor;
   int n, topo;
}pilha;

int Imprimirreverso(pilha *p,char x[]){

    if(p->topo==p->n){
        printf("nao tem espaco");
        return 0;
    }
    int i=0;
   for(int i=0; i<strlen(x);i++){
    p->vetor[p->topo] = x[i];
    p->topo++;

 }
}

pilha *cria_pilha(int lenghtstr){
    pilha *p = malloc(sizeof(pilha));
    p->n = lenghtstr;
    p->vetor = malloc(p->n*sizeof(int));
    p->topo=-1;
    return p;

}

void imprime_pilha (pilha *p) {
    printf (" ---\n");
    for (int i = p->n-1; i >= -1; i--)
        if (i <= p->topo)
            printf("|%c|\n ---\n", p->vetor[i]);
        else
            printf("|   |\n ---\n");
    printf ("\n");
}

int main(){
    

    char x[] = "contrarrio string";
    pilha *p = cria_pilha(strlen(x));
    Imprimirreverso(p,x);
    imprime_pilha(p);
    printf("\n%c\n",x[3]);


    return 0;
}