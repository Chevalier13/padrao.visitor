
package padroescomportamentais.visitor;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Curso curso1 = new Curso("Sistemas de Informacao");
        Curso curso2 = new Curso("Ciencia da Computacao");

        Aluno aluno1 = new Aluno(1, "Ana", curso1);
        Aluno aluno2 = new Aluno(2, "Carlos", curso2);

        Professor professor1 =
                new Professor(101, "Maria", "Doutorado");

        Professor professor2 =
                new Professor(102, "Joao", "Mestrado");

        Funcionario funcionario1 =
                new Funcionario(201, "Pedro", 5000.0f);

        Funcionario funcionario2 =
                new Funcionario(202, "Mariana", 3500.0f);

        List<Pessoa> pessoas = Arrays.asList(
                aluno1,
                aluno2,
                professor1,
                professor2,
                funcionario1,
                funcionario2
        );

        System.out.println("\n========== DADOS DAS PESSOAS ==========");

        PessoaVisitor pessoaVisitor = new PessoaVisitor();

        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoaVisitor.exibir(pessoa));
        }

        System.out.println("\n========== RELATORIOS ==========");

        RelatorioVisitor relatorioVisitor =
                new RelatorioVisitor();

        for (Pessoa pessoa : pessoas) {
            System.out.println(
                    relatorioVisitor.gerarRelatorio(pessoa)
            );
        }

        System.out.println("\n========== ESTATISTICAS ==========");

        EstatisticaVisitor estatisticaVisitor =
                new EstatisticaVisitor();

        for (Pessoa pessoa : pessoas) {
            pessoa.aceitar(estatisticaVisitor);
        }

        System.out.println(estatisticaVisitor.gerarResumo());

        System.out.println("\n========== CALCULOS SALARIAIS ==========");

        SalarioVisitor salarioVisitor =
                new SalarioVisitor();

        for (Pessoa pessoa : pessoas) {
            System.out.println(salarioVisitor.calcular(pessoa));
        }

        System.out.println(
                salarioVisitor.gerarResumoFinanceiro()
        );

        System.out.println("\n========== EXPORTACAO JSON ==========");

        JsonVisitor jsonVisitor = new JsonVisitor();

        for (Pessoa pessoa : pessoas) {
            System.out.println(jsonVisitor.converter(pessoa));
        }

    }

}
