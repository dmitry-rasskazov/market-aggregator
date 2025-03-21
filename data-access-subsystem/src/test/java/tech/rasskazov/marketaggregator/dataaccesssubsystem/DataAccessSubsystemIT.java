package tech.rasskazov.marketaggregator.dataaccesssubsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.util.UUID;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import tech.rasskazov.marketaggregator.dataaccesssubsystem.generated.model.Product;

/**
 * Run integration tests against the server and the deployed application.
 */
@RunAsClient
@ExtendWith(ArquillianExtension.class)
public class DataAccessSubsystemIT
{
    @Test
    public void testSearchProductSuccess()
    {
        try (Client client = ClientBuilder.newClient()) {
            Response response = client
                    .target(URI.create("http://localhost:8080/"))
                    .path("/api/product")
                    .queryParam("productId", UUID.randomUUID().toString())
                    .request(MediaType.APPLICATION_JSON_TYPE)
                    .get();

            assertEquals(500, response.getStatus());
        }
    }
}
