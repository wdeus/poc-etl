package br.com.poc.etl.llm.core.usecase;

import br.com.poc.etl.llm.core.dto.MapeamentoDTO;
import br.com.poc.etl.llm.core.entity.Entrevista;
import br.com.poc.etl.llm.core.mapper.EntrevistaMapper;
import br.com.poc.etl.llm.core.repository.AnaliseRepository;
import br.com.poc.etl.llm.core.repository.DocumentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnalisarDocumentoUC {

    private final DocumentoRepository documentoRepository;
    private final AnaliseRepository analiseRepository;

    public void executar(){
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("excel_formatado.xlsx");
        String documentoFormatado = documentoRepository.extrair(inputStream);
        MapeamentoDTO mapeamento = analiseRepository.processarDados(documentoFormatado);

        //convertendo o dto para as entidades correspondentes
        List<Entrevista> entrevista = EntrevistaMapper.INSTANCE.mapDtoToEntrevistas(mapeamento.getDtEntrevista());
    }
}
