#include <stdio.h>

int main (){
    
    int x;
    int quantidade = 0;

    while (scanf("%d", &x) != EOF)
    {
        quantidade++;
        
    }

    printf("%d\n",quantidade);

    return 0;
}