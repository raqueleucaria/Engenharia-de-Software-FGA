#include<stdio.h>
#include<stdlib.h>

typedef int Item;
#define l(A,B) ((A) < (B))
#define leq(A,B) ((A) <= (B))
#define e(A,B) { Item t; t=A;A=B;B=t; }
#define c(A,B) { if (l(B,A)) e(A,B); }

int separa(int *V,int l,int r){
  int c=V[r];
  int j=l;
  int temp;
  for(int k=l;k<r;k++)
    if(V[k]<c){
        temp=V[k];
        V[k]=V[j];
        V[j]=temp;
      j++;
    }
    temp=V[j];
    V[j]=V[r];
    V[r]=temp;
  return j;
}

void quicksort (Item *V,int l, int r) {
  if (r<=l) return;

  c(V[(l+r)/2],V[r]);
  c(V[l],V[(l+r)/2]);
  c(V[r],V[(l+r)/2]);

  int j=separa(V,l,r);
  quicksort
  (V,l,j-1);
  quicksort
  (V,j+1,r);
}

void quickselect(int *v,int l, int r, int k){
  int i;
  i= separa(v,l,r);
  if(r<=l)return;
  if(i>k)quickselect(v,l,i-1,k);
  if(i<k)quickselect(v,i+1,r,k);
}

int main(){
  int n,p,x;
  int *v;
  
  scanf("%d %d %d", &n, &p, &x);
  v= malloc (sizeof(int)*n);
  for(int i=0; i<n; i++)  scanf("%d", &v[i]);
  int iniciop =x*p;

  quickselect(v,0,n-1,iniciop);
  quickselect(v,iniciop+1,n-1,iniciop+x-1);
  quicksort
  (v,iniciop,iniciop+x-1);

  for(int j=iniciop; j<=iniciop+x-1; j++){ printf("%d\n", v[j]);
  }

}
