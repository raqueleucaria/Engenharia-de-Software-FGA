#include <stdio.h>
#include <stdlib.h>

void termo(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

void selectionSort(int arr[], int n) {
    int i, j, min;
    for (i = 0; i < n; i++) {
        min = i;

        for (j = i+1; j < n; j++)
        
        if (arr[j] < arr[min]) min = j;
        
        if(min!=i) termo(&arr[min], &arr[i]);
    }
}

int main(){
    int v[1000];
    int cont=0;

    while(scanf("%d",&v[cont])!=EOF) cont+=1;

    selectionSort(v,cont);
  
    for (int i =0;i<cont;i++) printf("%d ",v[i]);

    printf("\n");
    
    return 0;
}