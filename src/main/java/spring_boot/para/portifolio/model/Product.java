package spring_boot.para.portifolio.model;

import jakarta.persistence.*;

@Entity(name = "product")
@Table(name = "product")
public class Product {

    /* o @ID junto com o  @GeneratedValue(strategy = GenerationType.AUTO) serve para criar um id por produto automatico */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Long price;



    public Product(Integer id, String name, Long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

}
