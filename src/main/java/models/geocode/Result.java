package models.geocode;

import java.util.List;

public class Result {

    public List<AddressComponent> address_components;

    public Result() {
    }

    public Result(List<AddressComponent> address_components) {
        this.address_components = address_components;
    }

    public List<AddressComponent> getAddress_components() {
        return this.address_components;
    }

    public void setAddress_components(List<AddressComponent> address_components) {
        this.address_components = address_components;
    }

    @Override
    public String toString() {
        return "{" + " address_components='" + getAddress_components() + "'" + "}";
    }

}