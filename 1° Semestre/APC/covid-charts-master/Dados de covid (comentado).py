# chamada das bibliotecas
import plotly.express as px
import pandas as pd

# lê as duas bases de dados usadas
df_world = pd.read_csv('C:/Users/artur/OneDrive/Documentos/Documentos UnB/APC/P2/covid-data.csv')
df_brazil = pd.read_csv('C:/Users/artur/OneDrive/Documentos/Documentos UnB/APC/P2/covid-estados.csv')

# coloca em variáveis as colunas que serão usadas nas duas bases de dados, além de transforma-las em listas comuns que podem ser lidas pelo python
filt_world = ["total_cases", "location", "date", "total_deaths", "human_development_index", "total_vaccinations", "total_cases_per_million", "total_deaths_per_million"]
filt_brazil = ["date", "state", "confirmed", "deaths", "death_rate", "confirmed_per_100k_inhabitants"]
lists_world = {}
lists_brazil = {}
for i in filt_world:
    lists_world[i] = df_world[i].tolist()
for i in filt_brazil:
    lists_brazil[i] = df_brazil[i].tolist()

# determina a primeira variável das opções do loop
option1 = 1

# loop central do programa
while option1 != 3:

    # coleta do usuário a primeira opção para construção do gráfico
    print("""
        OPÇÕES:
    1. No mundo
    2. No Brasil
    3. Sair
    """)
    option1 = int(input("Digite a amplitude do gráfico: "))

    # testa a primeira opção conforme os dados e segue para montar um gráfico com dados mundiais
    if option1 == 1:

        # coleta a segunda opção
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

        # loop para testar todas as possibilidades da segunda opção
        for i in range(5):

            # filtragem para que o gráfico de vacinações seja corretamente formatado
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
            
            # demais possibilidades, que não precisam de filtro
            elif option2 == i+1:

                # formação do gráfico conforme as opções escolhidas
                options = ["total_cases", "total_cases_per_million", "total_deaths", "total_deaths_per_million", "total_vaccinations"]
                tmp = options[i]
                fig = px.line(x=lists_world["date"], y=lists_world[tmp], color=lists_world["location"], title=tmp)
                fig.show()            
        break

    # testa a escolha referente ao Brasil e apresenta a segunda variável de opções referentes ao Brasil      
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

        # loop para testar as opções
        for i in range(3):
            if option2 == i+1:

                # teste para escolha do tipo de gráfico (para a opção 4 não temos o gráfico de barras por causa de uma limitação tecnica do código)
                if option2 != 4:
                    print("""
                        OPÇÕES:
                    1. Linhas
                    2. Barras (comparação entre os estados atualmente)
                    """)
                    option3 = int(input("Digite o tipo do gráfico: "))
                
                if option3 == 2:
                    print("""
                        OPÇÕES:
                    1. Entre os estados
                    2. Entre as regiões
                    """)
                    option4 = int(input("Digite a forma de comparação: "))
                    

                # lista das possíveis funções a serem usadas no gráfico
                options = ["confirmed", "confirmed_per_100k_inhabitants", "deaths"]
                tmp = options[i]

                # construção do gráfico conforme a primeira opção
                if option3 == 1:
                    fig = px.line(x=lists_brazil["date"], y=lists_brazil[tmp], color=lists_brazil["state"], title=tmp)
                    fig.show()
                
                # para o gráfico de barras, apenas são usadas as ultimas atualizações referentes a cada estado, por isso a filtragem usada
                elif option3 == 2:
                    
                    # condicional para o caso de usarmos apenas os estados
                    if option4 ==1:
                        state_list = lists_brazil["state"]
                        data = lists_brazil[tmp]

                        # array para comportar as colunas dos estados brasileiros
                        states = {}

                        # loop para preencher o array com os dados corretos
                        for i in range(len(state_list)):
                            state = state_list[i]
                            dataframe = data[i]

                            # teste para verificar se o que foi encontrado é maior do que o que ja existe, se for, ele substitui
                            if state in states:
                                if states[state] < dataframe:
                                    states[state] = dataframe

                            # adiciona os dados no array
                            else:
                                states[state] = dataframe

                        # contrói o gráfico conforme as escolhas do usuário
                        fig = px.bar(x=states.keys(), y=states.values(), color=states.keys(), title=tmp)
                        fig.show()

                    #condicional para o caso de usarmos o filtro de regiões    
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

                                    # criação dos dados das regiões somando os dados de cada estado
                                    region_norte = regions["AC"] + regions["AM"] + regions["AP"] + regions["PA"] + regions["RO"] + regions["RR"] + regions["TO"]
                                    region_nordeste = regions["AL"] + regions["BA"] + regions["CE"] + regions["MA"] + regions["PB"] + regions["PE"] + regions["PI"] + regions["SE"] + regions["RN"]
                                    region_sudeste = regions["ES"] + regions["MG"] + regions["RJ"] + regions["SP"]
                                    region_sul = regions["PR"] + regions["RS"] + regions["SC"] 
                                    region_centrooeste = regions["DF"] + regions["GO"] + regions["MT"] + regions["MS"]

                                    # criação das duas listas com os dados e os nomes das regiões, respectivamente
                                    regioes_brasileiras = [region_norte, region_nordeste, region_sudeste, region_centrooeste, region_sul]
                                    region_division = ["Norte", "Nordeste", "Sudeste", "Centro-Oeste", "Sul"]
                                    
                                    # construção do gráfico com os dados manipulados
                                    fig = px.bar( x=region_division, y=regioes_brasileiras, color=region_division, title=tmp)
                                    fig.show()
    
        # montagem do gráfico na opção de taxa de mortalidade, com a qual não é possível construir um gráfico de barras
        if option2 == 4:
            fig = px.line(x=lists_brazil["date"], y=lists_brazil["death_rate"], color=lists_brazil["state"], title="death_rate")
            fig.show()
    
    # testa a opção de encerramento do programa
    elif option1 == 3:
        print("""
            OBRIGADO
        ENCERRANDO PROGRAMA
        """)
 
    # situação em que não é fonecida uma opção válida para as perguntas, fazendo o loop voltar ao início
    else:
        print("""
        OPÇÃO INVALIDA!
        DIGITE NOVAMENTE
        """)