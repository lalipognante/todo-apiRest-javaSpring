package com.todoapi.app.rest.Model;

import jakarta.persistence.*;

@Entity
@Table(schema = "TasksCrud")
public class Task {
    // definición de componentes de entidad
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // unico e autoincrementable
    private long id;
    @Column
    private String title;
    @Column
    private String description;

    // getters y setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
