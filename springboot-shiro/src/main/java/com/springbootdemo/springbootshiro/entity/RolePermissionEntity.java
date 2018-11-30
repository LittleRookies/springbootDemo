package com.springbootdemo.springbootshiro.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Author: Little  Rookies
 * @Date: 2018-11-29 15:42
 */
@Entity(name = "role_permission")
public class RolePermissionEntity {
    private long id;
    private long roleId;
    private long permissionId;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "roleId")
    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "permissionId")
    public long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(long permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RolePermissionEntity that = (RolePermissionEntity) o;
        return id == that.id &&
                roleId == that.roleId &&
                permissionId == that.permissionId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleId, permissionId);
    }
}
