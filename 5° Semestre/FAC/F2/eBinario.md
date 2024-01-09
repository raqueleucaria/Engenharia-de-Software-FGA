    # Exercício E

- vamos usar uma máscara (and) 
    00000...1010001 = $s0
    00000...1010001 = $t0 +
    ======================
    00000....000001

1. Deslocando a máscara
obs: repete-se 7 vexes
 ``` mips
    and     $t1, $t0, $s0 = $s0
    beq     $t1,,soma#se..
    sll $to, $t0,1
    ;loop
    soma: add1, $t9,$t9, 1 #1 lop
    ; loop

    #fazer o srl aqui tbm
 ```
 2. Deslocando o s0
``` mips
    move $t9, $zero
    loop: 
        and $t1, $t0, $s0
        add $t9, $t9, $t1
        srl $s0, $s0, 1
    ; loop
 ```

 - falta condição de parada 
 - não salvar em s0 o a0
 - protocolo de chamadas a procedimentos