#include <stdio.h>
#include <stdlib.h>

int main(int argc, char const *argv[])
{
    int n, m, i;
    scanf("%d %d", &n, &m);
    int *N = malloc(n * sizeof(int)), *M = malloc(m * sizeof(int));
    for (i = 0; i < n; i++)
    {
        scanf("%d", &N[i]);
    }
    for (i = 0; i < m; i++)
    {
        scanf("%d", &M[i]);
    }

    int d, e, meio;

    for (i = 0; i < m; i++)
    {
        d = n - 1;
        e = 0;

        if (M[i] > N[n - 1])
        {
            printf("%d\n", n);
        }
        else
        {
            if (M[i] < N[0])
            {
                printf("0\n");
            }
            else
            {
                do
                {

                    meio = (e + d) / 2;
                    if (N[meio] < M[i] && M[i] <= N[meio + 1])
                    {
                        printf("%d\n", meio + 1);
                        break;
                    }
                    else
                    {
                        if (N[meio] < M[i])
                        {
                            e = meio + 1;
                        }
                        else
                        {
                            d = meio - 1;
                        }
                    }
                } while (e <= d || e == d);
            }
        }
    }

    return 0;
}