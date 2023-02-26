#include <stdio.h>

int countardigito(long long int n);

int main(){
    long long int n;
    scanf("%lld",&n);


    
   if(n>=0 && n<=1000000000000){
    printf("%d\n",countardigito(n));}


    return 0;
}

int countardigito(long long int n){

    if(n==0){
        return 0;
    }
    int  digit = n%10;
    if (digit==7)
    {
       return 1+ countardigito(n/10);
    }
    return countardigito(n/10);
    
    

}