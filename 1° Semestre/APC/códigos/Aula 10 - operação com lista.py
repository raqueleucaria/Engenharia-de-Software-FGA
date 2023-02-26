#juntar funções
letras = ['A', 'B', 'C']
resultado = letras + ['/', 'D', 'E', 'F']
resultado.append("#") #append -> acrescenta no final
for letra in resultado:
    print(letra)
    
#partes de listas
print(resultado[3:5]) #não inclui o último elemento
print (resultado[:5])
print(resultado[5:])

notas = [8.9, 6.7, 10.0]
total = sum(notas)
print (total)
notas.sort() #ordena a lista crescente
for nota in notas:
    print(nota)
