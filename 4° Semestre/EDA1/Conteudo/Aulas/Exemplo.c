// exemplo: Encontre o maior elemento de um vetor ---->> vendo a quantidade de operações

#include <stdio.h>

int main (int v[], int n){
    int m = v[0]; // 1 operação

    for (int i=1;i<n;i++) //operação de atribuição, compaação e incremento --- faz n-1 interações(voltas)
        if(m<v[i]) // operação de comparação dentro do laço repetido n-1 vezes
            m=v[i]; // varia uma quantidade incerta -> no máximo n-1 vezes
    return 0; // 1 operação

}

// resulta em 4n-1 operações
/*
Para esse problema: 
- Melhor caso ----> quando v[0] é a maior. Linha 10 é executada zero vezes ------> #operação = 3n
- Pior caso ----> quando o vetor esta em ordem crescente (estrita). Linha 10 roda n-1 vezes ------> operação = 4n-1
- Caso médio ---> (n-1)/2 #operação = (7/2)n - (1/2)




*/