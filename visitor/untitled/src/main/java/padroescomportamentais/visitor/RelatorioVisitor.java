
package padroescomportamentais.visitor;

public class RelatorioVisitor implements Visitor {

    public String gerarRelatorio(Pessoa pessoa) {
        return pessoa.aceitar(this);
    }

    @Override
    public String exibirAluno(Aluno aluno) {
        return "========== RELATORIO DO ALUNO ==========\n" +
                "Matricula: " + aluno.getMatricula() + "\n" +
                "Nome: " + aluno.getNome() + "\n" +
                "Curso: " + aluno.getNomeCurso() + "\n" +
                "Situacao: Matriculado\n" +
                "========================================";
    }

    @Override
    public String exibirProfessor(Professor professor) {
        return "======== RELATORIO DO PROFESSOR ========\n" +
                "Matricula: " + professor.getMatricula() + "\n" +
                "Nome: " + professor.getNome() + "\n" +
                "Titulacao: " + professor.getTitulacao() + "\n" +
                "Situacao: Ativo\n" +
                "========================================";
    }

    @Override
    public String exibirFuncionario(Funcionario funcionario) {
        return "======= RELATORIO DO FUNCIONARIO =======\n" +
                "Codigo: " + funcionario.getCodigo() + "\n" +
                "Nome: " + funcionario.getNome() + "\n" +
                "Salario: R$ " +
                String.format("%.2f", funcionario.getSalario()) + "\n" +
                "Situacao: Ativo\n" +
                "========================================";
    }

}
