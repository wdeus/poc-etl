package br.com.poc.etl.llm.outbound.parser;

import br.com.poc.etl.llm.core.dto.MapeamentoDTO;
import br.com.poc.etl.llm.core.repository.FormatadorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class FormatadorRepositoryImpl implements FormatadorRepository {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public MapeamentoDTO executar(String json) {
        int startIndex = json.indexOf("{");
        int endIndex = json.lastIndexOf("}");
        String response = "";

        if (startIndex != -1 && endIndex != -1) {
            response = json.substring(startIndex, endIndex + 1);
        }
        MapeamentoDTO mapeamentoDTO = new MapeamentoDTO();
        try {
            mapeamentoDTO = objectMapper.readValue(response, MapeamentoDTO.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mapeamentoDTO;
    }
}
