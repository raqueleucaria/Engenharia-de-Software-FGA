#include <stdio.h>
#include <stdlib.h>

int v[1010];

int main() {
    int n;
    scanf(" %d", &n);

    int a = 0, b = 0;
    for (int i = 0; i < n; i++) {
        int x;
        scanf(" %d",&x);
        if (++v[x] > b) {
            b = v[x];
            a = x;
        }
        else if (v[x] == b && a < x) a = x;
    }
    
    printf("%d\n", a);
    return 0;
}
