#include <stdio.h>

int main (){
    
    int consumo, conta;

    scanf("%d", &consumo);

    if (consumo <= 10)
    {
        conta = 7;
    } else if (consumo <= 30)
    {
        conta = (consumo-10)  + 7;
    } else if (consumo <= 100)
    {
        conta = ((consumo-30) * 2 ) + 27;
    } else conta = ((consumo-100) * 5 ) + 167;

    printf("%d\n",conta);
    
    return 0;
}