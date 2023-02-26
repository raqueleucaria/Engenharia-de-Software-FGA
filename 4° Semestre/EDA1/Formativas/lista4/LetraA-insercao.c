#include <stdio.h>
#include <stdlib.h>

typedef struct celula {
  int dado;
  struct celula *prox;
} celula;

void insere_inicio (celula *le, int x) {
 celula *new = malloc(sizeof(celula));
new->dado=x;
new->prox=le->prox;
le->prox=new;
}

void insere_antes (celula *le, int x, int y){
celula *new=malloc(sizeof(celula));
new ->dado=x;

celula *temp;
for(temp=le;temp!=NULL;temp=temp->prox){
if(temp->prox==NULL){
  new->prox=temp->prox;
  temp->prox=new;
  break;
}
if(temp->prox->dado==y){
  new->prox=temp->prox;
  temp->prox=new;
  break;
}
}
le=temp;
}
// int main(){



  //  celula one,two,three;
  //  one.dado =10;
    //one.prox = &two;
    //two.dado =11;
    //two.prox = &three;
    //three.dado = 13;
    //three.prox = NULL;

    

  
 //   celula *current = &one;
   // addFirst(&current,5);
 //  insere_antes(&current,12,11);
 //   while(current!= NULL){
 //       printf("%d\n",current->dado);
 //       current = current->prox;  // 
 //   }
  
    




//    return 0;
 //}
// 