package it.siav.SpringSOAPws.Endpoint;

import it.siav.SpringSOAPws.CountryRepository;
import it.siav.SpringSOAPws.gs_producing_web_service.*;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CountryEndpoint {
    private static final String NAMESPACE_URI = "http://localhost:8080/ws";
    private CountryRepository countryRepository;

    private Currency currency;

    @Autowired
    public CountryEndpoint(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(countryRepository.getCountryByName(request.getName()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "insertCountryRequest")
    @ResponsePayload
    public InsertCountryResponse insertCountry(@RequestPayload InsertCountryRequest req) {
        InsertCountryResponse res = new InsertCountryResponse();
        req.setName(req.getName());
        req.setCapital(req.getCapital());
        req.setCurrency(req.getCurrency());
        req.setPopulation(req.getPopulation());
        if (!req.getName().isEmpty() && req.getCurrency() != null && req.getPopulation() != null && !req.getCapital().isEmpty()) {
            countryRepository.insertCountry(req);
            res.setResult("Country Added!");
            return res;
        } else {
            res.setResult("Must insert all parameters!");
            return res;
        }
    }
}
