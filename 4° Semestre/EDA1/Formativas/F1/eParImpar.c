#include <stdio.h>

int main (){
    
    int pares, impares;
    int somaPar=0, somaImpar=0, numero=1;


    while(numero!=0)
    {
        scanf("%d", &numero);
        if (numero % 2==0)
        {
            somaPar+= numero;
            
        } else somaImpar+= numero;
        
    }

    printf("%d %d\n",somaPar, somaImpar);
    
    return 0;
}