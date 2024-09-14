package br.com.poc.etl.llm.core.mapper;

import br.com.poc.etl.llm.core.dto.MapeamentoDTO;
import br.com.poc.etl.llm.core.entity.Entrevista;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EntrevistaMapper {
    EntrevistaMapper INSTANCE = Mappers.getMapper(EntrevistaMapper.class);

    @IterableMapping(qualifiedByName = "mapStringToEntrevista")
    List<Entrevista> mapDtoToEntrevistas(List<String> dataEntrevista);

    @Named("mapStringToEntrevista")
    default Entrevista mapStringToEntrevista(String data) {
        Entrevista entrevista = new Entrevista();
        entrevista.setDataEntrevista(data);
        return entrevista;
    }
}
