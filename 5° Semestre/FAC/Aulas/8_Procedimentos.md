# Aula 8
- <,>,>=,>=
- Procedimentos
---
# Como implementar <,>,>=,>=
- Por que não blt, bge, etc?
- O hardware para <,>=,... é mais lento que =, =!
    - Para checar = e !=, basta realizar uma subtração
    - Para checar <,>,... são necessárias mais instruções
    - Em bilhões de instruções, isso faz diferença!
- beq e bne são os casos mais comuns

## Insrtruções
- Faz a diferença e compara o resultado se é negativo, positivo...
    
        slt (rt < rt?) -> 1 se rs<rt
                       -> 0 se rs>rt
        beq (desvia se rs==rt) beq rs, rt, label
        bne (desvia se rs!=rt) bne rs, rt, label

###  Desvio se <
- Digamos $s0<$s1
``` mips
    slt $t0, $s0, $s1
    bne $t0, $zero, menor
```

###  Desvio se >
- Digamos $s0>$s1
``` mips
    slt $t0, $s1, $s0 #t0=1 se $s1 < $s0
    bne $t0, $zero, maior
```

###  Desvio se >=
- Digamos $s0>=$s1
``` mips
    slt $t0, $s0, $s1 # t0=0 <=> $s0 NÃO FOR MENOR $s1
                      # => @s0 >=$s1
    beq $t0, $zero, maiorIgual
```

###  Desvio se <=
- Digamos $s0<=$s1
``` mips
    slt $t0, $s1, $s0 
    beq $t0, $zero, maiorIgual
```
---
- Exemplo fulana

    ``` mips
    maior = A[0];
    for (i = 1; i < n; i++){
        if(A[i] > maior){
            maior = A[i];
        }
    }

    $s0 - end base do A
    $t0 - i
    $s1 - maior
    $s2 - n
    ```

    ``` mips
        add $t0, $s0, $zero     # $t0 = end base de A
            lw $s1, 0($t0)          # $s1 = A[0]
            sll $t1, $s2, 2         # $t1 = n*4
    loop:   addi $t0, $t0, 4
            slt $t2, $t0, $t1       # $t0 < $t1 (i<n)?
            beq $t2, $zero, exit
            lw $t3, 0($t0)          # $t3=A[i]?
            slt $t4, $s1, $t3       # meior < A[i]?
            beq $t4, $zero, loop
            add $s1, $t3, $zero     # maior = A[i]
            j loop
    exit:

    ```

########################################################
# Procedimentos
Quando uma função é chamada, toda a execução é **desviada** para o procedimento e um novo **escopo** é criado. Quando a função termina, o programa segue o fluxo de execução a partir da chamada da função. É essa dinâmica de desvio e de criação de escopo que devem nos atentar no assmbly.

- procedimento = conjunto de instruções
- função = procedimento que retorna um valor

Para nos ajudar com isso, contamos com os seguintes registradores;

- $a0 - $a3: são usados para parâmetros de funções;
- $v0 - $v3: são usados para retorno da função;
- $ra: guarda o endereço de origem da chamada à função.

A instrução jump-and-link:

    jal endereço
        (label)

- desvia o fluxo de execução ao endereço dado e salva o endereço da próxima instruçãono registrador $ra. 

Há ainda a instrução **jump to register:**

    jr $ra

- que desvia o fluxo de execução para o endereço armazenado em $va (é como se fosse o **return** que usamos em linguagem C);

O procedimento que faz a chamada à função é denominado **caller** e a função chamada, **callee**. Para fazer a chamada a uma função em assembly:

- 1 - O caller coloca os valores dos parâmetros nos registradores $a0 - $a3. Se necessário, faz uso da memória principal.
- 2 - O caller utiliza a instrução **jal** para realizar  a chamada ao callee
- 3 - O callee realiza o procedimento, salva os eventuais resultados nos registradores $v0 - $v1, e retorna o caller usando a instrução **jr**

        Caller
        Callee
        Program Counter (PC)
        Procedimento folha: um procedimento que não faz chamada a algum outro, último. 

