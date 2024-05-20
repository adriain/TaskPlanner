package com.adrian.taskPlanner.pojos;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "user_access")
public class UserAccess {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
    private LocalDate joinDate;
    @Column(columnDefinition = "boolean default false")
    private Boolean isAdmin;
    @Column(columnDefinition = "boolean default false")
    private Boolean canModifyTasks;

    public UserAccess() { }

    public UserAccess(User user, Group group, LocalDate joinDate, Boolean isAdmin, Boolean canModifyTasks) {
        this.user = user;
        this.group = group;
        this.joinDate = joinDate;
        this.isAdmin = isAdmin;
        this.canModifyTasks = canModifyTasks;
    }

    public User getUser() {
        return user;
    }

    public Group getGroup() {
        return group;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public Boolean getCanModifyTasks() {
        return canModifyTasks;
    }
}
