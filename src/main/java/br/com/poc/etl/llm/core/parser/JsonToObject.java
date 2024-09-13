package br.com.poc.etl.llm.core.parser;

import br.com.poc.etl.llm.core.dto.MapeamentoDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonToObject {

    private ObjectMapper objectMapper = new ObjectMapper();

    public MapeamentoDTO convert(String json){
        MapeamentoDTO mapeamentoDTO = new MapeamentoDTO();
        try {
            mapeamentoDTO = objectMapper.readValue(json, MapeamentoDTO.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mapeamentoDTO;
    }


}
