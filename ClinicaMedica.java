import java.util.ArrayList;
import java.util.List;

public class ClinicaMedica {
    private List<Paciente> pacientes;
    private List<Medico> medicos;
    private List<Consulta> consultas;

    public ClinicaMedica() {
        this.pacientes = new ArrayList<>();
        this.medicos = new ArrayList<>();
        this.consultas = new ArrayList<>();
    }

    public void cadastrarPaciente(String nome, String cpf) {
        Paciente paciente = new Paciente(nome, cpf);
        pacientes.add(paciente);
        System.out.println("Paciente cadastrado com sucesso.");
    }
    
    public void listarPacientes() {
        System.out.println("=== Lista de pacientes ===");
        if(pacientes.isEmpty()) {
            System.out.println("Nao tem pacientes cadastrados.");
            return;
        }
        for (Paciente paciente : pacientes) {
            System.out.println("- nome: " + paciente.getNome() + 
                                "- Cpf:  " + paciente.getCpf() );
        }
    }
       

    public void cadastrarMedico(String nome, String especialidade) {
        Medico medico = new Medico(nome, especialidade);
        medicos.add(medico);
        System.out.println("Médico cadastrado com sucesso.");
    }

    public void agendarConsulta(String cpfPaciente, String especialidade, String data) {
        Paciente paciente = buscarPaciente(cpfPaciente);
        if (paciente == null) {
            System.out.println("Paciente não encontrado.");
            return;
        }

        Medico medicoDisponivel = buscarMedicoDisponivel(especialidade);
        if (medicoDisponivel == null) {
            System.out.println("Nenhum médico disponível para a especialidade " + especialidade);
            return;
        }

        Consulta consulta = new Consulta(paciente, medicoDisponivel, data);
        consultas.add(consulta);
        System.out.println("Consulta agendada com sucesso.");
    }

    public void gerarRelatoriosConsultas() {
        System.out.println("Relatório de Consultas:");
        for (Consulta consulta : consultas) {
            System.out.println("Paciente: " + consulta.getPaciente().getNome() + 
                               ", Médico: " + consulta.getMedico().getNome() + 
                               ", Data: " + consulta.getData());
        }
    }

    private Paciente buscarPaciente(String cpf) {
        for (Paciente paciente : pacientes) {
            if (paciente.getCpf().equals(cpf)) {
                return paciente;
            }
        }
        return null;
    }

    private Medico buscarMedicoDisponivel(String especialidade) {
        for (Medico medico : medicos) {
            if (medico.getEspecialidade().equals(especialidade) && medico.isDisponivel()) {
                return medico;
            }
        }
        return null;
    }
    
    public List<Medico> getMedicos() {
        return medicos;
    }
}
