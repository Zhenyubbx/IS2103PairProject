/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import util.enumeration.CategoryType;

/**
 *
 * @author khoojingzhi
 */
@Entity
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    @Column(nullable = false)
    private CategoryType categoryType;
    
    @OneToMany(mappedBy = "category")
    private List<Car> cars;
    @OneToMany(mappedBy = "category")
    private List<Model> models;
    @OneToMany(mappedBy = "category")
    private List<RentalRateRecord> rentalRateRecords;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Category() {
        this.cars = new ArrayList<Car>();
        this.models = new ArrayList<Model>();
        this.rentalRateRecords = new ArrayList<RentalRateRecord>();
    }

    public Category(CategoryType categoryType) {
        this.categoryType = categoryType;
        this.cars = new ArrayList<Car>();
        this.models = new ArrayList<Model>();
        this.rentalRateRecords = new ArrayList<RentalRateRecord>();
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoryId != null ? categoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the categoryId fields are not set
        if (!(object instanceof Category)) {
            return false;
        }
        Category other = (Category) object;
        if ((this.categoryId == null && other.categoryId != null) || (this.categoryId != null && !this.categoryId.equals(other.categoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Category[ id=" + categoryId + " ]";
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Model> getModels() {
        return models;
    }

    public void setModels(List<Model> models) {
        this.models = models;
    }

    public List<RentalRateRecord> getRentalRateRecords() {
        return rentalRateRecords;
    }

    public void setRentalRateRecords(List<RentalRateRecord> rentalRateRecords) {
        this.rentalRateRecords = rentalRateRecords;
    }
    
}
