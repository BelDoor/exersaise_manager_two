package com.exercise.domain;

import java.util.Objects;

public class Contacts {

    private Long id;
    private Long userId;
    private Long phoneNumber;
    private String email;
    private String city;
    private String country;
    private String street;
    private Integer houseNumber;
    private Integer flat;

    public Contacts() {
    }

    public Contacts(Long id, Long userId, Long phoneNumber, String email,
                    String city, String country, String street, Integer houseNumber, Integer flat) {
        this.id = id;
        this.userId = userId;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.city = city;
        this.country = country;
        this.street = street;
        this.houseNumber = houseNumber;
        this.flat = flat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public Integer getFlat() {
        return flat;
    }

    public void setFlat(Integer flat) {
        this.flat = flat;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contacts contacts = (Contacts) o;

        if (!Objects.equals(id, contacts.id)) return false;
        if (!Objects.equals(userId, contacts.userId)) return false;
        if (!Objects.equals(phoneNumber, contacts.phoneNumber)) return false;
        if (!Objects.equals(email, contacts.email)) return false;
        if (!Objects.equals(city, contacts.city)) return false;
        if (!Objects.equals(country, contacts.country)) return false;
        if (!Objects.equals(street, contacts.street)) return false;
        if (!Objects.equals(houseNumber, contacts.houseNumber)) return false;
        return (!Objects.equals(flat, contacts.flat));
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (houseNumber != null ? houseNumber.hashCode() : 0);
        result = 31 * result + (flat != null ? flat.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Contacts{" +
                "id = " + id +
                ", userId = " + userId +
                ", phoneNumber = " + phoneNumber +
                ", email = '" + email + '\'' +
                ", city = '" + city + '\'' +
                ", country = '" + country + '\'' +
                ", street = '" + street + '\'' +
                ", houseNumber = " + houseNumber +
                ", flat = " + flat +
                '}';
    }
}
