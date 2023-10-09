package com.example.app;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "app")
public class Appointment {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long number; @GeneratedValue(strategy =  GenerationType.SEQUENCE)
    private LocalDate date;
    private LocalTime time;
    private String description;
    private Long index;


    public Appointment() {
    }

    public Appointment(Long number, LocalDate date, LocalTime time, String description, Long index) {
        this.number = number;
        this.date = date;
        this.time = time;
        this.description = description;
        this.index = index;
    }

    public Appointment(LocalDate date, LocalTime time, String description, Long index) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.index = index;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getIndex() {
        return index;
    }

    public void setIndex(Long index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "number=" + number +
                ", date=" + date +
                ", time=" + time +
                ", description='" + description + '\'' +
                ", index=" + index +
                '}';
    }
}
