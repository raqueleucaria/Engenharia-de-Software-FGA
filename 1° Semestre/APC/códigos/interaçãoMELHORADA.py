print("INTERAÇÃO COM O USUÁRIO MELHORADAAAA")
letrasINT = ['A', 'P', 'C', 'T', '12', '-']
while True:
    car = input("Digite uma letra a ser pesquisada[s - encerra]: ")
    if car == 's':
        break
    indice = range(len(letrasINT)) #[0,1,2,3,4,5]
    pos = -1
    for l in indice:
       if (letrasINT[l]==car):
           pos = l
           break
    if(pos>=0):
       print('o caractere esta na posição ', pos)
    else:
       print('Caracrtere não encontrado')
print('cabou!')

for i in range(16):
    print(i)

