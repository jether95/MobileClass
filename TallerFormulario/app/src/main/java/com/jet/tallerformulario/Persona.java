package com.jet.tallerformulario;

import android.widget.EditText;

public class Persona {
    protected EditText name;
    protected EditText surNMame;
    protected EditText email;
    protected EditText age;
    protected EditText salary;
    protected EditText position;

    public Persona(EditText name, EditText surNMame, EditText email, EditText age, EditText salary, EditText position) {
        this.name = name;
        this.surNMame = surNMame;
        this.email = email;
        this.age = age;
        this.salary = salary;
        this.position = position;
    }


    public EditText getName() {
        return name;
    }

    public void setName(EditText name) {
        this.name = name;
    }

    public EditText getSurNMame() {
        return surNMame;
    }

    public void setSurNMame(EditText surNMame) {
        this.surNMame = surNMame;
    }

    public EditText getEmail() {
        return email;
    }

    public void setEmail(EditText email) {
        this.email = email;
    }

    public EditText getAge() {
        return age;
    }

    public void setAge(EditText age) {
        this.age = age;
    }

    public EditText getSalary() {
        return salary;
    }

    public void setSalary(EditText salary) {
        this.salary = salary;
    }

    public EditText getPosition() {
        return position;
    }

    public void setPosition(EditText position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "name=" + name +
                '}';
    }
}
