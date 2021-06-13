package espminvest.poo.cambio.model;

import espminvest.poo.cambio.common.datatype.CurrencyBean;
import espminvest.poo.cambio.common.datatype.EstimateBean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "estimate")
public class EstimateModel {

    @Id
    @Column(name = "estimate_id")
    private int id;
    @Column(name = "currency_id")
    private int currencyId;
    @Column(name = "estimate_value")
    private Double value;
    @Column(name = "estimate_date")
    private Date date;

    public EstimateModel(){}

    public EstimateModel(EstimateBean e){
        this.id = e.getId();
        this.currencyId = e.getCurrency().getId();
        this.value = e.getValue();
        this.date = e.getDate();
    }

    public EstimateBean toBean(){
        CurrencyBean c = new CurrencyBean();
        c.setId(currencyId);

        EstimateBean e = new EstimateBean();

        e.setId(id);
        e.setCurrency(c);
        e.setDate(date);
        e.setValue(value);

        return e;
    }

}
