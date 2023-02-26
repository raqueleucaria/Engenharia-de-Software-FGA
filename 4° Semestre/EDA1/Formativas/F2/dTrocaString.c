#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void imprime(char str[]){
	if(*str!='\0'){
        imprime(str+1);	
        printf("%c", *str);
    }
}

int main () {
	char str[500]; // = malloc(500);

	scanf("%s",str);
	imprime(str);
	printf("\n");

	return 0;
}