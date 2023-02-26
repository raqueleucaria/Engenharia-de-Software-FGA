#include <stdio.h>
#include <stdlib.h>

void regua(int numero){
    if (numero!=0){
        regua(numero-1);
        printf(".");
        
        for (int i = 0; i< numero; i++) printf ("-");
        printf("\n");
        regua(numero-1);
    }
}

int main(){

    int entrada;
    scanf("%d",&entrada);    
    
    if (entrada >0)regua(entrada);

    return 0;
}