#include <stdio.h>
#include <stdlib.h>

void sel (int *v, int tam) {

    int i, j;
    int min, x;


    for (i = 0; i < tam - 1; ++i)
    {
        min = i;

        for (j = i+1; j < tam; ++j) 
        {
            if (v[j] < v[min]) min = j;
        }
        
        x = v[min]; 
        v[min] = v[i];
        v[i] = x;
    }

}

void printSel (int *v, int tam) {
    
    for (int i = 0; i < tam; i++)  printf("%d ", v[i]);
    printf("\n");
}

int main (void) {

    int v[1000], tam = 0, num;

    while (scanf("%d", &num) != EOF) {
        v[tam] = num;
        tam++;
    }
    
    sel(v, tam);
    printSel(v, tam);

    return 0;
}