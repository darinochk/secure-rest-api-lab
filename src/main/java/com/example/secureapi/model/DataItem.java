package com.example.secureapi.model;
import jakarta.persistence.*;

@Entity
public class DataItem {
    @Id @GeneratedValue
    private Long id;
    private String value;

    public Long getId() { return id; }
    public String getValue() { return value; }
    public void setValue(String v) { this.value = v; }
}
