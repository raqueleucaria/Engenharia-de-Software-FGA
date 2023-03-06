#include <stdio.h>
#define TAM 101
 
int main(){
 int aeroportos, voos, X, Y, infos[TAM], n = 0, i, maior;
 
 scanf("%i %i", &aeroportos, &voos);
 
 while ( aeroportos != 0 && voos != 0 ) {
  for (i=0; i <= aeroportos; i++) {
   infos[i] = 0;
  }
 
  for (i=0; i < voos; i++) {
   scanf("%i %i", &X, &Y);
   infos[X]++;
   infos[Y]++;
  }
 
  //encontra o maior
  maior = 0;
  for (i=1; i <= aeroportos; i++) {
   if (infos[i] >= maior) {
    maior = infos[i];
   }
  }
 
  n++;
  printf("Teste %i\n", n);
 
  for (i=0; i <= aeroportos; i++) {
   if (infos[i] == maior) {
    printf("%i ", i);
   }
  }
 
  printf("\n\n");
 
  scanf("%i %i", &aeroportos, &voos);
 }
 
 return 0;
}