#usar o GITHUB para compartilhar o código

#request -> importar a biblioteca para baixar o csv no site https

#contar itens de uma lista
pessoas = ["raquel", "eucaria", "arthur", "beatriz", "cadu", "leo", "Vera" ]
print(len(pessoas))
tamanho_da_lista = len (pessoas)

#laço de repetição
for pessoa in pessoas:
    print('bem vindo ' + pessoa)
    
#mostra só quem começa com a letra b
for pessoa in pessoas:
    if pessoa.startswith("b"):
        print("BEM VINDO " + pessoa)

#O QUE TEM NA BIBLIOTECA? --> CONTROL + click

#def = pd.read_csv("site")
#fig = px.bar(df)
#fig.show()


#ler a lista como pandas
import pandas as pd
import plotly.express as px
df = pd.read_csv("site")

#transformar lista dada para lista python
lista_dados = df.values.tolist()
for dado in lista_dados:
    print(dado)

#lista bidimensional
america_sul = [] #append vai adicionar dados nessa lista

lista_dados = df.values.tolist()
for linha in lista_dados:
    if linha[1] == "South America":
        america_sul.append(linha) #ta lendo a lista e adicionando os dados nessa variavel se tiver o continente south america
    
    #for coluna in linha:
    #    print(f*coluna {coluna}*)

print(lista_dados)
print(len(america_sul))