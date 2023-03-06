#string é uma lista de caracteres
nome = ['R', 'a', 'q', 'u', 'e', 'l'] 

nomex = 'Raquel' #tbm é considerado uma lista assim
print(nomex)
pl = nomex[0]
print('primeira letra do nome: ', pl)

nome_completo = ['Raquel', 'Eucaria'] #lista de strings
sobrenome = nome_completo[1]
plc = sobrenome[0]
print('primeira letra do sobrenome: ', plc)

print()

#tamanho de string
print('Quantas letras tem nome? ', len(nome))
print('Quantas letras tem nomex? ', len(nomex))
primeiro_nome = nome_completo[0]
print('Quantas letras tem o primeiro nome?', len(primeiro_nome))
print('Quantas nomes tem o nome completo? ', len(nome_completo))

#imprimindo todas as letras de uma variavel string
tamanho = len(nome)
index = 0
while index < tamanho:
    letter = nome[index]
    print(letter)
    index = index + 1

print()

for letter in nome:
    print(letter)
print()
for letter in nome:
    print(letter.upper()) #letras maiusculas

print()

#concatenação de strings 
prefixes = 'JKLMNOPQ'
sufix = 'ack'
for letter in prefixes:
    print(letter + sufix)
    
print(prefixes.lower() + sufix) #tudo minisculo
print()

#fatiamento da string -> substring
nome = 'Raquel Eucaria Costa'
primeiro_nome = nome[0:6]
segundo_nome = nome[7:14]
ultimo_nome = nome[15:21]

print(primeiro_nome)
print(segundo_nome)
print(ultimo_nome)

resto = nome[1:len(nome)] # len conta ate o final dos elementos
novonome = 'k' + resto #raquel com k
print(novonome)

#procurando a posiçãode caractere
letra = 'C'
indice = 0
posição = -1
while indice < len(nome):
    if nome[indice] == letra:
        posição = indice
        break
    indice = indice + 1

if posição >= 0:
    print(posição)
else:
    print("não encontrei a letra" + letra)

#achando a vogal
qvogais = 0
for letra in nome:
    if letra.lower() in 'aeiou':
        qvogais = qvogais + 1

print('vogais: ', qvogais)
