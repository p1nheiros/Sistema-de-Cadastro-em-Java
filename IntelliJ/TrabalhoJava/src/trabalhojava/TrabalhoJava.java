package trabalhojava;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TrabalhoJava {

    public static void inserirPessoa(String[][] matriz, int linhas, int colunas) {
        Scanner scanner = new Scanner(System.in);
        int linha;

        mostrarPessoas(matriz, linhas, colunas);

        do {
            try {
                System.out.println("Informe onde você deseja cadastrar a pessoa com valores de 1 à " + linhas);
                linha = Integer.parseInt(scanner.nextLine());

                if (linha < 1 || linha > linhas) {
                    System.out.println("Valor inválido! Insira um número entre 1 e " + linhas + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Somente números são aceitos. Insira novamente.");
                linha = -1; // Definir um valor inválido para continuar no loop
            }
        } while (linha < 1 || linha > linhas);

        System.out.println("Insira o nome da pessoa: ");
        String nome = scanner.next();
        if (!nome.matches("[a-zA-Z]+")) {
            System.out.println("Formato de nome inválido! Insira apenas letras.");
            return;
        }
        matriz[linha - 1][0] = nome;

        System.out.println("Insira a data de nascimento (dd/mm/aaaa): ");
        String dataNascimento = scanner.next();
        if (!dataNascimento.matches("\\d{1,2}/\\d{1,2}/\\d{4}")) {
            System.out.println("Formato de data inválido! Insira novamente no formato dd/mm/aaaa.");
            return;
        }
        matriz[linha - 1][1] = dataNascimento;

        System.out.println("Insira a cidade: ");
        String cidade = scanner.next();
        if (!cidade.matches("[a-zA-Z]+")) {
            System.out.println("Formato de cidade inválido! Insira apenas letras.");
            return;
        }
        matriz[linha - 1][2] = cidade;

        System.out.println("Insira o estado: ");
        String estado = scanner.next();
        if (!estado.matches("[a-zA-Z]+")) {
            System.out.println("Formato de estado inválido! Insira apenas letras.");
            return;
        }
        matriz[linha - 1][3] = estado;

        System.out.println("Insira o número de celular: ");
        String numeroCelular = scanner.next();
        if (!numeroCelular.matches("\\d{1,11}")) {
            System.out.println("Formato de número de celular inválido! Insira apenas números com até 11 dígitos.");
            return;
        }
        matriz[linha - 1][4] = numeroCelular;


        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String formattedDateTime = now.format(formatter);
        matriz[linha - 1][5] = formattedDateTime;

        System.out.println("Pessoa adicionada.");
    }

    public static void adicionarPacote(String[][] matriz, int linhas, int colunas) {
        Scanner scanner = new Scanner(System.in);
        int linha;

        mostrarPessoas(matriz, linhas, colunas);
        do {
            System.out.println("Informe o número do cadastro para adicionar o pacote: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Formato de número inválido! Insira um número válido.");
                scanner.next();
            }
            linha = scanner.nextInt();
        } while (linha < 1 || linha > linhas);

        if (matriz[linha - 1][0] == null) {
            System.out.println("Cadastro não encontrado na linha selecionada!");
            return;
        }

        System.out.println("Escolha um pacote de pagamento:\n1 - Mensal (R$50)\n2 - Semestral (R$270)\n3 - Anual (R$570)");
        int pacote;
        String valorPacote;

        while (true) {
            String input = scanner.next();
            if (input.matches("\\d+")) {
                pacote = Integer.parseInt(input);
                if (pacote >= 1 && pacote <= 3) {
                    break;
                }
            }
            System.out.println("Opção inválida! Insira um número válido correspondente ao pacote.");
        }

        switch (pacote) {
            case 1:
                valorPacote = "R$50";
                break;
            case 2:
                valorPacote = "R$270";
                break;
            case 3:
                valorPacote = "R$570";
                break;
            default:
                valorPacote = "R$50";
                break;
        }

        matriz[linha - 1][6] = valorPacote;

        System.out.println("Pacote adicionado à pessoa selecionada.");
    }

    public static void editarCadastro(String[][] matriz, int linhas, int colunas) {
        Scanner scanner = new Scanner(System.in);
        int linha;

        mostrarPessoas(matriz, linhas, colunas);
        do {
            System.out.println("Informe o número da pessoa para editar o cadastro: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Formato de número inválido! Insira um número válido.");
                scanner.next();
            }
            linha = scanner.nextInt();
        } while (linha < 1 || linha > linhas);

        if (matriz[linha - 1][0] == null) {
            System.out.println("Cadastro não encontrado na linha selecionada!");
            return;
        }

        System.out.println("Edição de cadastro da pessoa " + linha + ":");
        System.out.println("Insira o novo nome da pessoa: ");
        String nome;

        while (true) {
            nome = scanner.next();
            if (nome.matches("[a-zA-Z]+")) {
                break;
            }
            System.out.println("Formato de nome inválido! Insira apenas letras.");
        }

        System.out.println("Insira a nova data de nascimento (dd/mm/aaaa): ");
        String dataNascimento;

        while (true) {
            dataNascimento = scanner.next();
            if (dataNascimento.matches("\\d{2}/\\d{2}/\\d{4}")) {
                break;
            }
            System.out.println("Formato de data inválido! Insira no formato dd/mm/aaaa.");
        }

        System.out.println("Insira a nova cidade: ");
        String cidade;

        while (true) {
            cidade = scanner.next();
            if (cidade.matches("[a-zA-Z]+")) {
                break;
            }
            System.out.println("Formato de cidade inválido! Insira apenas letras.");
        }

        System.out.println("Insira o novo estado: ");
        String estado;

        while (true) {
            estado = scanner.next();
            if (estado.matches("[a-zA-Z]+")) {
                break;
            }
            System.out.println("Formato de estado inválido! Insira apenas letras.");
        }

        System.out.println("Insira o novo número de celular: ");
        String numeroCelular;

        while (true) {
            numeroCelular = scanner.next();
            if (numeroCelular.matches("\\d{1,11}")) {
                break;
            }
            System.out.println("Formato de número de celular inválido! Insira apenas números com até 11 dígitos.");
        }

        matriz[linha - 1][0] = nome;
        matriz[linha - 1][1] = dataNascimento;
        matriz[linha - 1][2] = cidade;
        matriz[linha - 1][3] = estado;
        matriz[linha - 1][4] = numeroCelular;

        System.out.println("Cadastro atualizado com sucesso.");
    }


    public static void alterarPlanoPacote(String[][] matriz, int linhas, int colunas) {
        Scanner scanner = new Scanner(System.in);
        int linha;

        mostrarPessoas(matriz, linhas, colunas);
        do {
            System.out.println("Informe o número da pessoa para alterar o pacote: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Formato de número inválido! Insira um número válido.");
                scanner.next();
            }
            linha = scanner.nextInt();
        } while (linha < 1 || linha > linhas);

        if (matriz[linha - 1][0] == null) {
            System.out.println("Cadastro não encontrado na linha selecionada!");
            return;
        }

        System.out.println("Pacote atual: " + matriz[linha - 1][6]);
        System.out.println("Escolha um novo pacote de pagamento:\n1 - Mensal (R$50)\n2 - Semestral (R$270)\n3 - Anual (R$570)");
        int pacote;
        while (true) {
            while (!scanner.hasNextInt()) {
                System.out.println("Formato de número inválido! Insira um número válido.");
                scanner.next();
            }
            pacote = scanner.nextInt();
            if (pacote >= 1 && pacote <= 3) {
                break;
            }
            System.out.println("Opção inválida! Insira um número correspondente a um pacote válido.");
        }

        String valorPacote;
        switch (pacote) {
            case 1:
                valorPacote = "R$50";
                break;
            case 2:
                valorPacote = "R$270";
                break;
            case 3:
                valorPacote = "R$570";
                break;
            default:
                System.out.println("Opção inválida! O pacote será mantido como está.");
                return;
        }

        matriz[linha - 1][6] = valorPacote;

        System.out.println("Pacote alterado com sucesso.");
    }

    public static void mostrarPessoas(String[][] matriz, int linhas, int colunas) {
        System.out.println("Nome | Data de Nascimento | Cidade | Estado | Celular | Data e Hora de Cadastro | Pacote | Feedback ");
        for (int i = 0; i < linhas; i++) {
            System.out.print((i + 1) + " - ");
            for (int j = 0; j < colunas; j++) {
                System.out.print(matriz[i][j] + " | ");
            }
            System.out.println();
        }
    }

    public static void adicionarFeedback(String[][] matriz, int linhas, int colunas) {
        Scanner scanner = new Scanner(System.in);
        int linha;

        mostrarPessoas(matriz, linhas, colunas);
        do {
            System.out.println("Informe o número do cadastro para adicionar o feedback: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Formato de número inválido! Insira um número válido.");
                scanner.next();
            }
            linha = scanner.nextInt();
        } while (linha < 1 || linha > linhas);

        if (matriz[linha - 1][0] == null) {
            System.out.println("Cadastro não encontrado na linha selecionada!");
            return;
        }

        System.out.println("Escolha uma opção de feedback:\n1 - Muito Bom\n2 - Bom\n3 - Normal\n4 - Ruim\n5 - Péssimo");
        int feedback;
        while (true) {
            while (!scanner.hasNextInt()) {
                System.out.println("Formato de número inválido! Insira um número válido.");
                scanner.next();
            }
            feedback = scanner.nextInt();
            if (feedback >= 1 && feedback <= 5) {
                break;
            }
            System.out.println("Opção inválida! Insira um número correspondente a uma opção de feedback válida.");
        }

        String descricaoFeedback;
        switch (feedback) {
            case 1:
                descricaoFeedback = "Muito Bom";
                break;
            case 2:
                descricaoFeedback = "Bom";
                break;
            case 3:
                descricaoFeedback = "Normal";
                break;
            case 4:
                descricaoFeedback = "Ruim";
                break;
            case 5:
                descricaoFeedback = "Péssimo";
                break;
            default:
                System.out.println("Opção inválida! O feedback será considerado como Normal.");
                descricaoFeedback = "Normal";
                break;
        }

        matriz[linha - 1][7] = descricaoFeedback;

        System.out.println("Feedback adicionado à pessoa selecionada.");
    }

    public static void alterarFeedback(String[][] matriz, int linhas, int colunas) {
        Scanner scanner = new Scanner(System.in);
        int linha;

        mostrarPessoas(matriz, linhas, colunas);
        do {
            System.out.println("Informe o número da pessoa para alterar o feedback: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Formato de número inválido! Insira um número válido.");
                scanner.next();
            }
            linha = scanner.nextInt();
        } while (linha < 1 || linha > linhas);

        if (matriz[linha - 1][0] == null) {
            System.out.println("Cadastro não encontrado na linha selecionada!");
            return;
        }

        System.out.println("Feedback atual: " + matriz[linha - 1][7]);
        System.out.println("Escolha um novo feedback:\n1 - Muito Bom\n2 - Bom\n3 - Normal\n4 - Ruim\n5 - Péssimo");
        int feedback;
        while (true) {
            while (!scanner.hasNextInt()) {
                System.out.println("Formato de número inválido! Insira um número válido.");
                scanner.next();
            }
            feedback = scanner.nextInt();
            if (feedback >= 1 && feedback <= 5) {
                break;
            }
            System.out.println("Opção inválida! Insira um número correspondente a um feedback válido.");
        }

        matriz[linha - 1][7] = Integer.toString(feedback);

        System.out.println("Feedback alterado para a pessoa selecionada.");
    }

    public static void removerCadastro(String[][] matriz, int linhas, int colunas) {
        Scanner scanner = new Scanner(System.in);
        int cadastro;

        mostrarPessoas(matriz, linhas, colunas);
        do {
            System.out.println("Informe o número do cadastro para remover: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Formato de número inválido! Insira um número válido.");
                scanner.next();
            }
            cadastro = scanner.nextInt();
        } while (cadastro < 1 || cadastro > linhas);

        if (matriz[cadastro - 1][0] == null) {
            System.out.println("Cadastro não encontrado na linha selecionada!");
            return;
        }

        matriz[cadastro - 1][0] = null;
        matriz[cadastro - 1][1] = null;
        matriz[cadastro - 1][2] = null;
        matriz[cadastro - 1][3] = null;
        matriz[cadastro - 1][4] = null;
        matriz[cadastro - 1][5] = null;
        matriz[cadastro - 1][6] = null;
        matriz[cadastro - 1][7] = null;

        System.out.println("Cadastro removido com sucesso.");
    }

    public static void main(String[] args) {
        String[][] lista;
        int pessoas = 0;
        int opcao;
        int colunas = 8;
        Scanner scanner = new Scanner(System.in);

        while (pessoas <= 0) {
            try {
                System.out.println("Insira a quantidade de pessoas que serão cadastradas na academia:");
                pessoas = Integer.parseInt(scanner.nextLine());
                if (pessoas <= 0) {
                    System.out.println("Quantidade inválida! Insira um número positivo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Somente números são aceitos. Insira novamente.");
            }
        }

        lista = new String[pessoas][colunas];

        do {
            try {
                System.out.println("Escolha uma opção:\n1 - Mostrar lista de pessoas cadastradas.\n2 - Cadastrar pessoa na lista.\n3 - Adicionar pacote de pagamento.\n4 - Editar cadastro.\n5 - Alterar plano do pacote.\n6 - Adicionar feedback.\n7 - Alterar feedback.\n8 - Remover cadastro. \n0 - Sair.");
                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 0:
                        break;
                    case 1:
                        mostrarPessoas(lista, pessoas, colunas);
                        break;
                    case 2:
                        inserirPessoa(lista, pessoas, colunas);
                        break;
                    case 3:
                        adicionarPacote(lista, pessoas, colunas);
                        break;
                    case 4:
                        editarCadastro(lista, pessoas, colunas);
                        break;
                    case 5:
                        alterarPlanoPacote(lista, pessoas, colunas);
                        break;
                    case 6:
                        adicionarFeedback(lista, pessoas, colunas);
                        break;
                    case 7:
                        alterarFeedback(lista, pessoas, colunas);
                        break;
                    default:
                        System.out.println("Opção inválida!");
                    case 8:
                        removerCadastro(lista, pessoas, colunas);
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Somente números são aceitos. Insira novamente.");
                opcao = -1;
            }
        } while (opcao != 0);

    }
}