package SWIapp.Client.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ServerApiConfiguration {
    @Value("${restserver.address}")
    public String serverAddress;
    @Bean
    public orderControllerApi orderControllerApi(apiClient apiClient) {
        return new orderControllerApi(apiClient);
    }

    @Bean
    public apiClient apiClient() {
        final apiClient apiClient = new apiClient();
        apiClient.setBasePath(serverAddress);
        return apiClient;
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
