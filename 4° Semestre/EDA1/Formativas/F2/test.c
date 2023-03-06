/*
        Aula 161: Faça uma função recursiva para calcular a soma de todos os valores de um vetor de inteiros.

        Escrito por Wagner Gaspar
        Março de 2021
*/

int soma(int v[], int tam){
    if(tam == 0) // caso base, vetor vazio
        return 0;
    else
        return v[tam - 1] + soma(v, tam - 1); // chamada recursiva
}

int main () {

    int vet[10] = {1,2,3,4,5,6,7,8,9,10};

    printf("Soma: %d\n", soma(vet, 10));

    return 0;
}