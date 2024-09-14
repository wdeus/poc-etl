package br.com.poc.etl.llm.core.entity;

import lombok.Data;

@Data
public class Entrevista {

    private String dataEntrevista;
    private String entrevistador;
    private String resultado;
}
