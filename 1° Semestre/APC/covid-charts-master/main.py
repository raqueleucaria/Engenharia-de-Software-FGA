import pandas as pd
import plotly.express as px


def filtra_por_continente(lista, continente):
    """ filtra a lista passada por parametro retornando somente os itens que contenham  continentes e que
    seja igual ao parametro continente """
    lista_filtrada = []
    for item in lista:
        if item[1] == continente:
            lista_filtrada.append(item)
    return lista_filtrada


if __name__ == '__main__':
    # carrega o dataset na memoria com pandas
    df = pd.read_csv("dataset/owid-covid-data.csv")

    # trasnforma o dataframe do pandas em uma lista nativa do python
    lista_dados = df.values.tolist()
    nome_das_colunas = df.columns.values

    items_da_asia = filtra_por_continente(lista_dados, "Asia")

    fig = px.bar(pd.DataFrame(items_da_asia, columns=nome_das_colunas), x="location", y="total_cases")
    fig.show()
