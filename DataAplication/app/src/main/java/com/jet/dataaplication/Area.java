package com.jet.dataaplication;

public class Area {
    int id;
    String name;
    int poblacion;
    double latitud;
    double longitud;

    public Area() {
    }

    public Area(int id, String name, int poblacion, double latitud, double longitud) {
        this.id = id;
        this.name = name;
        this.poblacion = poblacion;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", poblacion=" + poblacion +
                ", latitud=" + latitud +
                ", longitud=" + longitud
                ;
    }
}
