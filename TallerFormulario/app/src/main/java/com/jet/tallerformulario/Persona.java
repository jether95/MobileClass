package com.jet.tallerformulario;

import android.widget.EditText;

public class Persona {
    String name;
    String surName;
    String email;
    Integer age;
    Integer salary;
    String position;

    public Persona(String name, String surName, String email, Integer age, Integer salary, String position) {
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.age = age;
        this.salary = salary;
        this.position = position;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", position='" + position + '\'' +
                '}';
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
