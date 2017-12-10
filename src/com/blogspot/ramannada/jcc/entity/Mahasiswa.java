package com.blogspot.ramannada.jcc.entity;

public class Mahasiswa extends BaseEntity implements Entity{
    private String nim;
    private String name;


    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Mahasiswa{" +
                "id=" + id +
                ", nim='" + nim + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
