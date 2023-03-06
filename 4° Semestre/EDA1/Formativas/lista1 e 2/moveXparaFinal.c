#include <stdio.h>
#include <string.h>

int contXs(char*string){

    int cont=0;

    if (*string=='x') {
        cont++;
        return cont+ contXs(string+1);
    }else{
        if (*string =='\0'){
            return 0;
        }
        return contXs(string+1);
    }
}

int imprimeXs(int total){

    if (total > 0){
        printf("%c",'x');
        return imprimeXs(total - 1);
    }

    if (total == 0) { 
        return 0;
    }
}

void imprimex(char*string){

    if (*string != 'x' && *string != '\0'){
        printf("%c",string[0]);
        if(string+1!='\0'){
            imprimex(string+1);
        }
    }

    if(*string=='x'){
        if(string+1!='\0'){
            imprimex(string+1);
        }
#include <stdio.h>
#include <string.h>

int contXs(char*string){

    int cont=0;

    if (*string=='x') {
        cont++;
        return cont+ contXs(string+1);
    }else{
        if (*string =='\0'){
            return 0;
        }
        return contXs(string+1);
    }
}

int imprimeXs(int total){

    if (total > 0){
        printf("%c",'x');
        return imprimeXs(total - 1);
    }

    if (total == 0) { 
        return 0;
    }
}

void imprimex(char*string){

    if (*string != 'x' && *string != '\0'){
        printf("%c",string[0]);
        if(string+1!='\0'){
            imprimex(string+1);
        }
    }

    if(*string=='x'){
        if(string+1!='\0'){
            imprimex(string+1);
        }

    }else{
        return;
    }

}

int main(){

    char frase[110];

    scanf("%s",frase);

    int contadorDeXs= contXs(frase);

    imprimex(frase);

    imprimeXs(contadorDeXs);
    
    printf("\n");


}    }else{
        return;
    }

}

int main(){

    char frase[110];

    scanf("%s",frase);

    int contadorDeXs= contXs(frase);

    imprimex(frase);

    imprimeXs(contadorDeXs);
    
    printf("\n");


}