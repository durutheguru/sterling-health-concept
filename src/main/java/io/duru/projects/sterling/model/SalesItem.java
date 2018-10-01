package io.duru.projects.sterling.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * created by dduru on 26/09/2018
 */
@Entity
public class SalesItem extends BaseEntity {

    @NotEmpty
    @Column(nullable = false, length = 200)
    @Size(max = 200, message = "Sales Item description is too long")
    private String description;

    @Enumerated(EnumType.STRING)
    private SalesItemType itemType;

    @NotNull
    @ManyToOne
    @JoinColumn(nullable = false, name = "partner_id")
    private Partner partner;

    @NotNull
    @Column(nullable = false)
    private Double pricePerUnit;

    @OneToOne(cascade = CascadeType.ALL)
    private Image image1;

    @OneToOne(cascade = CascadeType.ALL)
    private Image image2;

    @OneToOne(cascade = CascadeType.ALL)
    private Image image3;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SalesItemType getItemType() {
        return itemType;
    }

    public SalesItem setItemType(SalesItemType itemType) {
        this.itemType = itemType;
        return this;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public Double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(Double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public Image getImage1() {
        return image1;
    }

    public void setImage1(Image image1) {
        this.image1 = image1;
    }

    public Image getImage2() {
        return image2;
    }

    public void setImage2(Image image2) {
        this.image2 = image2;
    }

    public Image getImage3() {
        return image3;
    }

    public void setImage3(Image image3) {
        this.image3 = image3;
    }


}