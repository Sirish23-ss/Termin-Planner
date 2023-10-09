package com.example.app;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="xyz")
public class Termin {


    @Id

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceSubCategoryId")
    @SequenceGenerator(name = "SequenceSubCategoryId", sequenceName = "SUB_CATEGORY_SEQ")
    private Long id;
    public LocalDate t_date;

    public LocalTime t_time;
    public String des;
    public Long index;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Termin(Long id,LocalDate t_date, LocalTime t_time, String des) {
        this.id = id;
        this.t_date = t_date;
        this.t_time = t_time;
        this.des = des;
    }

    public Termin(LocalDate t_date, LocalTime t_time, String des) {
        this.t_date = t_date;
        this.t_time = t_time;
        this.des = des;
    }

    public Termin() {
    }

    public LocalDate getT_date() {
        return t_date;
    }

    public LocalTime getT_time() {
        return t_time;
    }

    public String getDes() {
        return des;
    }

    public void setT_date(LocalDate t_date) {
        this.t_date = t_date;
    }

    public void setT_time(LocalTime t_time) {
        this.t_time = t_time;
    }

    public void setDes(String des) {
        this.des = des;
    }



    public Termin(Long id, LocalDate t_date, LocalTime t_time, String des, Long in) {
        this.id = id;
        this.t_date = t_date;
        this.t_time = t_time;
        this.des = des;
        this.index = in;
    }

    public Termin(LocalDate t_date, LocalTime t_time, String des, Long in) {
        this.t_date = t_date;
        this.t_time = t_time;
        this.des = des;
        this.index = in;
    }

    public Long getIn() {
        return index;
    }

    public void setIn(Long in) {
        this.index = in;
    }

    @Override
    public String toString() {
        return "Termin{" +
                "id:" + id +
                ", t_date:" + t_date +
                ", t_time:" + t_time +
                ", des:'" + des + '\'' +
                '}';
    }
}
