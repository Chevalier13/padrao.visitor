
package padroescomportamentais.visitor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JsonVisitor implements Visitor {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public String converter(Pessoa pessoa) {
        return pessoa.aceitar(this);
    }

    @Override
    public String exibirAluno(Aluno aluno) {

        ObjectNode json = objectMapper.createObjectNode();

        json.put("tipo", "Aluno");
        json.put("matricula", aluno.getMatricula());
        json.put("nome", aluno.getNome());
        json.put("curso", aluno.getNomeCurso());

        return converterJson(json);
    }

    @Override
    public String exibirProfessor(Professor professor) {

        ObjectNode json = objectMapper.createObjectNode();

        json.put("tipo", "Professor");
        json.put("matricula", professor.getMatricula());
        json.put("nome", professor.getNome());
        json.put("titulacao", professor.getTitulacao());

        return converterJson(json);
    }

    @Override
    public String exibirFuncionario(Funcionario funcionario) {

        ObjectNode json = objectMapper.createObjectNode();

        json.put("tipo", "Funcionario");
        json.put("codigo", funcionario.getCodigo());
        json.put("nome", funcionario.getNome());
        json.put("salario", funcionario.getSalario());

        return converterJson(json);
    }

    private String converterJson(ObjectNode json) {
        try {
            return objectMapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(json);

        } catch (JsonProcessingException e) {
            throw new IllegalStateException(
                    "Erro ao converter objeto para JSON", e
            );
        }
    }

}
