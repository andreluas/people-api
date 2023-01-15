package br.com.peopleapi.peopleapi.dtos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import br.com.peopleapi.peopleapi.entities.Address;

public class PeopleAddressesDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Set<Address> addresses = new HashSet<>();

    public PeopleAddressesDTO() {
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }
}
