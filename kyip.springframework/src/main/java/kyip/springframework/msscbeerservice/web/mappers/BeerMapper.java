package kyip.springframework.msscbeerservice.web.mappers;

import kyip.springframework.msscbeerservice.domain.Beer;
import kyip.springframework.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto BeerToBeerDto(Beer beer);

    Beer BeerDtoToBeer(BeerDto dto);
}
