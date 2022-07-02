package kyip.springframework.msscbeerservice.bootstrap;

import kyip.springframework.msscbeerservice.domain.Beer;
import kyip.springframework.msscbeerservice.repositories.BeerRepository;
import kyip.springframework.msscbeerservice.web.model.BeerStyleEnum;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

//class going to run on startup
//commandlinerunner will run everytime the context startup

//@Component will bring this file into spring bean
@Component
public class BeerLoader implements CommandLineRunner {

    public static final String BEER_1_UPC = "0631234200036";
    public static final String BEER_2_UPC = "0631234300019";
    public static final String BEER_3_UPC = "0083783375213";

    private final BeerRepository beerRepository;


    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if(beerRepository.count() == 0){
            beerRepository.save(Beer.builder()
                    .beerName("Mango Bits")
                    .beerStyle(String.valueOf(BeerStyleEnum.IPA))
                    .minOnHand(12)
                    .quantityToBrew(200)
                    .price(new BigDecimal("12.95"))
                    .upc(BEER_1_UPC)
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle(String.valueOf(BeerStyleEnum.PALE_ALE))
                    .minOnHand(12)
                    .quantityToBrew(200)
                    .price(new BigDecimal("11.95"))
                    .upc(BEER_2_UPC)
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("No hammer on the bar")
                    .beerStyle(String.valueOf(BeerStyleEnum.PORTER))
                    .minOnHand(12)
                    .quantityToBrew(200)
                    .price(new BigDecimal("11.95"))
                    .upc(BEER_3_UPC)
                    .build());

            System.out.println("loaded beer: " + beerRepository.count());
        }
    }
}
