package br.com.peopleapi.peopleapi.dtos;

import java.io.Serializable;

import br.com.peopleapi.peopleapi.entities.People;

public class AddressDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String address;
    private Integer number;
    private String district;
    private String city;
    private String state;
    private String zipCode;
    private Boolean main;
    private People people;

    public AddressDTO() {
    }

    public AddressDTO(Long id, String address, Integer number, String district, String city, String state,
            String zipCode, Boolean main, People people) {
        this.id = id;
        this.address = address;
        this.number = number;
        this.district = district;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.main = main;
        this.people = people;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Boolean getMain() {
        return main;
    }

    public void setMain(Boolean main) {
        this.main = main;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }
}
