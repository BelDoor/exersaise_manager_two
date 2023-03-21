package com.exercise.domain;

import java.util.Objects;

public class UserParametrs {

    private String name;
    private String surname;
    private Float weight;
    private Float fatPercent;
    private Float maxBench;
    private Float maxSquat;
    private Float maxTraction;

    public UserParametrs() {
    }

    public UserParametrs(String name, String surname, Float weight,
                         Float fatPercent, Float maxBench, Float maxSquat, Float maxTraction) {

        this.name = name;
        this.surname = surname;
        this.weight = weight;
        this.fatPercent = fatPercent;
        this.maxBench = maxBench;
        this.maxSquat = maxSquat;
        this.maxTraction = maxTraction;
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

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getFatPercent() {
        return fatPercent;
    }

    public void setFatPercent(Float fatPercent) {
        this.fatPercent = fatPercent;
    }

    public Float getMaxBench() {
        return maxBench;
    }

    public void setMaxBench(Float maxBench) {
        this.maxBench = maxBench;
    }

    public Float getMaxSquat() {
        return maxSquat;
    }

    public void setMaxSquat(Float maxSquat) {
        this.maxSquat = maxSquat;
    }

    public Float getMaxTraction() {
        return maxTraction;
    }

    public void setMaxTraction(Float maxTraction) {
        this.maxTraction = maxTraction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserParametrs userParametrs = (UserParametrs) o;

        if (!Objects.equals(name, userParametrs.name)) return false;
        if (!Objects.equals(surname, userParametrs.surname)) return false;
        if (!Objects.equals(weight, userParametrs.weight)) return false;
        if (!Objects.equals(fatPercent, userParametrs.fatPercent)) return false;
        if (!Objects.equals(maxBench, userParametrs.maxBench)) return false;
        if (!Objects.equals(maxSquat, userParametrs.maxSquat)) return false;
        return (!Objects.equals(maxTraction, userParametrs.maxTraction));
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (fatPercent != null ? fatPercent.hashCode() : 0);
        result = 31 * result + (maxBench != null ? maxBench.hashCode() : 0);
        result = 31 * result + (maxSquat != null ? maxSquat.hashCode() : 0);
        result = 31 * result + (maxTraction != null ? maxTraction.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserParametr -> {" +
                "fullname = '" + name + " " +
                surname + '\'' +
                ", weight = " + weight +
                ", fat percent = " + fatPercent +
                ", max bench = " + maxBench +
                ", max squat = " + maxSquat +
                ", max traction = " + maxTraction +
                '}' + "\n";
    }
}
