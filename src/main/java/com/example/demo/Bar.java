package com.example.demo;

import javax.persistence.*;

/**
 * *
 * <p>Created by irina on 5/31/2022.</p>
 * <p>Project: spring-data-schema-as-placeholder</p>
 * *
 */
@Entity
@Table(name = "bar", schema = "${dataSource.appAttrsSchema}")
public class Bar {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "version")
    private Integer version;
    @Basic
    @Column(name = "comment")
    private String comment;

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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bar bar = (Bar) o;

        if (id != bar.id) return false;
        if (name != null ? !name.equals(bar.name) : bar.name != null) return false;
        if (version != null ? !version.equals(bar.version) : bar.version != null) return false;
        if (comment != null ? !comment.equals(bar.comment) : bar.comment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Bar{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", version=" + version +
                ", comment='" + comment + '\'' +
                '}';
    }
}
