package br.com.poc.etl.llm.core.repository;

import java.io.InputStream;

public interface DocumentoRepository {

    String extrair(InputStream inputStream);
}
