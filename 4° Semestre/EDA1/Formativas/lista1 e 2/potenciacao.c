

#include <stdio.h>





double powar( unsigned int a, int b)
{
    
    if(b == 0)
        return 1;
    else if(b > 0)
        return a * powar(a, b - 1);
    else
        return 1 / powar(a, -b);
}


int main()
{
    float power;
    int unsigned a;
    int b;

    
    
 
    scanf("%u%d", &a,&b);

    if(b==0 && a==0){
      printf("indefinido\n");
    }else{
  
 
    power = powar(a, b); 

    
    
    printf("%.3f\n", power);}
    
    return 0;
  }



