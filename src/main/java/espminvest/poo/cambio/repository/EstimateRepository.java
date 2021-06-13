package espminvest.poo.cambio.repository;

import espminvest.poo.cambio.model.EstimateModel;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EstimateRepository extends CrudRepository<EstimateModel, Integer> {

    @Override
    Iterable<EstimateModel> findAll();

    @Override
    Optional<EstimateModel> findById(Integer id);


}
