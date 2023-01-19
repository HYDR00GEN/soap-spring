package it.siav.SpringSOAPws;

import it.siav.SpringSOAPws.gs_producing_web_service.Country;
import it.siav.SpringSOAPws.gs_producing_web_service.Currency;
import jakarta.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/*
Component annotation is used to indicate that a class is a component in Spring framework.
It is used to mark a class as a candidate for component-scanning, which allows Spring to
automatically discover and register the class as a bean in the application context.
*/
@Component
public class CountryRepository {
    private static final Map<String, Country> countries = new HashMap<>();

    /*
    The "@PostConstruct" annotation is used to indicate a method that should be executed after the object is created
     and all dependencies have been injected.
     In the example, the "initData" method is decorated with the "@PostConstruct" annotation, meaning that it will be
     executed automatically by the Spring framework after the CountryRepository object is created. In this case, the
     method is used to populate the "countries" map with some sample data.
     */
    @PostConstruct
    public void initData() {
        Country spain = new Country();
        spain.setName("Spain");
        spain.setCapital("Madrid");
        spain.setCurrency(Currency.EUR);
        spain.setPopulation(46704314);

        countries.put(spain.getName(), spain);

        Country poland = new Country();
        poland.setName("Poland");
        poland.setCapital("Warsaw");
        poland.setCurrency(Currency.PLN);
        poland.setPopulation(38186860);

        countries.put(poland.getName(), poland);

        Country uk = new Country();
        uk.setName("United Kingdom");
        uk.setCapital("London");
        uk.setCurrency(Currency.GBP);
        uk.setPopulation(63705000);

        countries.put(uk.getName(), uk);
    }

    public Country findCountry(String name) {
        Assert.notNull(name, "The country's name must not be null");
        return countries.get(name);
    }
}
