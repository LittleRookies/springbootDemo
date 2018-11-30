package com.springbootdemo.springbootshiro.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Author: Little  Rookies
 * @Date: 2018-11-29 15:41
 */
@Entity(name = "dept")
public class DeptEntity {
    private long deptno;
    private String dname;
    private String dbSource;

    @Id
    @Column(name = "deptno")
    public long getDeptno() {
        return deptno;
    }

    public void setDeptno(long deptno) {
        this.deptno = deptno;
    }

    @Basic
    @Column(name = "dname")
    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Basic
    @Column(name = "db_source")
    public String getDbSource() {
        return dbSource;
    }

    public void setDbSource(String dbSource) {
        this.dbSource = dbSource;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeptEntity that = (DeptEntity) o;
        return deptno == that.deptno &&
                Objects.equals(dname, that.dname) &&
                Objects.equals(dbSource, that.dbSource);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deptno, dname, dbSource);
    }
}
