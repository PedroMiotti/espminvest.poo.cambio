package espminvest.poo.cambio.rest;

import espminvest.poo.cambio.common.controller.CambioController;
import espminvest.poo.cambio.common.datatype.CurrencyBean;
import espminvest.poo.cambio.common.datatype.EstimateBean;

import espminvest.poo.cambio.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EstimateResource implements CambioController {

    @Autowired
    CurrencyService currencyService;

    @Override
    public List<CurrencyBean> listCurrencies() {
        return currencyService.listAll();
    }

    @Override
    public CurrencyBean getCurrency(String currencyId) {
        Integer parsedCurrencyId = Integer.parseInt(currencyId);
        return currencyService.findBy(parsedCurrencyId);
    }

    @Override
    public EstimateBean getEstimate(String currencyId, String date) {
        return null;
    }

    @Override
    public List<EstimateBean> getEstimates(String currencyId, String dateInit, String dateEnd) {
        return null;
    }
}
