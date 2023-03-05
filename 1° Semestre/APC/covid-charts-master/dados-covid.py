import plotly.express as px
import pandas as pd

df_world = pd.read_csv('C:/Users/artur/OneDrive/Documentos/Documentos UnB/APC/P2/covid-data.csv')
df_brazil = pd.read_csv('C:/Users/artur/OneDrive/Documentos/Documentos UnB/APC/P2/covid-estados.csv')

filt_world = ["total_cases", "location", "date", "total_deaths", "total_vaccinations", "total_cases_per_million", "total_deaths_per_million"]
filt_brazil = ["date", "state", "confirmed", "deaths", "death_rate", "confirmed_per_100k_inhabitants"]
lists_world = {}
lists_brazil = {}

for i in filt_world:
    lists_world[i] = df_world[i].tolist()
for i in filt_brazil:
    lists_brazil[i] = df_brazil[i].tolist()

option1 = 1

while option1 != 3:
    print("""
        OPÇÕES:
    1. No mundo
    2. No Brasil
    3. Sair
    """)
    option1 = int(input("Digite a amplitude do gráfico: "))

    if option1 == 1:
        print("Mundo")
        print("""
            OPÇÕES:
        1. total de casos
        2. total de casos por milhão
        3. total de mortes
        4. total de mortes por milhão
        5. total de vacinações
        """)
        option2 = int(input("Digite tipo de gráfico: "))

        for i in range(5):
            if option2 == 5:
                tmp = "total_vaccinations"
                data_filter = []
                vac = []
                loc = []
                for i,j in enumerate(lists_world["date"]):
                    #2020-12-14
                    ano = int(j[0:4])
                    mes = int(j[5:7])
                    if ano == 2021 or (ano == 2020 and mes == 12):
                        data_filter.append(j)
                        vac.append(lists_world[tmp][i])
                        loc.append(lists_world["location"][i])
                fig = px.line(x=data_filter, y=vac, color=loc, title=tmp)
                fig.show()
                option2 = 6

            elif option2 == i+1:

                options = ["total_cases", "total_cases_per_million", "total_deaths", "total_deaths_per_million"]
                tmp = options[i]
                fig = px.line(x=lists_world["date"], y=lists_world[tmp], color=lists_world["location"], title= tmp)
                fig.show()  
                            
            
    elif option1 == 2:
        print("Brasil")
        print("""
            OPÇÕES:
        1. total de casos
        2. total de casos a cada 100 mil pessoas
        3. total de mortes
        4. taxa de mortalidade
        """)
        option2 = int(input("Digite a informação do gráfico: "))

        for i in range(3):
            if option2 == i+1:
                if option2 != 4:
                    print("""
                        OPÇÕES:
                    1. Linhas
                    2. Barras (comparação do momento atual)
                    """)
                    option3 = int(input("Digite o tipo do gráfico: "))
                
                if option3 == 2:
                    print("""
                        OPÇÕES:
                    1. Entre os estados
                    2. Entre as regiões
                    """)
                    option4 = int(input("Digite a forma de comparação: "))

                options = ["confirmed", "confirmed_per_100k_inhabitants", "deaths"]
                tmp = options[i]

                if option3 == 1:
                    fig = px.line(x=lists_brazil["date"], y=lists_brazil[tmp], color=lists_brazil["state"], title=tmp)
                    fig.show()
                
                elif option3 == 2:
                    if option4 == 1:
                        state_list = lists_brazil["state"]
                        data = lists_brazil[tmp]

                        states = {}

                        for i in range(len(state_list)):
                            state = state_list[i]
                            dataframe = data[i]

                            if state in states:
                                if states[state] < dataframe:
                                    states[state] = dataframe

                            else:
                                states[state] = dataframe
                        fig = px.bar(x=states.keys(), y=states.values(), color=states.keys(), title=tmp)
                        fig.show()

                    elif option4 == 2:
                                    column_states = df_brazil["state"].tolist()
                                    column_data = df_brazil[tmp].tolist()
                                    regions = {}
                                    for i in range(len(column_states)):
                                        state = column_states[i]
                                        data = column_data[i]

                                        if state in regions:
                                            if regions[state] < data:
                                                regions[state] = data
                                        else:
                                            regions[state] = data

                                    region_norte = regions["AC"] + regions["AM"] + regions["AP"] + regions["PA"] + regions["RO"] + regions["RR"] + regions["TO"]
                                    region_nordeste = regions["AL"] + regions["BA"] + regions["CE"] + regions["MA"] + regions["PB"] + regions["PE"] + regions["PI"] + regions["SE"] + regions["RN"]
                                    region_sudeste = regions["ES"] + regions["MG"] + regions["RJ"] + regions["SP"]
                                    region_sul = regions["PR"] + regions["RS"] + regions["SC"] 
                                    region_centrooeste = regions["DF"] + regions["GO"] + regions["MT"] + regions["MS"]

                                    regioes_brasileiras = [region_norte, region_nordeste, region_sudeste, region_centrooeste, region_sul]
                                    region_division = ["Norte", "Nordeste", "Sudeste", "Centro-Oeste", "Sul"]

                                    fig = px.bar( x=region_division, y=regioes_brasileiras, color=region_division, title=tmp)
                                    fig.show()

        if option2 == 4:
            fig = px.line(x=lists_brazil["date"], y=lists_brazil["death_rate"], color=lists_brazil["state"], title="death_rate")
            fig.show()

    elif option1 == 3:
        print("""
            OBRIGADO
        ENCERRANDO PROGRAMA
        """)
        
    else:
        print("""
        OPÇÃO INVALIDA!
        DIGITE NOVAMENTE
        """)