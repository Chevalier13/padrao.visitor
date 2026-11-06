
package padroescomportamentais.visitor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EstatisticaVisitorTest {

    @Test
    void deveContabilizarTodasAsPessoas() {

        EstatisticaVisitor visitor = new EstatisticaVisitor();

        Aluno aluno1 = new Aluno(
                1, "Ana", new Curso("Sistemas")
        );

        Aluno aluno2 = new Aluno(
                2, "Carlos", new Curso("Computacao")
        );

        Professor professor =
                new Professor(101, "Maria", "Doutorado");

        Funcionario funcionario =
                new Funcionario(201, "Pedro", 5000.0f);

        aluno1.aceitar(visitor);
        aluno2.aceitar(visitor);
        professor.aceitar(visitor);
        funcionario.aceitar(visitor);

        assertEquals(2, visitor.getTotalAlunos());
        assertEquals(1, visitor.getTotalProfessores());
        assertEquals(1, visitor.getTotalFuncionarios());
        assertEquals(4, visitor.getTotalPessoas());
    }

    @Test
    void deveGerarResumoEstatistico() {

        EstatisticaVisitor visitor = new EstatisticaVisitor();

        Aluno aluno =
                new Aluno(1, "Ana", new Curso("Sistemas"));

        aluno.aceitar(visitor);

        String resultado = visitor.gerarResumo();

        assertTrue(resultado.contains("Total de alunos: 1"));
        assertTrue(resultado.contains("Total geral: 1"));
    }

}
