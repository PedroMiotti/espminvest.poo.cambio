package espminvest.poo.cambio.rest;

import espminvest.poo.cambio.common.controller.CambioController;
import espminvest.poo.cambio.common.datatype.CurrencyBean;
import espminvest.poo.cambio.common.datatype.EstimateBean;

import espminvest.poo.cambio.service.CurrencyService;
import espminvest.poo.cambio.service.EstimateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class EstimateResource implements CambioController {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

    @Autowired
    CurrencyService currencyService;

    @Autowired
    EstimateService estimateService;

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
        try {
            Integer parsedCurrencyId = Integer.parseInt(currencyId);
            CurrencyBean currency = currencyService.findBy(parsedCurrencyId);

            // Handle currency not found error

            return estimateService.findBy(currency.getId(), sdf.parse(date));

        } catch (ParseException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @Override
    public List<EstimateBean> getEstimates(String currencyId, String dateInit, String dateEnd) {
        try {
            Integer parsedCurrencyId = Integer.parseInt(currencyId);
            CurrencyBean currency = currencyService.findBy(parsedCurrencyId);

            if (currency == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, currencyId + " not found");
            }

            Date initDate = dateInit == null ? null : sdf.parse(dateInit);
            Date endDate = dateEnd == null ? null : sdf.parse(dateEnd);

            return estimateService.listBy(currency.getId(), initDate, endDate);
        } catch (ParseException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
