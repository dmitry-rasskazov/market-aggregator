package tech.rasskazov.marketaggregator.resourceadaptationssubsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.Response;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * Run integration tests against the server and the deployed application.
 */
@RunAsClient
@ExtendWith(ArquillianExtension.class)
public class ResourceAdaptationSubsystemIT
{
    @Test
    public void testProductList() {
        try (Client client = ClientBuilder.newClient()) {
            Response response = client
                    .target(URI.create("http://localhost:8080/api"))
                    .path("/product/list")
                    .request()
                    .get();

            assertEquals(200, response.getStatus());
        }
    }

    @Test
    public void testSingleProduct() {
        try (Client client = ClientBuilder.newClient()) {
            Response response = client
                    .target(URI.create("http://localhost:8080/api"))
                    .path("/product")
                    .queryParam("sourceId", "2abc2908-3225-4d61-a1d3-48d5aef185e3")
                    .request()
                    .get();

            assertEquals(200, response.getStatus());
        }
    }
}
