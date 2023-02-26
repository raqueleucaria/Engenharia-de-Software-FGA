#include<stdio.h>
void f(char *s, char a, char b);
int main()
{
        char str[100],a,b;
        scanf("%s",str);
        a= 'x';
        b='y';

        f(str,a,b);
        printf("%s\n",str);
        
        return 0;
}
void f(char *str, char a, char b)
{
    if(*str=='\0')
                return;
    if(*str==a)
                *str=b;
        f(str+1,a,b);
}