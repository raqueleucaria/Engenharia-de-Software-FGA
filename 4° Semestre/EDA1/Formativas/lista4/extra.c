#include <stdio.h>

typedef struct celula {
   int dado;
   struct celula* next;
}celula;


void printllist(celula *head){
   celula *temp = head;
   while (temp != NULL)
   {
    printf("%d ",temp->dado);
    temp = temp->next;
   }
   
}





int main(){


    celula n1,n2,n3;
    celula *head;

    n1.dado =55;
    n2.dado=60;
    n3.dado =70;
    head = &n1;
    n1.next = &n2;
    n2.next = &n3;
    n3.next = NULL;


   printllist(head);


    return 0;
}