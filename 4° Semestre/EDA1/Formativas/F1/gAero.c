#include <stdio.h>

int main (){
    int aeroporto[100];
    int A,V, i, maior, origem, destino, teste;

    teste = 1;
    scanf("%d %d",&A,&V);
    while (A!=0 || V!=0)
    {
        for (i=0; i< A;i++) aeroporto[i]=0; //inicializa
        
        for (i=0;i<V;i++) // conta a frequencia de voos em cada aeroporto
        {
            scanf("%d%d", &origem, &destino);
            aeroporto[origem-1]++;
            aeroporto[destino-1]++;
        }


        maior = aeroporto[0];
        for (i = 0; i < A; i++) //encontra o maior elemento do vetor aeroporto
            if (aeroporto[i] > maior) maior = aeroporto[i];


        printf("Teste %d\n", teste); //imprime o resultado do caso de teste
        for (i = 0; i < A; i++)
            if (aeroporto[i]==maior) printf("%d", i+1);
        
        printf("\n\n");
        teste++;
        
        scanf("%d%d", &A, &V);

    }

    return 0;
}