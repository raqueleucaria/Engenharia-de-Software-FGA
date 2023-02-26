#include <stdio.h>
#include <stdlib.h>

typedef struct pilha {
  int *dados;
  int N, topo;
} pilha;

int empilha (pilha *p, int x){
    if(p->topo==p->N){
        p->dados=realloc(p->dados,2*p->N*sizeof(int));
        if(p->dados==NULL) return 0;
        p->N*=2;
    }
    p->dados[p->topo]=x;
    p->topo++;
    return 1;
}
