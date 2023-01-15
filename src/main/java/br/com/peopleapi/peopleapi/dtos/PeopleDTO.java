package br.com.peopleapi.peopleapi.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;

public class PeopleDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank(message = "field cannot be empty")
    private String firstName;

    @NotBlank(message = "field cannot be empty")
    private String lastName;

    @CPF
    @NotBlank(message = "field cannot be empty")
    private String cpf;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    public PeopleDTO() {
    }

    public PeopleDTO(Long id, @NotBlank(message = "field cannot be empty") String firstName,
            @NotBlank(message = "field cannot be empty") String lastName,
            @CPF @NotBlank(message = "field cannot be empty") String cpf, LocalDate birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cpf = cpf;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
