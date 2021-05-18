package com.rest.client.json;

public class Result {
    private String address;
    private Geometry geometry;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    @Override
    public String toString() {
        return "Result{" +
                "address='" + address + '\'' +
                ", geometry=" + geometry +
                '}';
    }
}
