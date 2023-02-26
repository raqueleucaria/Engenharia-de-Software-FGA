#include <stdio.h>
int main(){

    int posicao,i,j;
    int cinema[20][25];
  
    
   
  

    for (i = 0; i < 20; i++)
    {
       for (j = 0; j < 25; j++)
       {
        cinema[i][j]= 0;
       }
       
    }
    int linha,coluna;
    scanf("%d%d",&linha,&coluna);
    char letra;
    
   
  
    while ((scanf("%c%d",&letra,&posicao)!=EOF))
    {
        cinema[letra-65][posicao-1] =1;
        
    }
   
    printf(" ");
    for(i=1; i<= linha; i++){

    printf(" %02d",i); 
    
    }
    printf("\n");
  for ( i = linha-1; i >= 0; i--)
  {
    printf("%c",i+65);
    for (j =0; j<coluna;j++)
    {
      if (cinema[i][j]==0)
      {
        printf(" --");
      }else{
        printf(" XX");
      }
      
      
    }
    printf("\n");
    
  }
  
        

    
    
    
    
    
    

    
    
    
   
 
    
    


    return 0;
}