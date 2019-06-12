
package models.google;

import java.util.ArrayList;
import java.util.List;

public class AddressComponent {

    private String longName;
    private String shortName;
    private List<String> types = new ArrayList<>();

    public AddressComponent() {
    }

    public AddressComponent(String longName, String shortName, List<String> types) {
        this.longName = longName;
        this.shortName = shortName;
        this.types = types;
    }

    public String getLongName() {
        return this.longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getShortName() {
        return this.shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public List<String> getTypes() {
        return this.types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }
}
