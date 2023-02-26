#include <stdlib.h>
#include <stdio.h>


int buscaBinaria(int *v, int n, int x) {
    
    //variaveis
    int valor;
    int final = -1;
    int k = n;
    

    //passarei por todos até o final
    while (final < k - 1) {

        valor = (final + k) / 2;

        if (v[valor] == x)
            return valor;

        else if (v[valor] < x)
            final = valor;

        else
            k = valor;
    }

    //fazendo a busca
    if (v[k] == x)
        return k;

    //finalizando  
    else
        return -1;
}

//funçao que faz a troca
void troca(int *a, int *b) {

    //apontando as variaveis com ponteiros
    int tmp = *a;
    *a = *b;
    *b = tmp;
}

//essa função irá passar por todos os valores e retornando atraves de recursao
void recursao(int *v, int n, int i) {
    if (i <= n - 1) {

        int minimo = i;


        for (int j = i + 1; j < n; j++)
            if (v[j] < v[minimo])
                minimo = j;

        //chamando a função troca
        troca(&v[minimo], &v[i]);

        //chamando a função recursao
        recursao(v, n, i + 1);
    }
}

int main() {

    //variaveis:
    int n;
    int m;
    int i;
    int j;
    int x;

    //lendo n e m
    scanf("%d%d", &n, &m);

    int v[n];
    int auxiliar[m];
    int salva[n];
    

    //passando por todas as posições
    for (i = 0; i < n; i++) {

        //lendo v na posição i
        scanf("%d", &v[i]);

        //salvando o conteudo de v na posição i em outra variavel.
        salva[i] = v[i];
    }

    //chamando a função recursao com outras variaveis
    recursao(v, n, 0);

    //passando por todas as posições
    for (j = 0; j < m; j++) {

        //lendo x
        scanf("%d", &x);

        //variavel auxiliar recebendo o conteúdo da função de busca
        auxiliar[j] = buscaBinaria(v, n, x);

        //para os casos que não temos o "final"
        if (auxiliar[j] != -1) {

            //passando por todas as posições
            for (i = 0; i < n; i++) {

                //verificando se oq foi salvo é igual ao que tinhamos
                if (salva[i] == x)

                    //variavel auxiliar recebendo a posição em que foi encontrado
                    auxiliar[j] = i;
            }
        }
    }

    //passando por todas as posições
    for (j = 0; j < m; j++)

        //finalmente printando o resultado da busca
        printf("%d\n", auxiliar[j]);

    return 0;
    
}