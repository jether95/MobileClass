package com.jet.firstparcial;

public class Product {
    String name;
    Integer code;
    Double value;
    Boolean iva;
    String description;
    String category;

    public Product(String name, Integer code, Double value, Boolean iva, String description, String category) {
        this.name = name;
        this.code = code;
        this.value = value;
        this.iva = iva;
        this.description = description;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Boolean getIva() {
        return iva;
    }

    public void setIva(Boolean iva) {
        this.iva = iva;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "nombre='" + name + '\'' +
                ", codigo=" + code +
                ", valor=" + value +
                ", iva=" + iva +
                ", descripcion='" + description + '\'' +
                ", categoria='" + category + '\'';
    }
}
