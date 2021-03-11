package com.davut.start.shoe;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
@Entity
@Table
public class Shoe {
    @Id
    @SequenceGenerator(
            name = "shoe_sequence",
            sequenceName = "shoe_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "shoe_sequence"

    )

    private Long Id;
    private String firmname;
    private String model;
    private String size;
    private LocalDate dob;
    @Transient
    private  Integer age;

    public Shoe() {
    }

    public Shoe(Long id, String firmname, String model, String size, LocalDate dob, Integer age) {
        Id = id;
        this.firmname = firmname;
        this.model = model;
        this.size = size;
        this.dob = dob;
        this.age = age;
    }

    public Shoe(String firmname, String model, String size, LocalDate dob, Integer age) {
        this.firmname = firmname;
        this.model = model;
        this.size = size;
        this.dob = dob;
        this.age = age;
    }




    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getFirmname() {
        return firmname;
    }

    public void setFirmname(String firmname) {
        this.firmname = firmname;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}