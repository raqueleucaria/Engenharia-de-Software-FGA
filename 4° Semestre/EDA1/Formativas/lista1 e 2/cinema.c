#include <stdio.h>

int main(){
    int cinema[20][25];

    int i,j,f,l,num;
    char letra;
    for ( i = 0; i < 20; i++)
    {
        for ( j = 0; j<25; j++)
        {
           cinema[i][j] =0;
        }
        

            }
            scanf("%d%dn",&f,&l);
            while ((scanf("%c%d",&letra,&num)!=EOF))
            {
                cinema[letra-65][num-1] =1;
            }
    printf(" ");
    for ( i = l; i <=l;i++){
        printf(" %02d",i);
    }
    {
        /* code */
    }
    
            
    for ( i = f-1;i >=0; i--)
    {
        for(j=0; j<l ; j++){
            if(cinema[i][j]==0){
                printf("  --");
            }else{
                printf("  XX ");
            }
            printf("\n");
        }
    }
    


    return 0;

}