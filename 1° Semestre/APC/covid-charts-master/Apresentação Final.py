import plotly.express as px
import pandas as pd
import dash
import dash_core_components as dcc
import dash_html_components as html
from dash.dependencies import Input, Output

def carregar_datasets_em_dicionarios(caminho_arquivo, colunas):
    df = pd.read_csv(caminho_arquivo)
    dados = {}
    for coluna in colunas:
        dados[coluna] = df[coluna].tolist()

    return dados

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

    return px.bar(x=states.keys(), y=states.values(), color=states.keys(),title="Total de Casos", labels=dict(x="estados", y="casos", color="Estados"))  

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

    return px.bar(x=states.keys(), y=states.values(), color=states.keys(),title="Total de Mortes", labels=dict(x="estados", y="casos", color="Estados"))  

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
    g_vac = px.line(x=lista_datas, y=lista_vac, color=lista_loc, title="Total de vacinações",labels=dict(x="data", y="vacinações", color="Locais"))
    return g_vac

def cria_lista_botoes_mundo():
    return [
        html.Button('Total de casos', id='button-mundo-total-casos', n_clicks=0),
        html.Button('Total de casos por milhão', id='button-mundo-total-casos-milhao', n_clicks=0),
        html.Button('Total de mortes', id='button-mundo-mortes', n_clicks=0),
        html.Button('Total de mortos por milhão', id='button-deaths_per_millio', n_clicks=0),
        html.Button('Total vacinações', id="button-mundo_vacinacoes", n_clicks=0),
    ]

def cria_lista_botoes_brasil():
    return [
        html.Button('Total de casos', id='button-total-casos', n_clicks=0),
        html.Button('Total de casos por 100 mil pessoas', id='button-total-casos-100k', n_clicks=0),
        html.Button('Total de mortes', id='button-mortes', n_clicks=0),
        html.Button('Taxa de mortalidade', id='button-taxa-mortalidade', n_clicks=0),
    ]

dados_mundo = carregar_datasets_em_dicionarios("https://raw.githubusercontent.com/owid/covid-19-data/master/public/data/owid-covid-data.csv",
                                               ["total_cases", "location", "date", "total_deaths",
                                                "human_development_index", "total_vaccinations",
                                                "total_cases_per_million", "total_deaths_per_million"])
dados_brasil = carregar_datasets_em_dicionarios('/home/eucaria/Downloads/covid-estados.csv',
                                               ["date", "state", "confirmed", "deaths", "death_rate",
                                                "confirmed_per_100k_inhabitants"])




app = dash.Dash(__name__, suppress_callback_exceptions=False)

app.layout = html.Div(style={"textAlign": "center"},children=[ 
    html.H1(children='COVID-19', style={'textAlign': 'center', 'color': '#66cdaa'}),
    html.Div(style={"textAlign": "center"}, children=[
        html.Button('Brasil', id='button-location-brazil', n_clicks=0),
        html.Button('Mundo', id='button-location-world', n_clicks=0),
    ]),
    html.Div(id="botoes-tipo-dado", style={"textAlign": "center"})
])


@app.callback(
    Output('botoes-tipo-dado', 'children'), 
    [Input('button-location-brazil', 'n_clicks'),
     Input('button-location-world', 'n_clicks')])
def update_location_content(button_line, button_bar):
    changed_id = dash.callback_context.triggered[0]
    caller_id = changed_id["prop_id"]
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

    elif "button-mundo_vacinacoes.n_clicks" == caller_id:
        return dcc.Graph(id="grafico-vac-mundo", figure=filtrar_por_data())


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


if __name__ == "__main__":
    app.run_server()
    
