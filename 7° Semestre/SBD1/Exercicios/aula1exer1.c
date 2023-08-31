#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX 100

typedef struct 
{
    char nome[30];
    char cpf[11];
    int qtVeiculos;
    char veiculos[MAX][7];
} Usuario;

typedef struct 
{
    char crv[12];
    char placa[30];
    char marca[30];
    char modelo[30];
    char ano[30];
    char cor[30];
} Veiculo;

Usuario usuario;
Veiculo veiculo;

void menu(){
    printf("--------------------------------------------------------\n");
    printf("            * MENU *  -  Registro de Veículo            \n");
    printf("--------------------------------------------------------\n");
    printf("Selecione a opção desejada:\n");
    printf("1 - Cadastrar Usuário e Veículo\n");
    printf("2 - Acessar registros\n");
    printf("3 - Sair do programa\n");
    printf("Opção: ");
}

void registro(FILE *arqUsuarios , FILE *arqVeiculos){
    int idRegistro = 1;
    int idCarro = 0;

    arqUsuarios = fopen("bdUsuarios.bin", "r");
    arqVeiculos = fopen("bdVeiculos.bin","r");

    printf("========================================================\n");
    printf("                       Registros                        \n");
    printf("========================================================\n");
            

    while(fread(&usuario, sizeof(Usuario), 1, arqUsuarios)){
        printf("Usuário %d\n", idRegistro);
        printf("\t- Nome: %s\n\t- CPF: %s\n\n\tCarros:\n", usuario.nome, usuario.cpf);
        for(int j = 0; j < usuario.qtVeiculos; j++){
            idCarro = j + 1;
            printf("\t  (%d)\n",idCarro);
            fseek(arqVeiculos, 0, SEEK_SET);
            while (fread(&veiculo, sizeof(Veiculo), 1, arqVeiculos)) {
                        
                if (strcmp(usuario.veiculos[j], veiculo.crv) == 0){
                    printf("   \t\tCRV: %s \n   \t\tPlaca: %s\n   \t\tMarca: %s\n   \t\tModelo: %s\n   \t\tAno: %s\n   \t\tCor: %s\n\n", veiculo.crv, veiculo.placa, veiculo.marca, veiculo.modelo, veiculo.ano, veiculo.cor);
                }
                        
            }
            idCarro = 0;
                    
        }    
        printf("--------------------------------------------------------\n");
        idRegistro++;
                
    }
    fclose(arqUsuarios);
    fclose(arqVeiculos);

}


int main() {
    
    FILE *arqUsuarios;
    FILE *arqVeiculos;

    int id, qtUsuarios;
    int j,k, i, opcao, numUsuario, numVeiculo = 0;
    int idRegistro, idCarro = 0;

    while (opcao != 3) {
        menu();
        scanf ("%d", &opcao);

        switch (opcao)
        {
        case 1:
            printf("Número de Usuários a serem cadastrados: ");
            scanf("%d", &qtUsuarios);
            for (int k = 0; k < qtUsuarios; k++)
            {
                numUsuario = k + 1;

                arqUsuarios = fopen("bdUsuarios.bin", "a");
                arqVeiculos = fopen("bdVeiculos.bin", "a");

                printf("Digite o nome do usuário %d: ",numUsuario);
                scanf(" %[^\n]", usuario.nome);

                printf("Digite o CPF do Usuário %d: ",numUsuario);
                scanf("%s", usuario.cpf);

                printf("Quantos carros esse usuário possui? ");
                scanf("%d", &usuario.qtVeiculos);

                for (int j = 0; j < usuario.qtVeiculos; j++)
                {
                    numVeiculo = j + 1;

                    printf("Digite o CRV do Veículo %d: ",numVeiculo);
                    scanf(" %[^\n]", veiculo.crv);
                    strcpy(usuario.veiculos[j], veiculo.crv);

                    printf("Digite a placa do Veículo %d: ",numVeiculo);
                    scanf(" %[^\n]", veiculo.placa);

                    printf("Digite a marca do Veículo %d: ",numVeiculo);
                    scanf(" %[^\n]", veiculo.marca);

                    printf("Digite o modelo do Veículo %d: ",numVeiculo);
                    scanf(" %[^\n]", veiculo.modelo);

                    printf("Digite o ano do Veículo %d: ",numVeiculo);
                    scanf(" %[^\n]", veiculo.ano);

                    printf("Digite a cor do Veículo %d: ",numVeiculo);
                    scanf(" %[^\n]", veiculo.cor);
                   

                    fwrite(&veiculo,1, sizeof(Veiculo), arqVeiculos);

                    numVeiculo = 0;
                
                }

                numUsuario = 0;

                fwrite(&usuario,1, sizeof(Usuario), arqUsuarios);

                fclose(arqUsuarios);
                fclose(arqVeiculos);

            }
            system("clear");

            printf(">>>>>>>> Registro(s) feito(s) com sucesso! <<<<<<<< \n");
            
            registro(arqUsuarios, arqVeiculos);

            break;

        case 2:

            registro(arqUsuarios, arqVeiculos);
            
            printf("========================================================\n");

            break;

            default:
                break;

        
        }
    }

    return 0;
}