package espminvest.poo.cambio.service;

import espminvest.poo.cambio.common.datatype.CurrencyBean;
import espminvest.poo.cambio.model.CurrencyModel;
import espminvest.poo.cambio.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CurrencyService {

    @Autowired
    CurrencyRepository currencyRepository;

    public List<CurrencyBean> listAll(){
        return StreamSupport
                .stream(currencyRepository.findAll().spliterator(), false)
                .collect(Collectors.toList())
                .stream().map(CurrencyModel::toBean)
                .collect(Collectors.toList());
    }

    public CurrencyBean findBy(Integer id) {
        return currencyRepository
                .findById(id)
                .map(CurrencyModel::toBean)
                .orElse(null);
    }


}
