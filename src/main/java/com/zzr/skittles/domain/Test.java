package com.zzr.skittles.domain;

public class Test {
    private Integer id;

    private String name;

    private String address;

    public Test(Integer id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Test() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
}