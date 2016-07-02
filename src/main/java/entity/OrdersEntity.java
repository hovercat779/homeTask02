package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

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
    private CustomersEntity ord;
    private ProductsEntity o;
    private SalesrepsEntity or;

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

//    @Basic
//    @Column(name = "REP", nullable = true, insertable = false, updatable = false)
//    public Integer getRep() {
//        return rep;
//    }

    public void setCust(Integer cust) {
        this.cust = cust;
    }

    public void setRep(Integer rep) {
        this.rep = rep;
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

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "PRODUCT", referencedColumnName = "PRODUCT_ID", nullable = false),
            @JoinColumn(name = "MFR", referencedColumnName = "MFR_ID", nullable = false)})
    public ProductsEntity getO() {
        return o;
    }

    public void setO(ProductsEntity o) {
        this.o = o;
    }

    @ManyToOne
    @JoinColumn(name = "REP", referencedColumnName = "EMPL_NUM")
    public SalesrepsEntity getOr() {
        return or;
    }

    public void setOr(SalesrepsEntity or) {
        this.or = or;
    }
}
