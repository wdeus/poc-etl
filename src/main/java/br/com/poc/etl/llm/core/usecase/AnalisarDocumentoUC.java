package br.com.poc.etl.llm.core.usecase;

import br.com.poc.etl.llm.core.entity.Vaga;
import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.DocumentParser;
import dev.langchain4j.data.document.parser.apache.poi.ApachePoiDocumentParser;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.converter.ListOutputConverter;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.convert.support.DefaultConversionService;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class AnalisarDocumentoUC {


    public static void main(String[] args) {
        AnalisarDocumentoUC analisarDocumentoUC = new AnalisarDocumentoUC();
        System.out.println(analisarDocumentoUC.extrai());
    }


    public String extrai(){
        DocumentParser parser = new ApachePoiDocumentParser();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("teste.xlsx");

        Document document = parser.parse(inputStream);

        var openAiApi = new OpenAiApi("https://api.groq.com/openai", "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");
        var openAiChatOptions = OpenAiChatOptions.builder()
                .withModel("llama3-8b-8192")
                .withMaxTokens(1500)
                .build();
        var chatModel = new OpenAiChatModel(openAiApi, openAiChatOptions);

        Vaga vagas = ChatClient.create(chatModel).prompt()
                .user(u -> u.text("Realize o mapeamento da entidade, de acordo com o seguinte texto: {document}.")
                        .param("document", document.text()))
                .call()
                .entity(Vaga.class);

        return "";
    }

}
