import plotly.express as px
import pandas as pd
import dash
import dash_core_components as dcc
import dash_html_components as html
from dash.dependencies import Input, Output
#import construtores.layout as cl

#  1 - função que recebe os data sets
# caminho_arquivo -> endereço da função 
# colunas -> listas das colunas desejadas 
def carregar_datasets_em_dicionarios(caminho_arquivo, colunas):
    df = pd.read_csv(caminho_arquivo)
    dados = {}
    for coluna in colunas:
        dados[coluna] = df[coluna].tolist()
    return dados

# 2.1 - Função para filtrar E CRIAR OS GRÁFICOS 
# Dos números de CASOS CONFIRMADOS mais recentes
def filtra_maior_numero_casos_por_estado():
    state_list = dados_brasil["state"]
    data = dados_brasil["confirmed"]
    states = {}

    for i in range(len(state_list)):
        state = state_list[i]
        dataframe = data[i]

        if state in states:
            if states[state] < dataframe:
                states[state] = dataframe
        else:
            states[state] = dataframe
    # retorna o gráfico de casos totais no brasil -> GRÁFICO BARRA
    return px.bar(x=states.keys(), y=states.values(), color=states.keys(),title="Total de Casos", labels=dict(x="estados", y="casos", color="Estados"))  

# 2.2 - Função para filtrar E CRIAR OS GRÁFICOS os números de MORTES mais recentes
def filtra_maior_numero_casos_por_estado_MORTES():
    state_list = dados_brasil["state"]
    data = dados_brasil["deaths"]
    states = {}

    for i in range(len(state_list)):
        state = state_list[i]
        dataframe = data[i]

        if state in states:
            if states[state] < dataframe:
                states[state] = dataframe
        else:
            states[state] = dataframe
    # # retorna o gráfico de MORTOS no brasil -> GRÁFICO BARRA
    return px.bar(x=states.keys(), y=states.values(), color=states.keys(),title="Total de Mortes", labels=dict(x="estados", y="casos", color="Estados"))  


#  3  - função para filtrar a data das vacinas 
def filtrar_por_data():
    tmp = "total_vaccinations"
    lista_datas = []
    lista_vac = []
    lista_loc = []
    filtro = lista_datas, lista_vac, lista_loc
    print(filtro)
    for i, j in enumerate(dados_mundo["date"]):
        # 2020-12-14
        ano = int(j[0:4])  # 0, 1, 2 e 3
        mes = int(j[5:7])  # 5 e 6
        if ano == 2021 or (ano == 2020 and mes == 12):
            lista_datas.append(j)
            lista_vac.append(dados_mundo[tmp][i])
            lista_loc.append(dados_mundo["location"][i])
    # retorna o gráfico de vacinação
    g_vac = px.line(x=lista_datas, y=lista_vac, color=lista_loc, title="Total de vacinações",labels=dict(x="data", y="vacinações", color="Locais"))
    return g_vac

#  4  - função para criar os botões do mundo
def cria_lista_botoes_mundo():
    return [
        html.Button('Total de casos', id='button-mundo-total-casos', n_clicks=0),
        html.Button('Total de casos por milhão', id='button-mundo-total-casos-milhao', n_clicks=0),
        html.Button('Total de mortes', id='button-mundo-mortes', n_clicks=0),
        html.Button('Total de mortos por milhão', id='button-deaths_per_millio', n_clicks=0),
        html.Button('Total vacinações', id="button-mundo_vacinacoes", n_clicks=0),
    ]

#  5  - função para criar os botões do brasil
def cria_lista_botoes_brasil():
    return [
        html.Button('Total de casos', id='button-total-casos', n_clicks=0),
        html.Button('Total de casos por 100 mil pessoas', id='button-total-casos-100k', n_clicks=0),
        html.Button('Total de mortes', id='button-mortes', n_clicks=0),
        html.Button('Taxa de mortalidade', id='button-taxa-mortalidade', n_clicks=0),
    ]

#filtragem das bases de dados
dados_mundo = carregar_datasets_em_dicionarios("https://raw.githubusercontent.com/owid/covid-19-data/master/public/data/owid-covid-data.csv",
                                               ["total_cases", "location", "date", "total_deaths",
                                                "human_development_index", "total_vaccinations",
                                                "total_cases_per_million", "total_deaths_per_million"])
dados_brasil = carregar_datasets_em_dicionarios('/home/eucaria/Downloads/covid-estados.csv',
                                               ["date", "state", "confirmed", "deaths", "death_rate",
                                                "confirmed_per_100k_inhabitants"])



#  Dash comeca aqui:
#Padrão -> inicia
external_stylesheets = ['https://codepen.io/chriddyp/pen/bWLwgP.css'] #pra mudar a letra
app = dash.Dash(__name__, external_stylesheets=external_stylesheets )
#app = dash.Dash(__name__) -> antes de mudar a letra tava assim

# div -> divide as partes do dash e organiza no espaço, conforme a ordem
app.layout = html.Div(style={"textAlign": "center", },children=[ #'backgroundColor':'#111111'
    html.H1(children='COVID-19', style={'textAlign': 'center', 'color': '#66cdaa'}),
    html.Div(style={"textAlign": "center"}, children=[
        html.Button('Brasil', id='button-location-brazil', n_clicks=0),
        html.Button('Mundo', id='button-location-world', n_clicks=0),
    ]),
    html.Div(id="botoes-tipo-dado", style={"textAlign": "center"}) #identificador dos dois botôes (brasil e mundo)
    
])

