#include <stdio.h>
int main()
{

   int inteiro;
   int menor;
   int menorINd;

   scanf("%d", &inteiro);
   if (inteiro >= 5 && inteiro <= 10000)
   {
      int array[inteiro];
      for (int i = 0; i < inteiro; i++)
      {
         scanf("%d", &array[i]);
      }
      int k;
      
      for (int j = 0; j < inteiro; j++)
            {
               if (menor > array[j])
               {
                  menor = array[j];
                  menorINd = j;
               }

      }
    
  
     
          printf("%d\n",menorINd);
     
     


      
   }

   return 0;
}
