package com.springbootdemo.springbootshiro.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Author: Little  Rookies
 * @Date: 2018-11-29 15:41
 */
@Entity(name = "permission")
public class PermissionEntity {
    private int id;
    private String name;
    private String permission;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "permission")
    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PermissionEntity that = (PermissionEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(permission, that.permission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, permission);
    }
}
