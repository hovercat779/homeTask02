package entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by hovercat on 06.06.16.
 */
@Entity
@Table(name = "PRODUCTS", schema = "testDB", catalog = "")
@IdClass(ProductsEntityPK.class)
public class ProductsEntity {
    private String mfrId;
    private String productId;
    private String description;
    private BigDecimal price;
    private int qtyOnHand;
    private List<OrdersEntity> p;

    public void setQtyOnHand(Integer qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    @Id
    @Column(name = "MFR_ID", nullable = false, length = 3)
    public String getMfrId() {
        return mfrId;
    }

    public void setMfrId(String mfrId) {
        this.mfrId = mfrId;
    }

    @Id
    @Column(name = "PRODUCT_ID", nullable = false, length = 5)
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
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
        if (mfrId != null ? !mfrId.equals(that.mfrId) : that.mfrId != null) return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mfrId != null ? mfrId.hashCode() : 0;
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
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
