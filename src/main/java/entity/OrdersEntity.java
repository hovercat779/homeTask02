package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

/**
 * Created by hovercat on 06.06.16.
 */
@Entity
@Table(name = "ORDERS", schema = "testDB", catalog = "")
public class OrdersEntity implements Serializable {
    private int orderNum;
    private Date orderDate;
    private int qty;
    private BigDecimal amount;
    private Integer cust;
    private Integer rep;
    private String mfr;
    private String product;
    private CustomersEntity ord;

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    @Id
    @Column(name = "ORDER_NUM", nullable = false)
    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    @Basic
    @Column(name = "ORDER_DATE", nullable = false)
    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Basic
    @Column(name = "QTY", nullable = false)
    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Basic
    @Column(name = "AMOUNT", nullable = false, precision = 2)
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrdersEntity that = (OrdersEntity) o;

        if (orderNum != that.orderNum) return false;
        if (qty != that.qty) return false;
        if (orderDate != null ? !orderDate.equals(that.orderDate) : that.orderDate != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderNum;
        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        result = 31 * result + qty;
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "CUST", nullable = false)
    public Integer getCust() {
        return cust;
    }

    public void setCust(Integer cust) {
        this.cust = cust;
    }

    @Basic
    @Column(name = "REP", nullable = true)
    public Integer getRep() {
        return rep;
    }

    public void setRep(Integer rep) {
        this.rep = rep;
    }

    @Basic
    @Column(name = "MFR", nullable = false, length = 3)
    public String getMfr() {
        return mfr;
    }

    public void setMfr(String mfr) {
        this.mfr = mfr;
    }

    @Basic
    @Column(name = "PRODUCT", nullable = false, length = 5)
    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "OrdersEntity{" +
                "orderNum=" + orderNum +
                ", orderDate=" + orderDate +
                ", qty=" + qty +
                ", amount=" + amount +
                ", cust=" + cust +
                ", rep=" + rep +
                ", mfr='" + mfr + '\'' +
                ", product='" + product + '\'' +
                '}';
    }

    @ManyToOne
    @JoinColumn(name = "CUST", referencedColumnName = "CUST_NUM", nullable = false, insertable = false, updatable = false)
    public CustomersEntity getOrd() {
        return ord;
    }

    public void setOrd(CustomersEntity ord) {
        this.ord = ord;
    }

}
