package br.com.poc.etl.llm.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entrevista {

    private String dataEntrevista;
    private String entrevistador;
    private String resultado;
}
