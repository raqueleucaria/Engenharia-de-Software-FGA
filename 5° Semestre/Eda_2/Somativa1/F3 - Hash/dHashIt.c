// ----Input----
//1
// 11
// ADD:marsz
// ADD:marsz
// ADD:Dabrowski
// ADD:z
// ADD:ziemii
// ADD:wloskiej
// ADD:do
// ADD:Polski
// DEL:od
// DEL:do
// DEL:wloskiej
// --------------


#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char c[109][20];
int tam = 0;

int tabela(char *k) {
    int h = 0;
    for (int i = 0; k[i] != '\0'; i++) h += k[i] * (i+1LL);
    return (h * 19) % 101;
}
int procura(char *s) {
    int h = tabela(s);
    for (int j = 0; j < 20; j++) {
        int i = (h + j*j + 23LL*j) % 101;
        if (strcmp(c[i], s) == 0)  return 1;
    }
    return 0;
}
void insert(char *s)
{
    if (procura(s)) return;
    int h = tabela(s);
    for (int j = 0; j < 20; j++) {
        int i = (h + j*j + 23LL*j) % 101;
        if (*c[i] == '\0') {
            strcpy(c[i], s);
            tam++;
            break;
        }
    }
}
void delete(char *s) {
    int h = tabela(s);
    for (int j = 0; j < 20; j++) {
        int i = (h + j*j + 23LL*j) % 101;
        if (strcmp(c[i], s) == 0) {
            *c[i] = '\0';
            tam--;
        }
    }
}
int main() {
    int t;
    scanf(" %d", &t);
    while (t--) {
        for (int i = 0; i < 101; i++)  *c[i] = '\0';
        tam = 0;

        int n;
        scanf(" %d", &n);
        char m[4], s[16];
        while (n--) {
            scanf(" %s:%s", m, s);
            if (m[0] == 'A')  insert(s);
            else  delete(s);
        }
        printf("%d\n", tam);
        for (int i = 0; i < 101; i++)
            if (*c[i] != '\0')  printf("%d:%s\n", i, c[i]);
    }
    return 0;
}
