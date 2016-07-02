package entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by hovercat on 06.06.16.
 */
@Entity
@Table(name = "PRODUCTS", schema = "testDB", catalog = "")
public class ProductsEntity {
    private ProductsEntityPK keyl;
    private String description;
    private BigDecimal price;
    private int qtyOnHand;
    private List<OrdersEntity> p;

    public void setQtyOnHand(Integer qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    @EmbeddedId
    public ProductsEntityPK getKeyl() {
        return keyl;
    }

    public void setKeyl(ProductsEntityPK keyl) {
        this.keyl = keyl;
    }

    @Basic
    @Column(name = "DESCRIPTION", nullable = false, length = 20)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "PRICE", nullable = false, precision = 2)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "QTY_ON_HAND", nullable = false)
    public int getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductsEntity that = (ProductsEntity) o;

        if (qtyOnHand != that.qtyOnHand) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (description != null ? description.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + qtyOnHand;
        return result;
    }

    @OneToMany(mappedBy = "o")
    public List<OrdersEntity> getP() {
        return p;
    }

    public void setP(List<OrdersEntity> p) {
        this.p = p;
    }
}
