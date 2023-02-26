#include <stdio.h>
unsigned long int vetor[81];
int run[81];

long int fibonacci (int n){

    unsigned long int result = 0;

    if(n == 0)
        return 0;
    else if (n == 1 || n == 2)
        return 1;    

    if(run[n] == 1){
        return vetor[n];
    } else{
        result = fibonacci(n-1) + fibonacci(n-2);
        vetor[n] = result;
        run[n] = 1;
    }

    return result;
}
