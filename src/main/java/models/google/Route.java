
package models.google;

import java.util.ArrayList;
import java.util.List;

public class Route {

    private List<Leg> legs = new ArrayList<Leg>();

    public Route() {
    }

    public Route(List<Leg> legs) {
        this.legs = legs;
    }

    public List<Leg> getLegs() {
        return this.legs;
    }

    public void setLegs(List<Leg> legs) {
        this.legs = legs;
    }

    @Override
    public String toString() {
        return "{" + " legs='" + getLegs() + "'" + "}";
    }

}
