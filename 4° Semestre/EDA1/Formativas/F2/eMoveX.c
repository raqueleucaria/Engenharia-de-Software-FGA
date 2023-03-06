#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int contaX = 0;

void imprimeX(int n) {
    if (n>0) {
        printf("x");
        imprimeX(n-1);
    }
}

void imprimeS(char str[]) {
    if (*str) {
        if (*str=='x') {
            contaX++;
            imprimeS(str+1);
        } 
        else {
            printf("%c",*str);
            imprimeS(str+1);
        }
    } 
    else {
        imprimeX(contaX);
        printf("\n");
    }
}

int main() {
    char str[100];

    scanf("%[^\n]", str);
    imprimeS(str);
    
    return 0;
}