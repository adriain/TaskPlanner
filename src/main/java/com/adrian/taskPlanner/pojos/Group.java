package com.adrian.taskPlanner.pojos;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String description;
    private LocalDate creationDate;
    @OneToMany
    @JoinColumn(name = "group_id")
    private List<UserAccess> userAccess;

    private Group() {
    }

    public Group(String name, String description, LocalDate creationDate) {
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }
}
