package br.com.poc.etl.llm.outbound.llm;

import br.com.poc.etl.llm.core.dto.MapeamentoDTO;
import br.com.poc.etl.llm.core.repository.AnaliseRepository;
import br.com.poc.etl.llm.core.repository.FormatadorRepository;
import br.com.poc.etl.llm.outbound.llm.config.LlmConfig;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class AnaliseRepositoryImpl implements AnaliseRepository {

    private final LlmConfig llmConfig;

    private final FormatadorRepository formatadorRepository;

    @Override
    @SneakyThrows
    public MapeamentoDTO processarDados(String documento) {
        var chatModel = llmConfig.executar();
        Map<String, Object> params = new HashMap<>();
        params.put("document", documento);
        params.put("format", carregarPrompt());

        String mapeamentoDTO = ChatClient.create(chatModel).prompt()
                .user(u -> u.text("Retorne apenas a estrutura json: {format} de acordo com os dados a seguir: {document}. Você deve retornar um unico item, se atentando aos campos que são listas []. Para os campos que não são listas, deve analisar e agrupar as informações. ")
                        .params(params))
                .call()
                .content();
        return formatadorRepository.executar(mapeamentoDTO);
    }

    public String carregarPrompt() throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("prompt/prompt.json");
        return new String(inputStream.readAllBytes());
    }

}
