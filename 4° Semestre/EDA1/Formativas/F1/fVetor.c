#include <stdio.h>

int main(){
    
    int qt, menor, numero, tamanho, valor;
    int vetor[qt];

    scanf("%d\n", &qt);
    tamanho = qt -1;

    for (int i = 0; i < tamanho; i++)
    {
        scanf("%d ", &numero);
        vetor[i]=numero;

        if (vetor[i] < menor)
        {
            menor = i;
        //valor = vetor[i];
        }
    }
    
    printf("%d\n",menor);
    //printf("%d\n",valor);

    return 0;
}