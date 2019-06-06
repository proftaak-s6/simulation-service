
package models.google;

import java.util.ArrayList;
import java.util.List;

public class GoogleRoute {

    private List<Route> routes = new ArrayList<Route>();
    private String status;

    public GoogleRoute() {
    }

    public GoogleRoute(List<Route> routes, String status) {
        this.routes = routes;
        this.status = status;
    }

    public List<Route> getRoutes() {
        return this.routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "{" + " routes='" + getRoutes() + "'" + ", status='" + getStatus() + "'" + "}";
    }

}
