#include <stdio.h>
#include <stdlib.h>

void imprimir (int *v, int n) {
    for (int i = 0; i < n; i++) printf("%d%c", v[i], (i == n - 1 ? '\n' : ' '));
}
void merge(int *a, int tamA, int *b, int tamB) {
    int *temp = (int *)malloc((tamA + tamB) * sizeof(int));
    int i = 0, j = 0, k = 0;
    for (; i < tamA && j < tamB; k++) {
        if (a[i] <= b[j]) temp[k] = a[i++];
        else temp[k] = b[j++];
    }
    while (i < tamA)  temp[k++] = a[i++];
    while (j < tamB) temp[k++] = b[j++];
    for (k = 0, i = 0; i < (tamA + tamB); i++, k++) a[i] = temp[k];

    free(temp);
}

void mergesort(int *v, int n) {
    if (n < 2) return;
    int m = n / 2;
    mergesort(v, m);
    mergesort(&v[m], n - m);
    merge(v, m, v + m, n - m);
}

int v[100001];

int main() {
    int n = 0;
    for (; scanf(" %d", v + n) == 1; n++);

    mergesort(v, n);
    imprimir
    (v, n);

    return 0;
}
