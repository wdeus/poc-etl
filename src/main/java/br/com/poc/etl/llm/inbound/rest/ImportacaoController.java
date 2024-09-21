package br.com.poc.etl.llm.inbound.rest;

import br.com.poc.etl.llm.core.usecase.AnalisarDocumentoUC;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("importacao")
@RequiredArgsConstructor
public class ImportacaoController {

    private final AnalisarDocumentoUC analisarDocumentoUC;

    @GetMapping
    public void importar(){
        analisarDocumentoUC.executar();
    }
}
