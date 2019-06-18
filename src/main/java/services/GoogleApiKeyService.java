package services;

import java.util.Optional;
import java.util.stream.Stream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.enterprise.context.ApplicationScoped;

import com.kumuluz.ee.configuration.utils.ConfigurationUtil;

@ApplicationScoped
public class GoogleApiKeyService {

    private String secretLocation = Optional.of(System.getenv("GOOGLE_SECRET_LOCATION"))
            .orElseThrow(() -> new RuntimeException("Could not find 'GOOGLE_SECRET_LOCATION'"));
    private boolean loadFromFile = Boolean.parseBoolean(Optional.of(System.getenv("LOAD_FROM_FILE")).orElse("false"));

    public String getKey() {
        try {
            if (!loadFromFile) {
                return getFromConfig();
            } else {
                return getFromFile();
            }
        } catch (Exception e) {
            throw new RuntimeException("Werkt niet.\n" + e.getMessage());
        }
    }

    private String getFromFile() throws IOException {
        return new String(Files.readAllBytes(Paths.get(secretLocation)));
    }

    private String getFromConfig() {
        return ConfigurationUtil.getInstance().get("config.google.directionsApi.key")
                .orElseThrow(() -> new RuntimeException("Could not find 'config.google.directionsApi.key'"));
    }
}