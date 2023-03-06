#include <stdio.h>
#include <stdlib.h>

struct stack
{
    int size;
    int top;
    int *s;
};

void create(stack *st){
    printf("enter size");
    scanf("%d",&st->size);
    st->top=-1;
    st->s=(int*)malloc(st->size*sizeof(int));
}

void Display(stack st){
    int i=0;
    for(i=st.top;i>=0;i--){
        printf("%d",st.s[i]);
        printf("\n");

    }
}

void Empilha(stack *st,int x){
      if(st->top==st->size-1){
        printf("nao tem espaco");
      }else{
        st->top++;
        st->s[st->top]=x;
      }

}

int Desempilha(stack *st){
    int x =-1;
    if(st->top==-1){
        printf("stack uneerflwo\n");
    }else{
        x = st->s[st->top--];
    }
    return x;
}

int main(){
     
    struct stack st;
    create(&st);
    Empilha(&st,10);
    Empilha(&st,20);
    Empilha(&st,30);
     Empilha(&st,10);
    Empilha(&st,20);
    Empilha(&st,30);
    Display(st);
    


    return 0;
}