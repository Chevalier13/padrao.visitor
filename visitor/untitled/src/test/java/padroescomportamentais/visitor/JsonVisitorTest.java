
package padroescomportamentais.visitor;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JsonVisitorTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void deveConverterAlunoParaJson() throws Exception {

        Aluno aluno = new Aluno(
                1, "Ana",
                new Curso("Sistemas de Informacao")
        );

        JsonVisitor visitor = new JsonVisitor();

        String resultado = visitor.converter(aluno);

        JsonNode json = objectMapper.readTree(resultado);

        assertEquals("Aluno", json.get("tipo").asText());
        assertEquals(1, json.get("matricula").asInt());
        assertEquals("Ana", json.get("nome").asText());
        assertEquals(
                "Sistemas de Informacao",
                json.get("curso").asText()
        );
    }

    @Test
    void deveConverterProfessorParaJson() throws Exception {

        Professor professor =
                new Professor(101, "Maria", "Doutorado");

        JsonVisitor visitor = new JsonVisitor();

        String resultado = visitor.converter(professor);

        JsonNode json = objectMapper.readTree(resultado);

        assertEquals("Professor", json.get("tipo").asText());
        assertEquals(101, json.get("matricula").asInt());
        assertEquals("Maria", json.get("nome").asText());
        assertEquals("Doutorado", json.get("titulacao").asText());
    }

    @Test
    void deveConverterFuncionarioParaJson() throws Exception {

        Funcionario funcionario =
                new Funcionario(201, "Pedro", 5000.0f);

        JsonVisitor visitor = new JsonVisitor();

        String resultado = visitor.converter(funcionario);

        JsonNode json = objectMapper.readTree(resultado);

        assertEquals("Funcionario", json.get("tipo").asText());
        assertEquals(201, json.get("codigo").asInt());
        assertEquals("Pedro", json.get("nome").asText());
        assertEquals(5000.0, json.get("salario").asDouble(), 0.01);
    }

}
