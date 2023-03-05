#include <stdio.h>
#include <stdlib.h>

void imprimir(int *v, int n){
    for (int i = 0; i < n; i++)
        printf("%d%c", v[i], (i == n - 1 ? '\n' : ' '));
}

void intercala(int *a, int tamA, int *b, int tamB){
    int *temp = (int *)malloc((tamA + tamB) * sizeof(int));
    int i = 0, j = 0, k = 0;
    for (; i < tamA && j < tamB; k++){
        if (a[i] <= b[j])
            temp[k] = a[i++];
        else
            temp[k] = b[j++];
    }

    while (i < tamA) temp[k++] = a[i++];
    while (j < tamB) temp[k++] = b[j++];

    for (k = 0, i = 0; i < (tamA + tamB); i++, k++) a[i] = temp[k];

    free(temp);
}

int ans[800008], v[100001];

int main() {
    int n = 0;
    for (int i = 0; i < 8; i++) {
        int vsize = 0;
        scanf(" %d", &vsize);
        for (int j = 0; j < vsize; j++)
            scanf(" %d", &v[j]);
        intercala(ans, n, v, vsize);
        n += vsize;
    }
    imprimir(ans, n);
    return 0;
}
