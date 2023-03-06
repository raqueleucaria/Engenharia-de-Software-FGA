#include <stdio.h>
int main(){

   int contaDaAgua;
   int qtdDeUso;
   int assinutraBasica=7;
scanf("%d",&qtdDeUso);

if (qtdDeUso<= 10){

    printf("%d\n",assinutraBasica);

}
else if( qtdDeUso > 10 && qtdDeUso <= 30){

    int contaDaAgua = 7 + (qtdDeUso-10);
    printf("%d\n",contaDaAgua);
}else if(qtdDeUso > 30 && qtdDeUso <= 100 ){

    int contaDaAgua = assinutraBasica +20+ ((qtdDeUso-30)*2);
    printf("%d\n",contaDaAgua);
}else{

    int contaDaAgua = assinutraBasica+ 20+140+((qtdDeUso-100)*5);
    printf("%d\n",contaDaAgua);
}


    return 0;
}