package espminvest.poo.cambio.service;

import espminvest.poo.cambio.common.datatype.EstimateBean;
import espminvest.poo.cambio.model.EstimateModel;
import espminvest.poo.cambio.repository.EstimateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstimateService {

    @Autowired
    CurrencyService currencyService;

    @Autowired
    EstimateRepository estimateRepository;


    public EstimateBean findBy(Integer currencyId, Date date) {

        EstimateBean estimate = estimateRepository
                .listByCurrencyDate(currencyId, date).stream()
                .map(EstimateModel::toBean)
                .findFirst()
                .orElse(null);

        return fillCurrency(estimate);
    }

    public List<EstimateBean> listBy(Integer currencyId, Date initDate, Date endDate) {
        return estimateRepository
                .listBy(currencyId, initDate, endDate).stream()
                .map(EstimateModel::toBean)
                .map(this::fillCurrency)
                .collect(Collectors.toList());
    }

    private EstimateBean fillCurrency(EstimateBean c) {
        if (c != null) {
            c.setCurrency(currencyService.findBy(c.getCurrency().getId() ));
        }

        return c;
    }




}
