#include <stdio.h>
#include <stdlib.h>

unsigned long fibonacci();
unsigned long v[sizeof(int)] ;

unsigned long fibonacci(int n) {
   if (n <= 0)
      return -1;
   if((n <= 2)  && v[n] == 0) {
      v[n] = 1;
      printf("%lu ", v[n]);
   }
   else if (v[n] == 0) {
      v[n] = fibonacci(n-2) + fibonacci(n-1);
      printf("%lu ", v[n]);
   }

   return v[n];
}

int main(int argc, char* argv[]) {
   int in;
   printf("Entre com o tamanho da série: ");
   scanf("%d", &in);
   fibonacci(in);
   return 0;
}