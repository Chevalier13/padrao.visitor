
package padroescomportamentais.visitor;

public class SalarioVisitor implements Visitor {

    private float totalSalariosMensais;
    private float totalSalariosAnuais;

    public String calcular(Pessoa pessoa) {
        return pessoa.aceitar(this);
    }

    @Override
    public String exibirAluno(Aluno aluno) {
        return "Calculo salarial nao aplicavel ao aluno "
                + aluno.getNome();
    }

    @Override
    public String exibirProfessor(Professor professor) {
        return "Calculo salarial nao aplicavel ao professor "
                + professor.getNome();
    }

    @Override
    public String exibirFuncionario(Funcionario funcionario) {

        float salarioMensal = funcionario.getSalario();
        float decimoTerceiro = salarioMensal;
        float salarioAnual = (salarioMensal * 12) + decimoTerceiro;

        totalSalariosMensais += salarioMensal;
        totalSalariosAnuais += salarioAnual;

        return "========== CALCULO SALARIAL ==========\n" +
                "Funcionario: " + funcionario.getNome() + "\n" +
                String.format("Salario mensal: R$ %.2f%n", salarioMensal) +
                String.format("Decimo terceiro: R$ %.2f%n", decimoTerceiro) +
                String.format("Salario anual: R$ %.2f", salarioAnual) +
                "\n======================================";
    }

    public float getTotalSalariosMensais() {
        return totalSalariosMensais;
    }

    public float getTotalSalariosAnuais() {
        return totalSalariosAnuais;
    }

    public String gerarResumoFinanceiro() {
        return "========== RESUMO FINANCEIRO ==========\n" +
                String.format("Total mensal: R$ %.2f%n",
                        totalSalariosMensais) +
                String.format("Total anual: R$ %.2f",
                        totalSalariosAnuais) +
                "\n=======================================";
    }

}
