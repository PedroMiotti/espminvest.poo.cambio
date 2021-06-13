package espminvest.poo.cambio.repository;

import espminvest.poo.cambio.model.CurrencyModel;
import espminvest.poo.cambio.model.EstimateModel;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CurrencyRepository extends CrudRepository<CurrencyModel, Integer> {

    @Override
    Iterable<CurrencyModel> findAll();

    @Override
    Optional<CurrencyModel> findById(Integer id);


}
