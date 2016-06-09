package entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by hovercat on 06.06.16.
 */
@Entity
@Table(name = "CUSTOMERS", schema = "testDB", catalog = "")
public class CustomersEntity {
    private int custNum;
    private String company;
    private BigDecimal creditLimit;
    private Integer custRep;
    private List<OrdersEntity> cus;

    public void setCustNum(Integer custNum) {
        this.custNum = custNum;
    }

    @Id
    @Column(name = "CUST_NUM", nullable = false)
    public int getCustNum() {
        return custNum;
    }

    public void setCustNum(int custNum) {
        this.custNum = custNum;
    }

    @Basic
    @Column(name = "COMPANY", nullable = false, length = 20)
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Basic
    @Column(name = "CREDIT_LIMIT", nullable = true, precision = 2)
    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomersEntity that = (CustomersEntity) o;

        if (custNum != that.custNum) return false;
        if (company != null ? !company.equals(that.company) : that.company != null) return false;
        if (creditLimit != null ? !creditLimit.equals(that.creditLimit) : that.creditLimit != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = custNum;
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (creditLimit != null ? creditLimit.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CustomersEntity{" +
                "custNum=" + custNum +
                ", company='" + company + '\'' +
                ", creditLimit=" + creditLimit +
                '}';
    }

    @Basic
    @Column(name = "CUST_REP", nullable = true)
    public Integer getCustRep() {
        return custRep;
    }

    public void setCustRep(Integer custRep) {
        this.custRep = custRep;
    }

    @OneToMany(mappedBy = "ord", fetch = FetchType.EAGER)
    public List<OrdersEntity> getCus() {
        return cus;
    }

    public void setCus(List<OrdersEntity> cus) {
        this.cus = cus;
    }
}
