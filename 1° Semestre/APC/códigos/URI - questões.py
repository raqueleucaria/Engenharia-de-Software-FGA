#A)soma simples
a = int(input())
b = int(input())
c = a + b
print('SOMA = %d' %c)

#B)produto simples
a = int(input())
b = int(input())
c = a * b
print('PROD = %d' %c)

#C)média1
a = float(input())
b = float(input())
c = ((a * 3.5) + (7.5 * b)) / 11 
print('MEDIA = %0.5f' %c)

#D)media2
a = float(input())
b = float(input())
c = float(input())
media = (a * 2 + 3 * b + 5 * c) / 10 
print('MEDIA = %0.1f' %media)

#E)Salário
numero_funcionarios = int(input())
horas_trabalhadas = int(input())
valor_hora = float(input())
salario = horas_trabalhadas * valor_hora
print('NUMBER = %d' %numero_funcionarios)
print('SALARY = U$ %0.2f' %salario)

#F)Maior
values = map(int, input().split())
a,b,c = sorted(values)[::-1]
maiorAB = (a+b+abs(a-b))/2
maiorABC = (c+maiorAB+abs(c-maiorAB))/2
print('%d eh o maior' %maiorABC)

#G)Bhaskara
a,b,c = map(float, input().split())
delta = b**2 - 4*a*c
if delta < 0 or a == 0:
    print('Impossivel calcular')
else:
    r1 = (-b+(delta)**(1/2))/(2*a)
    r2 = (-b-(delta)**(1/2))/(2*a)
    print('R1 = %0.5f' %r1)
    print('R2 = %0.5F' %r2)

#H)Tipos de triângulos
values = map(float, input().split())
a,b,c = sorted(values)[::-1]

if(a>=b+c):
    print("NAO FORMA TRIANGULO")
else:
    if(a**2 == (b**2) + (c**2)):
        print("TRIANGULO RETANGULO")
    if(a**2 > (b**2) + (c**2)):
        print("TRIANGULO OBTUANGULO")
    if(a**2 < (b**2) + (c**2)):
        print("TRIANGULO ACUTANGULO")
    if(a==b==c):
        print("TRIANGULO EQUILATERO")
    if(a==b!=c or b==c!=a or a==c!=b):
        print("TRIANGULO ISOSCELES")

#I)Aumento de salário
salario = float(input())
if (salario <= 400.00):
    reajuste = 15
    novo_salario = salario + salario * reajuste/100
    reajuste_ganho = novo_salario - salario
    print('Novo salario: %0.2f' %novo_salario)
    print('Reajuste ganho: %0.2f' %reajuste_ganho)
    print('Em percentual: %d' %reajuste, '%')
elif (salario <= 800.00):
    reajuste = 12
    novo_salario = salario + salario * reajuste/100
    reajuste_ganho = novo_salario - salario
    print('Novo salario: %0.2f' %novo_salario)
    print('Reajuste ganho: %0.2f' %reajuste_ganho)
    print('Em percentual: %d' %reajuste, '%')
elif (salario <= 1200):
    reajuste = 10
    novo_salario = salario + salario * reajuste/100
    reajuste_ganho = novo_salario - salario
    print('Novo salario: %0.2f' %novo_salario)
    print('Reajuste ganho: %0.2f' %reajuste_ganho)
    print('Em percentual: %d' %reajuste, '%')
elif (salario <= 2000):
    reajuste = 7
    novo_salario = salario + salario * reajuste/100
    reajuste_ganho = novo_salario - salario
    print('Novo salario: %0.2f' %novo_salario)
    print('Reajuste ganho: %0.2f' %reajuste_ganho)
    print('Em percentual: %d' %reajuste, '%')
else:
    reajuste = 4
    novo_salario = salario + salario * reajuste/100
    reajuste_ganho = novo_salario - salario
    print('Novo salario: %0.2f' %novo_salario)
    print('Reajuste ganho: %0.2f' %reajuste_ganho)
    print('Em percentual: %d' %reajuste, '%')

#J.1) Pares entrer cinco números
a,b,c,d,e = map(float, input().split())
numeros = [a,b,c,d,e]
contador = 0
for par in numeros:
    if par % 2 == 0:
        contador = contador + 1
print(contador, "valores pares")

#J.2)
contador = 0
lista = []
while True:
    if contador <= 4:
        num = int(input())
        lista.append(num)
        contador = contador + 1
    else: 
        break #testando se deu certo -> print(lista)
pares = 0
for par in lista:
    if par % 2 == 0:
        pares = pares + 1
print(pares, "valores pares")

#K) Pares, Ímpares, Positivos e Negativos
contador = 0
lista = []
while True:
    if contador <= 4:
        num = int(input())
        lista.append(num)
        contador = contador + 1
    else: 
        break #testando se deu certo -> print(lista)

pares = 0
impares = 0
positivos = 0
negativos = 0
for numb in lista:
    if numb % 2 == 0:
        pares = pares + 1
    elif numb % 2 == 1:
        impares = impares + 1
for numb in lista:
    if numb > 0:
        positivos = positivos + 1
    elif numb < 0:
        negativos = negativos + 1
print(pares, "valor(es) par(es)")
print(impares, "valor(es) impar(es)")
print(positivos, "valor(es) positivo(s)")
print(negativos, "valor(es) negativo(s)")

#L)Crescente e decrescente
while True:
    values = map(int, input().split())
    a,b = (values)
    if a==b:
        break
    if a > b:
        print('Decrescente')
    if a < b:
        print('Crescente')

#M)Tipo de Combustível
contador = 0
lista = []
while True:
    num = int(input())
    if num == 4:
        break
    else:
        lista.append(num)

alcool1 = 0
gasolina2 = 0
diesel3 = 0
for i in lista:
    if i == 1:
        alcool1 = alcool1 + 1
    if i == 2:
        gasolina2 = gasolina2 + 1
    if i == 3:
        diesel3 = diesel3 + 1

print('MUITO OBRIGADO')
print('Alcool: %d' %alcool1)
print('Gasolina: %d' %gasolina2)
print('Diesel: %d' %diesel3)

#N)Cultivando Strings