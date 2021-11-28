package com.example.awito.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Ad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    @NotBlank(message = "name cannot be empty")
    @Length(max = 80, message = "text too long")
    private String adName;

    @NotNull(message = "price cannot be empty")
    @Range(min = 1, max = 1_000_000, message = "incorrect range (1 - 1000000)")
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

    public String getAuthor() {
        return author.getUsername();
    }
    public Long getUserId(){
        return author.getId();
    }

    public void setAuthor(User user) {
        this.author = user;
    }

    public String getAdName() {
        return adName;
    }

    public void setAdName(String adName) {
        this.adName = adName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
