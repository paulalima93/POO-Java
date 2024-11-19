import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClinicaMedica clinicaMedica = new ClinicaMedica();
        SistemaDeEventos sistemaDeEventos = new SistemaDeEventos();
        SistemaDeRestaurante sistemaDeRestaurante = new SistemaDeRestaurante();
        
        while (true) {
            System.out.println("===== MENU PRINCIPAL =====");
            System.out.println("1. Sistema de Clínica Médica");
            System.out.println("2. Sistema de Eventos");
            System.out.println("3. Sistema de Restaurante");
            System.out.println("4. Gerenciar Evento Beneficente");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    menuClinicaMedica(clinicaMedica, scanner);
                    break;
                case 2:
                    menuSistemaDeEventos(sistemaDeEventos, scanner);
                    break;
                case 3:
                    menuSistemaDeRestaurante(sistemaDeRestaurante, scanner);
                    break;
                case 4:
                    gerenciarEventoBeneficente(sistemaDeRestaurante, clinicaMedica, scanner);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    public static void menuClinicaMedica(ClinicaMedica clinicaMedica, Scanner scanner) {
        while (true) {
            System.out.println("===== MENU CLÍNICA MÉDICA =====");
            System.out.println("1. Cadastrar Paciente");
            System.out.println("2. Cadastrar Médico");
            System.out.println("3. Agendar Consulta");
            System.out.println("4. Gerar Relatório de Consultas");
             System.out.println("5. listar Pacientes");
            System.out.println("6. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.print("Nome do paciente: ");
                    String nomePaciente = scanner.nextLine();
                    System.out.print("CPF do paciente: ");
                    String cpfPaciente = scanner.nextLine();
                    clinicaMedica.cadastrarPaciente(nomePaciente, cpfPaciente);
                    break;
                case 2:
                    System.out.print("Nome do médico: ");
                    String nomeMedico = scanner.nextLine();
                    System.out.print("Especialidade do médico: ");
                    String especialidade = scanner.nextLine();
                    clinicaMedica.cadastrarMedico(nomeMedico, especialidade);
                    break;
                case 3:
                    System.out.print("CPF do paciente: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Especialidade: ");
                    String especialidadeConsulta = scanner.nextLine();
                    System.out.print("Data da consulta: ");
                    String dataConsulta = scanner.nextLine();
                    clinicaMedica.agendarConsulta(cpf, especialidadeConsulta, dataConsulta);
                    break;
                case 4:
                    clinicaMedica.gerarRelatoriosConsultas();
                    break;
                case 5:
                    clinicaMedica.listarPacientes();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
    
    public static void menuSistemaDeEventos(SistemaDeEventos sistemaDeEventos, Scanner scanner) {
        while (true) {
            System.out.println("===== MENU SISTEMA DE EVENTOS =====");
            System.out.println("1. Registrar Evento");
            System.out.println("2. Registrar Participantes");
            System.out.println("3. Verificar Lotação do Evento");
            System.out.println("4. Verificar Evento Mais Lucrativo");
            System.out.println("5. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.print("Nome do evento: ");
                    String nomeEvento = scanner.nextLine();
                    System.out.print("Nome do ingresso: ");
                    String nomeIngresso = scanner.nextLine();
                    System.out.print("Valor do ingresso: ");
                    double valorIngresso = scanner.nextDouble();
                    scanner.nextLine(); 
                    System.out.print("Data do evento: ");
                    String dataEvento = scanner.nextLine();
                    sistemaDeEventos.registrarEvento(nomeEvento, nomeIngresso, valorIngresso, dataEvento);
                    break;
                case 2:
                    System.out.print("Nome do evento: ");
                    String eventoNome = scanner.nextLine();
                    System.out.print("Nome do ingresso comprado: ");
                    String tipoIngresso = scanner.nextLine();
                    System.out.print("Quantidade de pessoas no evento: ");
                    int quantidadePessoas = scanner.nextInt();
                    scanner.nextLine(); 
                    sistemaDeEventos.registrarParticipantes(eventoNome, tipoIngresso, quantidadePessoas);
                    break;
                case 3:
                    System.out.print("Nome do evento: ");
                    String nomeEventoLotacao = scanner.nextLine();
                    sistemaDeEventos.verificarLotacao(nomeEventoLotacao);
                    break;
                case 4:
                    sistemaDeEventos.verificarEventos();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }  
    
    public static void menuSistemaDeRestaurante(SistemaDeRestaurante sistema, Scanner scanner) {
        while (true) {
            System.out.println("===== MENU RESTAURANTE =====");
            System.out.println("1. Adicionar Item ao Cardápio");
            System.out.println("2. Registrar Pedido de Mesa");
            System.out.println("3. Checar Mesas");
            System.out.println("4. Ver pratos mais selcionados");
            System.out.println("5. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.print("Nome do item: ");
                    String nomeItem = scanner.nextLine();
                    System.out.print("Valor do item: ");
                    double valorItem = scanner.nextDouble();
                    scanner.nextLine(); 
                    sistema.adicionarItemAoCardapio(nomeItem, valorItem);
                    break;

                case 2:
                    sistema.exibirCardapio();
                    Pedido pedido = new Pedido();
                    while (true) {
                        System.out.print("Escolha um item pelo número (ou 0 para finalizar): ");
                        int numItem = scanner.nextInt() - 1;
                        scanner.nextLine(); 

                        if (numItem == -1) break; 

                        ItemDoPedido item = sistema.getItemDoCardapio(numItem);
                        if (item == null) {
                            System.out.println("Item inválido.");
                        } else {
                            pedido.adicionarItem(item);
                        }
                    }
                    System.out.print("Número da mesa (1 a 50): ");
                    int numeroMesa = scanner.nextInt();
                    scanner.nextLine(); 
                    sistema.registrarPedido(numeroMesa, pedido);
                    break;

                case 3:
                    sistema.checarMesas();
                    break;
                    
                case 4:
                    
                    sistema.getItemMaisPedido();
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
    
    public static void gerenciarEventoBeneficente(
            SistemaDeRestaurante sistemaDeRestaurante, 
            ClinicaMedica clinicaMedica, 
            Scanner scanner) {

        System.out.print("Nome do evento: ");
        String nomeEvento = scanner.nextLine();

        System.out.print("Quantidade de marmitas a serem doadas: ");
        int quantidadeMarmitas = scanner.nextInt();
        scanner.nextLine(); 

        List<Medico> medicos = clinicaMedica.getMedicos();
        if (medicos.isEmpty()) {
            System.out.println("Nenhum médico cadastrado no sistema.");
            return;
        }

        System.out.println("Escolha um médico para o evento:");
        for (int i = 0; i < medicos.size(); i++) {
            System.out.println((i + 1) + ". " + medicos.get(i).getNome() + 
                               " - " + medicos.get(i).getEspecialidade());
        }
        int indiceMedico = scanner.nextInt() - 1;
        scanner.nextLine(); 

        if (indiceMedico < 0 || indiceMedico >= medicos.size()) {
            System.out.println("Médico inválido.");
            return;
        }
        Medico medicoEscolhido = medicos.get(indiceMedico);

        sistemaDeRestaurante.exibirCardapio();
        System.out.print("Escolha o prato pelo número: ");
        int indicePrato = scanner.nextInt() - 1;
        scanner.nextLine();

        ItemDoPedido pratoEscolhido = sistemaDeRestaurante.getItemDoCardapio(indicePrato);
        if (pratoEscolhido == null) {
            System.out.println("Prato inválido.");
            return;
        }

        EventoBeneficente evento = new EventoBeneficente(nomeEvento, quantidadeMarmitas, medicoEscolhido, pratoEscolhido);
        evento.mostrarDetalhes();
    }
}
