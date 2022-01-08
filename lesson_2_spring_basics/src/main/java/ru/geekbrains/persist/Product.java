package ru.geekbrains.persist;

public class Product {

    private Long id;

    private String name;

    private Float price;

    private Integer count;

    public Product() {
    }

    public Product(Long id, String name, Float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return  "\n id= " + id +
                "\n name= " + name +
                "\n price= " + price;
    }
}
