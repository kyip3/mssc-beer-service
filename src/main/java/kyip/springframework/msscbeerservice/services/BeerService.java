package kyip.springframework.msscbeerservice.services;

import kyip.springframework.msscbeerservice.web.model.BeerDto;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface BeerService {
    BeerDto updateBeerById(UUID beerId, BeerDto beerDto);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto getById(UUID beerId);
}
