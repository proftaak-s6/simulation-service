package models.geocode;

import java.util.List;

public class Result {

    private List<AddressComponent> addressComponents;

    public Result() {
    }

    public Result(List<AddressComponent> addressComponents) {
        this.addressComponents = addressComponents;
    }

    public List<AddressComponent> getAddressComponents() {
        return this.addressComponents;
    }

    public void setAddressComponents(List<AddressComponent> addressComponents) {
        this.addressComponents = addressComponents;
    }

    @Override
    public String toString() {
        return "{" + " addressComponents='" + getAddressComponents() + "'" + "}";
    }

}