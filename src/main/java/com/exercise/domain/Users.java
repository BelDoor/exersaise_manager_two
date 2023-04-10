package com.exercise.domain;

import java.sql.Timestamp;
import java.util.Objects;

public class Users {

    private Long id;
    private String name;
    private String surname;
    private Timestamp dateBirth;
    private String sex;
    private Integer height;
    private Long roleId;

    public Users() {
    }

    public Users(Long id, String name, String surname, Timestamp dateBirth, String sex, Integer height, Long roleId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dateBirth = dateBirth;
        this.sex = sex;
        this.height = height;
        this.roleId = roleId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Timestamp getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Timestamp dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if(!Objects.equals(id,users.id)) return false;
        if(!Objects.equals(name,users.name)) return false;
        if(!Objects.equals(surname,users.surname)) return false;
        if(!Objects.equals(dateBirth,users.dateBirth)) return false;
        if(!Objects.equals(sex,users.sex)) return false;
        if(!Objects.equals(height, users.height)) return false;
        return (!Objects.equals(roleId,users.roleId));
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (dateBirth != null ? dateBirth.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (height != null ? height.hashCode() : 0);
        result = 31 * result + (roleId != null ? roleId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Users -> {" +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", surname = '" + surname + '\'' +
                ", dateBirth = " + dateBirth +
                ", sex = '" + sex + '\'' +
                ", height = " + height +
                ", roleId = " + roleId +
                '}' + "\n";
    }
}
