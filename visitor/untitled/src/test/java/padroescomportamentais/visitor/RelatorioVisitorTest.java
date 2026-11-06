
package padroescomportamentais.visitor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RelatorioVisitorTest {

    @Test
    void deveGerarRelatorioAluno() {

        Aluno aluno = new Aluno(
                1, "Ana",
                new Curso("Sistemas de Informacao")
        );

        RelatorioVisitor visitor = new RelatorioVisitor();

        String resultado = visitor.gerarRelatorio(aluno);

        assertTrue(resultado.contains("RELATORIO DO ALUNO"));
        assertTrue(resultado.contains("Matricula: 1"));
        assertTrue(resultado.contains("Nome: Ana"));
        assertTrue(resultado.contains("Curso: Sistemas de Informacao"));
    }

    @Test
    void deveGerarRelatorioProfessor() {

        Professor professor =
                new Professor(101, "Maria", "Doutorado");

        RelatorioVisitor visitor = new RelatorioVisitor();

        String resultado = visitor.gerarRelatorio(professor);

        assertTrue(resultado.contains("RELATORIO DO PROFESSOR"));
        assertTrue(resultado.contains("Nome: Maria"));
        assertTrue(resultado.contains("Titulacao: Doutorado"));
    }

    @Test
    void deveGerarRelatorioFuncionario() {

        Funcionario funcionario =
                new Funcionario(201, "Pedro", 5000.0f);

        RelatorioVisitor visitor = new RelatorioVisitor();

        String resultado = visitor.gerarRelatorio(funcionario);

        assertTrue(resultado.contains("RELATORIO DO FUNCIONARIO"));
        assertTrue(resultado.contains("Nome: Pedro"));
        assertTrue(resultado.contains("Salario: R$ 5000,00")
                || resultado.contains("Salario: R$ 5000.00"));
    }

}
