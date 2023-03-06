import requests
import os

file_url = 'https://raw.githubusercontent.com/owid/covid-19-data/master/public/data/owid-covid-data.csv'
file_path = "C:/Users/artur/OneDrive/Documentos/Documentos UnB/APC/Bases de dados/covid-data.csv"

# verifica se ja existe o diretorio e se não existir cria.
if not os.path.exists(os.path.dirname(file_path)):
    os.makedirs(os.path.dirname(file_path))


r = requests.get(file_url, stream=True)

with open(file_path, "wb") as pdf:
    for chunk in r.iter_content(chunk_size=1024):
        # writing one chunk at a time to pdf file
        if chunk:
            pdf.write(chunk)