package models.geocode;

import java.util.List;

public class AddressComponent {
    public String long_name;
    public String short_name;
    public List<String> types;

    public AddressComponent() {
    }

    public AddressComponent(String long_name, String short_name, List<String> types) {
        this.long_name = long_name;
        this.short_name = short_name;
        this.types = types;
    }

    public String getLong_name() {
        return this.long_name;
    }

    public void setLong_name(String long_name) {
        this.long_name = long_name;
    }

    public String getShort_name() {
        return this.short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public List<String> getTypes() {
        return this.types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    @Override
    public String toString() {
        return "{" + " long_name='" + getLong_name() + "'" + ", short_name='" + getShort_name() + "'" + ", types='"
                + getTypes() + "'" + "}";
    }

}