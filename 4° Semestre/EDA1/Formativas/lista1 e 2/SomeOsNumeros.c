#include <stdio.h>


int main(){

    int n;
    int par=0;
    int npar =0;

  while (1)
  {
    scanf("%d",&n);
    if(n==0){
      break;
    }else if (n%2==0)
    {
      par =par+n;
     }else{
      npar=npar+n;
     }
    
  }

  
  
  
 
 printf("%d %d\n",par,npar);
 
  
    return 0;
}