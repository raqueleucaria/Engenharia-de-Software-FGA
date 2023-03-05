import pandas as pd
import plotly.express as px
import plotly.graph_objects as go


lista = pd.read_csv("C:/Users/artur/OneDrive/Documentos/Documentos UnB/APC/Bases de dados/country_vaccinations.csv").values.tolist()

paises = {}
for linha in lista:
    nome_pais = linha[0]
    data = linha[2]
    total_vacinacao = linha[3]
    if nome_pais not in paises:
        lista_datas = [data]
        lista_total = [total_vacinacao]
        paises[nome_pais] = [lista_datas, lista_total]
    else:
        valor = paises[nome_pais]
        valor[0].append(data)
        valor[1].append(total_vacinacao)


fig = go.Figure()

for nome_pais, listas in paises.items():
    fig.add_trace(go.Scatter(
        x=listas[0],
        y=listas[1],
        name=nome_pais, # Style name/legend entry with html tags
        connectgaps=True # override default to connect the gaps
    ))

fig.show()