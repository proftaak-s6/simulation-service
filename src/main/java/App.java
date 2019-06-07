import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;

@ApplicationPath("")
@OpenAPIDefinition(info = @Info(title = "Rekeningrijden | Simulatie API", version = "1.0.0"))
public class App extends Application {
}