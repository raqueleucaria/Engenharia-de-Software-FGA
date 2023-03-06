# Aula 3 - Linguagem de montagem
(07/nov)
1. Instruções aritméticas
2. Registradores

---
# Operações aritméticas
## Soma e subtração 
- Dois operandos e um resultado

        add a,b,c #a=b+c
        sub a,b,c #a=b-c

### Princípio de Design 1
" Simplicidade favorece regularidade"
- Torna a implementação simples
- Melhora o desempenho

Obs: mul (multiplicação) -> Cresce muito rápido e pode exeder o limite fácil (overflow)

### Exemplo: f = (g + h) - (i + j);
        
    add t0, g, h #temp t0=g+h
    add t1, i, j #temp t1=i+j
    sub f, t0, t1  #f=t0-t1

# Registradores
- Pequena unidades de memória que encontram-se dentro do processador.
- Possui quantidade limitada e o tempo de acesso é quase imediato.
- Instruções aritméticas lidam com registradores 
- As "variáveis" que as instruções usam chamam-se de **registradores**
- A arquitetura MIPS possui, no processador principal, 32 registradores de 32 bits.
- 00 a 31
- Um dado de 32 bits se chama palavra
- Um registrador MIPS conta com 3 unidades de processamento

        1 - Números inteiros
        2 - Números reais
        3 - Exceções

### Princípio de Design2: 
"Menor é mais rápido"
- Ao contrário da memória principal, que possui milhões de posições
- 32 < 64

Registradores   |   Numéricos   |   Descrição
--------------  |   ---------   |   -----
$zero           |   0           |   Constante zero
$at             |   1           |   Resevado ao assembler 
$v0-$v1         |   2-3         |   Retorno de funções (Resultado de procedimento)
$a0-$a3         |   4-7         |   Argumentos de funções
$t0-$t7         |   8-15        |   Temporários (não preservados entre chamadas)
$s0-$s7         |   16-23       |   Salvos
$t8-$t9         |   24-25       |   Temporários
$k0-$k1         |    26-27       |   Reservado ao S.O. (kernel)
$gp             |   28          |   Ponteiro Global
$sp             |   29          |   Ponteiro da pilha
$fp             |   30          |   Ponteiro de frame
$ra             |   31          |   Endereço de Retorno

### Obs:
- Os registradores são números pois o processador entende só número
- 18 registradores podem ser usados com variáveis (8 a 25)
    Registradores   |   Numéricos   
    --------------  |   ---------   
    $t0-$t7         |   8-15        
    $s0-$s7         |   16-23       
    $t8-$t9         |   24-25       

### Exemplo: f = (g + h) - (i + j);
    // MIPS compilado

    add $t0, $s1, $s2
    add $t1, $s3, $s4
    sub $s0, $t0, $t1
- $to = 18 ---> assembler faz essa conversão 