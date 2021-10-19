package com.example.awito.entity;

import javax.persistence.*;

@Entity
public class Ad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    private String adName;

    private Integer price;

    public Ad() {}

    public Ad(User user, String adName, Integer price) {
        this.author = user;
        this.adName = adName;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return author.getUsername();
    }

    public void setUsername(User user) {
        this.author = user;
    }

    public String getNameAd() {
        return adName;
    }

    public void setNameAd(String nameAd) {
        this.adName = nameAd;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
