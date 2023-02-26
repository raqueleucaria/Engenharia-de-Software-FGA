#include <stdio.h>
int main(){

int aeroporto[100];
int a ,v;
int i, origem ,destino;
int teste;
int maior;

scanf("%d%d",&a ,&v);
while (a !=0 || v!=0)
{
    //iniciliza
    for(i=0; i<a; i++){
        aeroporto[i] =0;
    }

    //conta frequecnia devoos em cada aeroporto

    for ( i = 0; i < v; i++)
    {
        scanf("%d%d",&origem,&destino);
        aeroporto[origem-1]++;
        aeroporto[destino-1]++;
    }




    //econtra mairo elemnto do vetor aeroporto

    maior = aeroporto[0];
    for ( i = 1; i < a; i++)
    {
       if (aeroporto[i]> maior)
       {
        maior = aeroporto[i];
       }
       
    }
    //imprimir resultado do caso do teste
    printf("Teste %d\n",teste);
    for(i=0; i<a; i++){
        if (aeroporto[i]==maior)
        {
            printf("%d",i+1);
            printf("\n\n");
            
            
        }
        
    }


    scanf("%d%d",&a,&v);
    
    
   
}





    return 0;


}