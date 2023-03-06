#include <stdio.h>

enum{MAXN=100010};
enum{MAXM=100010};
int n,m;
long long int r[MAXN];

int bbin(long long int val)
{
	int inicio=1, fim=n;

	if(val>r[n]) return 0;
	
	while(inicio<fim)
	{
		int meio=(inicio+fim)/2;

		if(r[meio]>=val) fim=meio;
		else inicio=meio+1;
	}
	return n+1-fim;
}
int main()
{
        scanf("%d %d",&n, &m);
	for(int i=1;i<=n;i++)	
	{
		scanf("%lld",&r[i]);
		r[i]=r[i]*r[i];
	}
	long long int resposta=0;
	for(int i=1;i<=m;i++)	
	{	
		long long int x,y;
		scanf("%lld %lld",&x,&y);
		resposta+=bbin(x*x+y*y);
	}
	printf("%lld\n",resposta);
	return 0;
}