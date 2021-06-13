package espminvest.poo.cambio.repository;

import espminvest.poo.cambio.model.EstimateModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface EstimateRepository extends CrudRepository<EstimateModel, Integer> {

    @Override
    Iterable<EstimateModel> findAll();

    @Override
    Optional<EstimateModel> findById(Integer id);

    @Query("SELECT e FROM EstimateModel e WHERE e.currencyId = :currencyId AND e.date <= :date ORDER BY e.date DESC")
    List<EstimateModel> listByCurrencyDate(@Param("currencyId") Integer currencyId, @Param("date") Date date);

    @Query("SELECT e FROM EstimateModel e " +
            "WHERE " +
            "(e.currencyId is null or e.currencyId = :currencyId) AND " +
            "(e.date is null or e.date >= :initDate) AND " +
            "(e.date is null or e.date <= :endDate)"
    )
    List<EstimateModel> listBy(
            @Param("currencyId") Integer currencyId,
            @Param("initDate") Date initDate,
            @Param("endDate") Date endDate
    );

}
