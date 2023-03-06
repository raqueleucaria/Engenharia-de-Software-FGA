# Aula 7 
(12/12)
- Desvios condicionais
- Laços

---

# Instruções de desvio
- Deixa de seguir o fluxo natura
- ex: return, break, if, continue, laços...
## Desvio condicional
- Desvia para uma instrução rotulada se a condição for verdadeira
- Se não, continua sequencialmente
- if

    ``` mips
        beq rs, rt, L1 
        # se (rs==rt) desvia para a instrução L1

        bne rs, rt, L1
        # se (rs!=rt) desvia para a instrução L1
    ```
- Compilando ifs
    
    ```c
    // Código em C:

    if(i==j) f = g+h;
    else f = g-h;
    ```

    ```mips
    # Código MIPS 1:

        bne $s3, $s4, Else # s3=i e s4=j
        add $s0, $s1, $s2
        j Exit # pula o else para o exit

    Else: sub $s0, $s1, $s2
    Exit: #...

    # Código MIPS 2:

        beq $s3, $s4, If
        sun $s0, $s1, $s2
        j Exit # pula o else para o exit

    If: add $s0, $s1, $s2
    Exit: #...
    ```

## Desvio incondicional
- go to, continue, break
``` mips
    j L1
    #Desvia incondicionalmente para a instrução L1
```

---

# Laços
- Compilando laços
    
    ```c
    // Código em C:

    while (save[i]==k) i+=1;
    // i em $s3, k em $s5, endereço de save e $s6
    ```
    ```mips
    # Código MIPS:

    loop:   sll     $t1, $s3, 2 #multiplicando i por 4 (2x2)
                                # deslocamento de uma palavra (4)
            add     $t1, $t1, $s6 #somando ao endereço base
            lw      $t0, 0($t1) #desloca 0 a partir do t1 -> carrega o valor de save i
                                # lw salva o dado em t0
            bne     $t0, $s5, Exit
            addi    $s3, $s3, 1 # i = i+1 
            j       Loop
    Exit: ...
    ```


![menormaior=](/Aulas/imagens/menomaiorigual.png)
    