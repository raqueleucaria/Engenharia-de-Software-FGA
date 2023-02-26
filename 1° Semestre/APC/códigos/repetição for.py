numeros = [10, 20, 30, 40]
print (numeros)
numeros[3] = 35
print (numeros)

#procurando algo na lista = in
resposta = (20 in numeros)
resposta2 = (50 in numeros)
print (resposta)
print (resposta2)

#tamanho da lista -> função len
print(len(numeros))

#range
lista = range(3) # [0,1,2]
print ("posição 0, valor: ", lista[0])
print ("posição 1, valor: ", lista[1])
print ("posição 2, valor: ", lista[2])

tamanho_lista = len(numeros) #4
indices = range (tamanho_lista) 


#laço e controle -> for
print("Imprimindo diretamente:")
for num in numeros:
    print(num) #imprime a list numeros
tamanho_lista = len(numeros) 
indices = range (tamanho_lista)

print("Imprimindo os valores por índice:")
for i in indices:
    print (numeros[i])

print("LETRAS")
letras = ['A', 'P', 'C']
print ('Imprimindo valores diretamente:')
for letra in letras:
    print(letra)
tamanho_letras = len(letras)
indices_letras = range(tamanho_letras)

print ('Imprimindo valores acessando por índices:')
for e in indices_letras:
    print (letras[e])

print("Inverter os valores de letras:" )
print ()
letras2 = ['C', 'P', 'A']

for e in indices_letras:
    letras[e] = letras2[e]
    print (letras[e])

print("INTERAÇÃO COM O USUÁRIO:")
