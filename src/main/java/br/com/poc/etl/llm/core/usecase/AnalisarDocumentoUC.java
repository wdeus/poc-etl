package br.com.poc.etl.llm.core.usecase;

import br.com.poc.etl.llm.core.dto.MapeamentoDTO;
import br.com.poc.etl.llm.core.parser.JsonToObject;
import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.DocumentParser;
import dev.langchain4j.data.document.parser.apache.poi.ApachePoiDocumentParser;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.Generation;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.converter.BeanOutputConverter;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.core.ParameterizedTypeReference;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalisarDocumentoUC {

    public static void main(String[] args) {
        AnalisarDocumentoUC analisarDocumentoUC = new AnalisarDocumentoUC();
        System.out.println(analisarDocumentoUC.extrai());
    }


    public String extrai(){
        String prompt = """
                {
                  "cargoParticipanteRH": ["String"],
                  "criadorProcessoSeletivo": ["String"],
                  "descricaoFeedback": ["String"],
                  "descricaoProcessoSeletivo": ["String"],
                  "dtAberturaVaga": ["String"],
                  "dtAceiteOferta": ["String"],
                  "dtContratacao": ["String"],
                  "dtEntrevista": ["String"],
                  "dtFechamentoVaga": ["String"],
                  "dtFimProcessoSeletivo": ["String"],
                  "dtHora": ["String"],
                  "dtInicioProcessoSeletivo": ["String"],
                  "entrevistador": ["String"],
                  "localizacaoVaga": ["String"],
                  "nomeParticipanteRH": ["String"],
                  "nomeProcessoSeletivo": ["String"],
                  "nrCandidatosInscritos": "Integer",
                  "nrContratacoes": "Integer",
                  "nrEntrevistas": "Integer",
                  "nrPosicoesAbertas": "Integer",
                  "nrPosicoesVaga": ["Integer"],
                  "requisitosVaga": ["String"],
                  "responsavelVaga": ["String"],
                  "resultado": ["String"],
                  "salarioInicial": ["Decimal"],
                  "salarioInicialMedio": "Decimal",
                  "statusProcessoSeletivo": ["String"],
                  "statusVaga": ["String"],
                  "tempoMedioProcesso": "Integer",
                  "tipo": ["String"],
                  "tipoContrato": ["Integer"],
                  "tituloVaga": ["String"]
                }
                           
                """;

        DocumentParser parser = new ApachePoiDocumentParser();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("excel_formatado.xlsx");

        Document document = parser.parse(inputStream);

        var openAiApi = new OpenAiApi("https://api.groq.com/openai", "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");
        var openAiChatOptions = OpenAiChatOptions.builder()
                .withModel("llama3-70b-8192")
                .withMaxTokens(2000)
                .build();
        var chatModel = new OpenAiChatModel(openAiApi, openAiChatOptions);

        Map<String, Object> params = new HashMap<>();
        params.put("document", document.text());
        params.put("format", prompt);

        String mapeamentoDTO = ChatClient.create(chatModel).prompt()
                .user(u -> u.text("Retorne apenas a estrutura json: {format} de acordo com os dados a seguir: {document}. Você deve retornar um unico item, se atentando aos campos que são listas []. Para os campos que não são listas, deve analisar e agrupar as informações. ")
                        .params(params))
                .call()
                .content();

        // Encontra o índice da primeira e última ocorrência de '{' e '}'
        int startIndex = mapeamentoDTO.indexOf("{");
        int endIndex = mapeamentoDTO.lastIndexOf("}");
        String json = "";

        if (startIndex != -1 && endIndex != -1) {
            // Extrai o conteúdo dentro das chaves
            json = mapeamentoDTO.substring(startIndex, endIndex + 1);
        }
        JsonToObject jsonToObject = new JsonToObject();
        var mapeamento = jsonToObject.convert(json);

        return "";
    }

}
