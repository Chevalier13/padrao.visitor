
package padroescomportamentais.visitor;

public class EstatisticaVisitor implements Visitor {

    private int totalAlunos;
    private int totalProfessores;
    private int totalFuncionarios;

    @Override
    public String exibirAluno(Aluno aluno) {
        totalAlunos++;
        return "Aluno contabilizado: " + aluno.getNome();
    }

    @Override
    public String exibirProfessor(Professor professor) {
        totalProfessores++;
        return "Professor contabilizado: " + professor.getNome();
    }

    @Override
    public String exibirFuncionario(Funcionario funcionario) {
        totalFuncionarios++;
        return "Funcionario contabilizado: " + funcionario.getNome();
    }

    public int getTotalAlunos() {
        return totalAlunos;
    }

    public int getTotalProfessores() {
        return totalProfessores;
    }

    public int getTotalFuncionarios() {
        return totalFuncionarios;
    }

    public int getTotalPessoas() {
        return totalAlunos + totalProfessores + totalFuncionarios;
    }

    public String gerarResumo() {
        return "========== ESTATISTICAS ==========\n" +
                "Total de alunos: " + totalAlunos + "\n" +
                "Total de professores: " + totalProfessores + "\n" +
                "Total de funcionarios: " + totalFuncionarios + "\n" +
                "Total geral: " + getTotalPessoas() + "\n" +
                "==================================";
    }

}
