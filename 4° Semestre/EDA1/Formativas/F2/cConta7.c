#include <stdio.h>
#include <stdlib.h>

void conta7(long int numero, int *contador){
    if (numero != 0){
        if (numero%10==7) {(*contador)++;}
        conta7(numero/10, contador);
   
    } 
}

int main(){
	long int numero;
    int contador = 0;

    scanf("%lu", &numero);
    conta7(numero, &contador);
    printf("%d\n", contador);

    return 0;
}