
package models.google;

import java.util.ArrayList;
import java.util.List;

public class Result {

    private List<AddressComponent> addressComponents = new ArrayList<>();

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

}
