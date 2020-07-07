package ca.jrvs.apps.trading;

import ca.jrvs.apps.generated.trading.ApiClient;
import ca.jrvs.apps.generated.trading.auth.OAuth;
import org.springframework.context.annotation.Bean;

public class ApiClientConfiguration {
    @Bean
    public ApiClient apiClient() {
        ApiClient apiClient = new ApiClient();

        OAuth petStoreAuth = (OAuth) apiClient.getAuthentication("petstore_auth");
        petStoreAuth.setAccessToken("special-key");

        return apiClient;
    }
}
