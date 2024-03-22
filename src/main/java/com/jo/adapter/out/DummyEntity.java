package com.jo.adapter.out;

import org.hibernate.envers.Audited;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Audited
@Entity(name = "dummies")
public class DummyEntity {

    @Id
    @GeneratedValue
    private int id;

    private String info;
    
    public DummyEntity(String info) {
        this.info = info;
    }
}
