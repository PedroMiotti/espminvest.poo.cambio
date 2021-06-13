package espminvest.poo.cambio.model;

import espminvest.poo.cambio.common.datatype.CurrencyBean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "currency")
public class CurrencyModel {

    @Id
    @Column(name = "currency_id")
    private int id;
    @Column(name = "currency_name")
    private String name;
    @Column(name = "currency_sign")
    private String sign;

    public CurrencyModel(){}

    public CurrencyModel(CurrencyBean c){
        this.id = c.getId();
        this.name = c.getName();
        this.sign = c.getSign();
    }

    public CurrencyBean toBean(){
        CurrencyBean c = new CurrencyBean();

        c.setId(id);
        c.setName(name);
        c.setSign(sign);

        return c;
    }



}
