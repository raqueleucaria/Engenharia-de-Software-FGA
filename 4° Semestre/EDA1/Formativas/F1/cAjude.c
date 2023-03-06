#include <stdio.h>

int main (){
    
    int x,y,z,somaDoutor, soma;

    scanf("%d %d %d", &x, &y,&z);
    scanf("%d", &somaDoutor);

    soma = x + y + z;

    if (soma == somaDoutor)
    {
        printf("Acertou\n");
    } else printf("Errou\n");
    
    return 0;
}