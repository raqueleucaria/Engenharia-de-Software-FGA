#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void imprime(char str[]){
	if(*str!='\0'){
        if (*str=='x') printf("%c", 'y');
        else printf("%c", *str);
		imprime(++str);
    }
}

int main () {
	char str[500]; // = malloc(500);

	scanf("%s",str);
	imprime(str);
	printf("\n");

	return 0;
}