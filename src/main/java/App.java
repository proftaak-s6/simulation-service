import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;


@ApplicationPath("")
@OpenAPIDefinition(info = @Info(title = "Rekeningrijden | Simulatie API", version = "1.0.0"))
public class App extends Application {
}