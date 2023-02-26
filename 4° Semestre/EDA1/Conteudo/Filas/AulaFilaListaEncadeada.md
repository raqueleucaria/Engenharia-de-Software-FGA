## Fila

# LISTA ENCADEADA

### Representação
       __                         __                     __                   
      |//| topo   enfileira  ->  |//|   enfileira ->    |//|   desenfileira  ❎❎❎ 
      |__|            (1)        |__|      (2)          |__|           vai custar O(n)  
       ↓                          ↓                      ↓                        
       NULL                       __                     __               |     
                                 |_1|                   |_2|              |     
                                 |__|                   |__|              |    
                                  ↓                      ↓                |       
                                 NULL                    __               ↓     
                                                        |_1|           Solução:         
                                                        |__|     1. Adiciona o NÓ RABO
                                                         ↓       2. Lista end. circular
                                                        NULL

``` c
typedef struct no{
    int dado;
    struct no *prox;
} no;
```

### NÓ RABO
     ___ _     ___ _     ___ _      _ ___
    |___|_|→  |_1_|_|→  |_2_|_|→  ←|_|___|  
       p                              u

- Enfileira: Insere depois de u 0(1)
- Desenfileira: Remove depois de p O(1)
- Nesse caso a fila vazia é qaundo: **p->prox==u** e **u->prox==p** 

### LISTA CIRCULAR
- É uma lista que quando termina aponta para o nó cabeça

       (cabeça)
         ___ _     ___ _     ___ _      
        |☰☰|_|→  |_1_|_|→  |_2_|_|
           ↑_____________________| 
        
- Remoção: Removo depois do nó cabeça O(1)
- Inserir: O(1)
        
        (cabeça)
         ___ _     ___ _     ___ _        ___ _     ___ _     ___ _     ___ _ 
        |☰☰|_|→  |_1_|_|→  |_2_|_|  ⇒  |☰☰|_|→  |___|_|→  |_1_|_|→  |_2_|_|
           ↑_____________________|         ↑________________________________|
                                                           
                                                           ⇓ 

                                                  (cabeça)
                                         ___ _     ___ _     ___ _     ___ _                  
                                        |_3_|_|→  |☰☰|_|→  |_1_|_|→  |_2_|_|
                                          ↑________________________________|

     - O que marca o fim da lista é o nó cabeça  

     - CÓDIGO: ---> Dado f o nó cabeça
    ``` c
    no *novo=malloc(sizeof(no));
    novo->prox=f->prox;
    f->prox=novo;
    f->dado=x; // MODIFICAÇÃO -> Não coloca o dado no novo, coloca o dado no f
    f=novo; // nó cabeça vai receber o novo
    ```
     - **ATENÇÃO**: Como modificamos o nó cabeça, estamos alterando o ponteiro f. Deixando duas opções:
        1.  Função de início  retorna o novo ponteiro
            ``` c
            no *enfileira(no *f, int x); // retorna o novo nó cabeça
            ```
        2.  Passar o ponteiro por referência (ponteiro duplo)
            ``` c
            int enfileira (no **f=, int x);
            ```

