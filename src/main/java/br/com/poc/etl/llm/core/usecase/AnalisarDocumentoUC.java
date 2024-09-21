package br.com.poc.etl.llm.core.usecase;

import br.com.poc.etl.llm.core.repository.AnaliseRepository;
import br.com.poc.etl.llm.core.repository.DocumentoRepository;
import br.com.poc.etl.llm.core.repository.MapeamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnalisarDocumentoUC {

    private final DocumentoRepository documentoRepository;
    private final AnaliseRepository analiseRepository;
    private final MapeamentoRepository mapeamentoRepository;

    public void executar(){
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("excel_formatado.xlsx");
        String documentoFormatado = documentoRepository.extrair(inputStream);
        String mapeamento = analiseRepository.processarDados(documentoFormatado);
        mapeamentoRepository.popularEntidades(mapeamento);
    }
}