Nessas chamadas à função, o armazenamento de dados na memória é bem comum. Por isso, existe uma região da memória principal  dedicada a esse uso chamada **pilha**. 

![chamada a procedimentos](/Aulas/imagens/chamadaProcedimentos.png)

![chamada a procedimentos](/Aulas/imagens/registradoresProcedimentos.png)

- estatico = dado global
- Tempo de vida de dados (variáveis - escopo): 
    - automáticos: alocados e deslocados em tempo de execução - espaço de memória disponível apenas no escopo de variável
    - estético: espaço disponível durante toda a execução do programa
## Pilha
![pilha](/Aulas/imagens/pilha.png)
É uma estrutura sequencial do tipo "o último a entrar é o primeiro a sair". O registrados $sp (stack pointer) contém o último endereço alocado da pilha. Essa pilha "cresce" para baixo, isto é, de endereços maiores para menores:


          <- $sp
    |   |           |$s0|  
    |   |   salva   |$s1| <- $sp  
    |   | --------> |   |  
    |   | $s0 e $s1 |   |  
    |   |           |   |  

    int exemplo (int g, int h, int i, int j){
        int f;
        f = (g + h) - (i + j);
        return f;
    }

    f - $v0
    g - $a0
    h - $a1
    i - $a2
    j - $a3


![pilha](/Aulas/imagens/usandoPilha.png)
![pilha](/Aulas/imagens/usandoPilha2.png)
Exemplo:

    addi $sp, $sp, -8   |
    sw $s1, 0($sp)      | -> armazena na pilha
    sw $s0, 4($sp)      |

    add $s0, $a0, $a1
    add $s1, $a2, $a3
    sub $v0, $s0, $s1

    lw $s0, 4($sp)      |
    lw $s1, 0($sp)      | -> restaura valores da pilha
    addi $sp, $sp, 8    |

    jr $ra #return

![pilha](/Aulas/imagens/exProced.png)
![pilha](/Aulas/imagens/exProcedFolha.png)

## Procedimentos não-folha
![naofolha](/Aulas/imagens/naoFolha.png)



### Recursividade

    n! = n*(n-1)*(n-2)...1

    int fat(int n){
        if(n<1) return 1;
        else return n*fat(n-1);
    }

---

    fat:addi $sp, $sp, -8
        sw $ra, 0($sp)
        sw $a0, 4($sp)
        slti $t0, $a0, 1
        beq $t0, $zero, L1
        addi $v0, $zero, 1
        addi $sp, $sp, 8
        jr $ra

    L1: addi $a0, $a0, -1
        jal fat

        lw $ra, 0($sp)
        lw $a0, 4($sp)
        addi $sp, $sp, 4
        mul $v0, $a0, $v0
        jr $ra

O segmento da pilha que contém valores salvos e as variáveis de um escopo do procedimento é chamado **frame de procedimento** ou **registro de ativação**. Para indicar o frame de procedimento, existe o registrador $fp (frame pointer):

        |$ra (n=3)|
        |$a0 (n=3)|
    $fp-|$ra (n=2)| - registro de ativação da função fat(2)
    $sp-|$a0 (n=2)|

A arquitetura MIPS possui a seguinte convenção de alocação de memória:

        | Pilha         |
    $sp-| ^|            | -> Heap
        | |v            | 
        | Dado dinâmico | 
    $gp-| Dado estático | -> variáveis globais e estáticos
    PC- | Texto         | -> instruções
        | Reservado     |

        Memória Principal
![padraoMemoria](/Aulas/imagens/padraoMemoria.png)

- **Texto** contém o **código de máquina** (compilado e montado). Program counter (PC) é um elemento de hardware que aponta para a instrução que está sendo executada.

- **Dados estáticos** é a porção reservada à variaveis globais e estáticas.

- **Dados dinâmicos** é a porção reservada para valores locais. Espaço usado pelo malloc do C, por exemplo, também conhecido por **heap**.