# Definindo a entrada e a saída de botoes- tipo-dado -> brasil ou mundo
# primeira interação
@app.callback(
    Output('botoes-tipo-dado', 'children'), 
    [Input('button-location-brazil', 'n_clicks'),
     Input('button-location-world', 'n_clicks')])
def update_location_content(button_line, button_bar): #parametros vazios para completar o código #FOGE DE EXPLICAR
    changed_id = dash.callback_context.triggered[0] #identifica o ultimo botão clicado #FOGE DE EXPLICAR
    caller_id = changed_id["prop_id"] #recebe qual último botão selecionado e troca caller_id para acionar os outros botões  #FOGE DE EXPLICAR
    print(changed_id)
    if "button-location-world" in caller_id:
        return [
            html.H2(children="Gráficos do Mundo"),
            *cria_lista_botoes_mundo(), html.Div(id="grafico-mundo")] # * -> posição da lista e sobreposição da lista de botão 
    elif "button-location-brazil" in caller_id:
        return [
            html.H2(children="Gráficos do Brasil"),
            *cria_lista_botoes_brasil(), html.Div(id="grafico-brasil"),
            
            ]     
    return None

#iniciado quando selecionado o botão mundo
@app.callback(
    Output('grafico-mundo', 'children'),
    [Input('button-mundo-total-casos', 'n_clicks'),
     Input('button-mundo-total-casos-milhao', 'n_clicks'),
     Input('button-mundo-mortes', 'n_clicks'),
     Input('button-deaths_per_millio', 'n_clicks'),
     Input('button-mundo_vacinacoes', 'n_clicks'),
     ])
def callback_dado_mundo(btn_total_casos, btn_total_casos_milhao, btn_mortes, btn_taxa, btn_vacinacoes):
    changed_id = dash.callback_context.triggered[0]
    caller_id = changed_id["prop_id"]
    print(changed_id)
    coluna_selecionada = ""
    if "button-mundo-total-casos.n_clicks" == caller_id:
        coluna_selecionada = "total_cases"
        a = px.line(x=dados_mundo["date"], y=dados_mundo[coluna_selecionada], color=dados_mundo["location"],
                title="Total de casos",   labels=dict(x="data", y="casos", color="Local"))
        return dcc.Graph(id="grafico-linha-mundo", figure=a)
        
    elif "button-mundo-total-casos-milhao.n_clicks" == caller_id:
        coluna_selecionada = "total_cases_per_million"
        a = px.line(x=dados_mundo["date"], y=dados_mundo[coluna_selecionada], color=dados_mundo["location"],
                title="Total de casos por milão",   labels=dict(x="data", y="casos", color="Local"))
        return dcc.Graph(id="grafico-linha-mundo", figure=a)

    elif "button-mundo-mortes.n_clicks" == caller_id:
        coluna_selecionada = "total_deaths"
        a = px.line(x=dados_mundo["date"], y=dados_mundo[coluna_selecionada], color=dados_mundo["location"],
                title="Total de mortes",   labels=dict(x="data", y="mortes", color="Local"))
        return dcc.Graph(id="grafico-linha-mundo", figure=a)

    elif "button-deaths_per_millio.n_clicks" == caller_id:
        coluna_selecionada = "total_deaths_per_million"
        a = px.line(x=dados_mundo["date"], y=dados_mundo[coluna_selecionada], color=dados_mundo["location"],
                title="Total de mortes por milhão",   labels=dict(x="data", y="mortes", color="Local"))
        return dcc.Graph(id="grafico-linha-mundo", figure=a)
    # chama a função (filtro_por_data) e retorna o gráfico de vacinação
    elif "button-mundo_vacinacoes.n_clicks" == caller_id:
        return dcc.Graph(id="grafico-vac-mundo", figure=filtrar_por_data())

#iniciado quando selecionado o botão brasil
@app.callback(
    Output('grafico-brasil', 'children'),
    [Input('button-total-casos', 'n_clicks'),
     Input('button-total-casos-100k', 'n_clicks'),
     Input('button-mortes', 'n_clicks'),
     Input('button-taxa-mortalidade', 'n_clicks')])
def atualiza_grafico_brasil(button_line, button_bar, button_m, button_tm):
    changed_id = dash.callback_context.triggered[0]
    caller_id = changed_id["prop_id"]
    print(changed_id)
    coluna_selecionada = ""
    if "button-total-casos.n_clicks" == caller_id:
        return [dcc.Graph(id="grafico-linha-brasil-graficos", figure=filtra_maior_numero_casos_por_estado())]
        
    elif "button-total-casos-100k.n_clicks" == caller_id:
        coluna_selecionada = "confirmed_per_100k_inhabitants"
        fig = px.line(x=dados_brasil["date"], y=dados_brasil[coluna_selecionada], color=dados_brasil["state"],
                    title="Total de Casos por 100k pessoas", labels=dict(x="data", y="casos", color="Estados"))
        return [dcc.Graph(id="grafico-linha-brasil", figure=fig)]

    elif "button-mortes.n_clicks" == caller_id:
        return [dcc.Graph(id="grafico-linha-brasil-graficos", figure=filtra_maior_numero_casos_por_estado_MORTES())]
        
    elif "button-taxa-mortalidade.n_clicks" == caller_id:
        coluna_selecionada = "death_rate"
        fig = px.line(x=dados_brasil["date"], y=dados_brasil[coluna_selecionada], color=dados_brasil["state"],
                    title="Taxa de mortalidade",  labels=dict(x="data", y="taxa", color="Estados"))
        return [dcc.Graph(id="grafico-linha-brasil", figure=fig)]

#padrão no final do código
if __name__ == "__main__":
    app.run_server()
    