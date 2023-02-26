#include <stdio.h>

typedef struct num {
	int dado;
	int position_antiga;
} num;


// void ordendaDados (num *v, int n) {
//    for (int i = 0; i < n; i++) {
//       int min = i;
//       for (int j = i+1; j < n; j++)
//          if (v[j].dado < v[min].dado)  min = j;v[i].position_antiga = v[min].position_antiga;
//       int x = v[i].dado; v[i].dado = v[min].dado; v[min].dado = x; 
//    }
// }

// void ordendaDados (num *v, int n)
// {
//    for (int j = 1; j < n; ++j) {
//       int x = v[j].dado;
//       int i, aux = v[j].position_antiga;
//       for (i = j-1; i >= 0 && v[i].dado > x; --i) 
//          v[i+1].dado = v[i].dado; v[i+1].position_antiga = v[i].position_antiga;
//       v[i+1].dado = x; v[i+1].position_antiga = aux;
//    }
// }

void ordendaDados (num *v, int n){
    int i, j, min, x, aux;
    for (i=0; i<n; i++){
        min = i;
    for (j=i; j<n; j++){
            if (v[j].dado < v[min].dado)
            min = j;
    }
    x = v[min].dado; aux = v[min].position_antiga;
    v[min].dado = v[i].dado; v[min].position_antiga = v[i].position_antiga;
    v[i].dado = x; v[i].position_antiga = aux;
    }
}
int buscaBinaria(num *v, int x, int y) {
	int right = x;
	int left = -1;
	int medium;

	while( left < right-1) {
		medium = ((right + left)/2);
		if(v[medium].dado < y) {
			left = medium;
		}
		else {
			right = medium;
		}
	}
	return right;
}


int main() {
	int N, M, NUM;
	scanf("%d %d", &N, &M);

	num v[N];

	for( int i = 0; i < N; i++ ) {
		scanf("%d", &v[i].dado);
		v[i].position_antiga = i;
	}

	ordendaDados(v, N);

	
	 int w = 0;
	 int j;
		

	 while(w < M) {
	  scanf("%d", &NUM);

	  j = buscaBinaria(v, N, NUM);

	  if(NUM == v[j].dado){
	  	printf("%d\n", v[j].position_antiga);
	  }
	  else {
	  	printf("%d\n", -1);
	  }
	  w++;
	}
return 0;
}
