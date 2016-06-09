package entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by hovercat on 06.06.16.
 */
@Entity
@Table(name = "OFFICES", schema = "testDB", catalog = "")
public class OfficesEntity {
    private int office;
    private String city;
    private String region;
    private BigDecimal target;
    private BigDecimal sales;
    private Integer mgr;
    private List<SalesrepsEntity> of;

    public void setOffice(Integer office) {
        this.office = office;
    }

    @Id
    @Column(name = "OFFICE", nullable = false)
    public int getOffice() {
        return office;
    }

    public void setOffice(int office) {
        this.office = office;
    }

    @Basic
    @Column(name = "CITY", nullable = false, length = 15)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "REGION", nullable = false, length = 10)
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Basic
    @Column(name = "TARGET", nullable = true, precision = 2)
    public BigDecimal getTarget() {
        return target;
    }

    public void setTarget(BigDecimal target) {
        this.target = target;
    }

    @Basic
    @Column(name = "SALES", nullable = false, precision = 2)
    public BigDecimal getSales() {
        return sales;
    }

    public void setSales(BigDecimal sales) {
        this.sales = sales;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OfficesEntity that = (OfficesEntity) o;

        if (office != that.office) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (region != null ? !region.equals(that.region) : that.region != null) return false;
        if (target != null ? !target.equals(that.target) : that.target != null) return false;
        if (sales != null ? !sales.equals(that.sales) : that.sales != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = office;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (target != null ? target.hashCode() : 0);
        result = 31 * result + (sales != null ? sales.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OfficesEntity{" +
                "office=" + office +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", target=" + target +
                ", sales=" + sales +
                '}';
    }

    @Basic
    @Column(name = "MGR", nullable = true)
    public Integer getMgr() {
        return mgr;
    }

    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }

    @OneToMany(mappedBy = "sl", fetch = FetchType.EAGER)
    public List<SalesrepsEntity>  getOf() {
        return of;
    }

    public void setOf(List<SalesrepsEntity>  of) {
        this.of = of;
    }
}
