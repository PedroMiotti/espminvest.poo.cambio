package espminvest.poo.cambio.service;

import espminvest.poo.cambio.repository.EstimateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstimateService {

    @Autowired
    CurrencyService currencyService;

    @Autowired
    EstimateRepository estimateRepository;




}
