package br.com.poc.etl.llm.outbound.llm;

import br.com.poc.etl.llm.core.dto.MapeamentoDTO;
import br.com.poc.etl.llm.core.entity.Entrevista;
import br.com.poc.etl.llm.core.entity.Vaga;
import br.com.poc.etl.llm.core.repository.FormatadorRepository;
import br.com.poc.etl.llm.core.repository.MapeamentoRepository;
import br.com.poc.etl.llm.outbound.llm.config.LlmConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class MapeamentoRepositoryImpl implements MapeamentoRepository {

    private final LlmConfig llmConfig;

    private final FormatadorRepository formatadorRepository;

    @Override
    public void popularEntidades(String mapeamentoDTO) {
        var chatModel = llmConfig.executar();
        List<String> jsons = formatadorRepository.extrairJsonObjects(mapeamentoDTO);
        List<Entrevista> entrevistas = converterJsonParaEntidades(jsons, Entrevista.class, chatModel);
        List<Vaga> vagas = converterJsonParaEntidades(jsons, Vaga.class, chatModel);
        return;
    }

    public <T> List<T> converterJsonParaEntidades(List<String> jsons, Class<T> entidadeClass, OpenAiChatModel chatModel) {
        List<T> entidades = new ArrayList<>();
        Map<String, Object> params = new HashMap<>();

        for (String json : jsons) {
            params.put("json", json);
            params.put("entidade", entidadeClass);

            T entidade = ChatClient.create(chatModel).prompt()
                    .user(u -> u.text("Converta o json a seguir {json} para a entidade: {entidade}")
                            .params(params))
                    .call()
                    .entity(entidadeClass);

            entidades.add(entidade);
        }

        return entidades;
    }
}
