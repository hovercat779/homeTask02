package entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by hovercat on 06.06.16.
 */
@Entity
@Table(name = "SALESREPS", schema = "testDB", catalog = "")
public class SalesrepsEntity {
    private Integer emplNum;
    private String name;
    private Integer age;
    private String title;
    private Date hireDate;
    private BigDecimal quota;
    private BigDecimal sales;
    private Integer repOffice;
    private Integer manager;
    private OfficesEntity sl;

    @Id
    @Column(name = "EMPL_NUM", nullable = false)
    public Integer getEmplNum() {
        return emplNum;
    }

    public void setEmplNum(Integer emplNum) {
        this.emplNum = emplNum;
    }

    @Basic
    @Column(name = "NAME", nullable = false, length = 15)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "AGE", nullable = true)
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Basic
    @Column(name = "TITLE", nullable = true, length = 10)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "HIRE_DATE", nullable = false)
    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @Basic
    @Column(name = "QUOTA", nullable = true, precision = 2)
    public BigDecimal getQuota() {
        return quota;
    }

    public void setQuota(BigDecimal quota) {
        this.quota = quota;
    }

    @Basic
    @Column(name = "SALES", nullable = false, precision = 2)
    public BigDecimal getSales() {
        return sales;
    }

    public void setSales(BigDecimal sales) {
        this.sales = sales;
    }

    @Basic
    @Column(name = "REP_OFFICE", nullable = true, insertable = false, updatable = false)
    public Integer getRepOffice() {
        return repOffice;
    }

    public void setRepOffice(Integer repOffice) {
        this.repOffice = repOffice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SalesrepsEntity that = (SalesrepsEntity) o;

        if (emplNum != that.emplNum) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (age != null ? !age.equals(that.age) : that.age != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (hireDate != null ? !hireDate.equals(that.hireDate) : that.hireDate != null) return false;
        if (quota != null ? !quota.equals(that.quota) : that.quota != null) return false;
        if (sales != null ? !sales.equals(that.sales) : that.sales != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = emplNum;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (hireDate != null ? hireDate.hashCode() : 0);
        result = 31 * result + (quota != null ? quota.hashCode() : 0);
        result = 31 * result + (sales != null ? sales.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SalesrepsEntity{" +
                "emplNum=" + emplNum +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", title='" + title + '\'' +
                ", hireDate=" + hireDate +
                ", quota=" + quota +
                ", sales=" + sales +
                '}';
    }

    @Basic
    @Column(name = "MANAGER", nullable = true)
    public Integer getManager() {
        return manager;
    }

    public void setManager(Integer manager) {
        this.manager = manager;
    }

    @ManyToOne
    @JoinColumn(name = "REP_OFFICE", referencedColumnName = "OFFICE")
    public OfficesEntity getSl() {
        return sl;
    }

    public void setSl(OfficesEntity sl) {
        this.sl = sl;
    }
}
