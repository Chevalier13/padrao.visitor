
package padroescomportamentais.visitor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalarioVisitorTest {

    @Test
    void deveCalcularSalarioFuncionario() {

        Funcionario funcionario =
                new Funcionario(201, "Pedro", 5000.0f);

        SalarioVisitor visitor = new SalarioVisitor();

        String resultado = visitor.calcular(funcionario);

        assertTrue(resultado.contains("Funcionario: Pedro"));

        assertEquals(5000.0f, visitor.getTotalSalariosMensais());
        assertEquals(65000.0f, visitor.getTotalSalariosAnuais());
    }

    @Test
    void naoDeveCalcularSalarioDeAluno() {

        Aluno aluno =
                new Aluno(1, "Ana", new Curso("Sistemas"));

        SalarioVisitor visitor = new SalarioVisitor();

        String resultado = visitor.calcular(aluno);

        assertTrue(resultado.contains(
                "Calculo salarial nao aplicavel ao aluno Ana"
        ));

        assertEquals(0.0f, visitor.getTotalSalariosMensais());
        assertEquals(0.0f, visitor.getTotalSalariosAnuais());
    }

    @Test
    void deveAcumularSalariosDeVariosFuncionarios() {

        Funcionario funcionario1 =
                new Funcionario(201, "Pedro", 5000.0f);

        Funcionario funcionario2 =
                new Funcionario(202, "Mariana", 3500.0f);

        SalarioVisitor visitor = new SalarioVisitor();

        funcionario1.aceitar(visitor);
        funcionario2.aceitar(visitor);

        assertEquals(8500.0f, visitor.getTotalSalariosMensais());
        assertEquals(110500.0f, visitor.getTotalSalariosAnuais());
    }

}
