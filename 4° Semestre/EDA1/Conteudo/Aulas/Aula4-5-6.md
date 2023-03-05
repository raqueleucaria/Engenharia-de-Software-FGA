---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------
                                          AULA 4
---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------

Dica para um dos exercícios


str=A vaca malhada foi molhada por outra vaca malhada e molhada

trocar: 
    busca = molhada por tapada
    substitui = tapada

novaStr = A vaca 

#string auxiliar tapada foi molhada por outra vaca tapada e molhada
buffer = malhada # limpa o buffer
buffer = m # diferente da busca VOLTA A COPIAR NA NOVA STRING e limpa o buffer
buffer = malhada # coloca a palavra substituta e limpa o buffer

>> mais diacas <<<

A vaca molhada
malhada
tapada

como fazer OPÇÃO 1:
vetor auxiliar
    novaFrase[10001]=
    buffer[41]
contator i: para percorrer a string da frase
    i=0
contator j: para percorrer a string da nova frase
    j=0
contator k: para percorrer o buffer
    k=0
------------------------------------------------------------------------------------------------

AULA 4

Como medir o desempenho de algoritmos?
- (   ) Tempo de resposta: Depende da entrada, da máquina, sistema operacional(concorrência-multitarefas) ---> Depende de muito fatores 
- (   ) Corretude (demonstrar matematicamente que seu código faz o que ele é proposto)
- ( x ) Memória utilizada
- ( x ) Quantidade de operações
        operação = algo que demora tempo constante indepentente da entrada
- No final a preocupação é decobrir a magnitude OU ordem de grandeza DA QUANTIDADE DE OPERAÇÕES EM TERMOS DO TAMANHO DA ENTRADA.

Notação Big-O (análise assintótica)
- Dizemos que f(x) é O(g(x)) se existem constantes c>0 E n0>=0 
    tais que: f(x) <= c . g(x) para todo x>=n0
- No nosso exemplo anterior, f(n) = 4n-1 E g(n)=n, 
    pois: 4n-1<= 4n, para todo n>=0
                                    c=4                                         0=n0
- Nesse caso, o algoritmo é O(n) -> LINEAR
- No pior caso ele possui no máximo n operações ou um constante vezes n
- limite é c
- Dizemos que f(x) é é W(h(x)) se existem constantes c>0 E n0>=0 
    tais que: f(x) >= c . h(x) para todo x>=n0
- No nosso exemplo anterior, f(n) = 3n E h(n)=n, 
    pois: 3n >= 3(c)n, para todo n>=0
- Logo, o algoritmo é W(n) ----> LINEAR
- Quando a complexidade de pior caso (O) coincide com a de melhor (W), dizemos que o algoritmo é T.
    No exemplo, T(n).
- Pior caso é a medida mais importante/usada

Ordem de grandeza
- Constante: O(1)
- Logaritimica: 0(lg n) -> Não importa a base, geralmente base 10 e 2
- Linear: O(n) - nos exemplos anteriores
- Quasilinear/linearítmica: O(n . lg n) -> quase não vai ver/cair na prova


---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------
                              AULA 5 -
---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------
>>>>>LEITURA DA STRING<<<<<<
>>>>>>>>>  DICAS <<<<<<<<<<<

scanf("%s",str);
	Lé uma palavra sem consumir o caracter de espaço 
	NÃO USAR PARA LER VÁRIAS PALAVRAS

scanf(" %s", str);
	coloca um espaço antes para não dar erro com o scanf

scanf(" %[^\n]",str); 
	[] = padrão da string q se quer leR
	^ = não, excessão, não sera lido
	Garante a leitura de tudo, menos \n

gets -------> NÃO USAR
fgets -------> pode usar como scanf

---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------
                              AULA 6 - Ordem de grandeza
---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------

*Ordem de grandeza*
- Constante: O(1)
- Logaritimica: O(lg n)
- Linear: O(n)
- Quasilinear / linearítmica: O(n lg n)
- Polinomial: O (n^k), k >= 2
	k = 2: quadrático
	k = 3: cubico

-> Exponencial: O(2^n); O(k^n), k>2