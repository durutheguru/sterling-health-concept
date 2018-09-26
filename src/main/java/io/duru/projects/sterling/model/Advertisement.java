package io.duru.projects.sterling.model;

import io.duru.projects.sterling.util.jpa.LocalDateTimeConverter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * created by dduru on 26/09/2018
 */
@Entity
public class Advertisement extends BaseEntity {


    @NotNull
    @ManyToOne
    @JoinColumn(nullable = false, name = "partner_id")
    private Partner partner;

    @NotEmpty
    @Column(nullable = false, length = 100)
    @Size(max = 100, message = "Advertisement Title is too long")
    private String title;

    @Column(columnDefinition = "TEXT")
    private String text;

    @OneToOne(cascade = CascadeType.ALL)
    private Image image1;

    @OneToOne(cascade = CascadeType.ALL)
    private Image image2;

    @OneToOne(cascade = CascadeType.ALL)
    private Image image3;

    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime startTime;

    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime endTime;

    @Column(nullable = false)
    private Integer viewCount = 0;

    @Column(nullable = false)
    private Integer clickCount = 0;

    private boolean visible;


    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getClickCount() {
        return clickCount;
    }

    public void setClickCount(Integer clickCount) {
        this.clickCount = clickCount;
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

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }


}
