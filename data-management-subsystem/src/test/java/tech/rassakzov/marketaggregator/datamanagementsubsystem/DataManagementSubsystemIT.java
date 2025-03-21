package tech.rassakzov.marketaggregator.datamanagementsubsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;

import tech.rasskazov.marketaggregator.common.generated.model.ResultResponse;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * Run integration tests against the server and the deployed application.
 */
@RunAsClient
@ExtendWith(ArquillianExtension.class)
public class DataManagementSubsystemIT {

    @Test
    public void testSuccessGetProduct() {
        try (Client client = ClientBuilder.newClient()) {
            Response response = client
                    .target(URI.create("http://localhost:8080/api/product"))
                    .queryParam("productId", "2abc2908-3225-4d61-a1d3-48d5aef185e3")
                    .request(MediaType.APPLICATION_JSON_TYPE)
                    .get();

            assertEquals(200, response.getStatus());
        }
    }

    @Test
    public void testBadGetProduct() {
        try (Client client = ClientBuilder.newClient()) {
            Response response = client
                    .target(URI.create("http://localhost:8080/api/product"))
                    .request(MediaType.APPLICATION_JSON_TYPE)
                    .get();

            assertEquals(400, response.getStatus());
        }
    }

    @Test
    public void testFailedGetProduct() {
        try (Client client = ClientBuilder.newClient()) {
            Response response = client
                    .target(URI.create("http://localhost:8080/api/product"))
                    .queryParam("productId", "3225-4d61-a1d3-48d5aef185e3")
                    .request(MediaType.APPLICATION_JSON_TYPE)
                    .get();

            assertEquals(500, response.getStatus());
        }
    }

    @Test
    public void testSuccessSearch() {
        try (Client client = ClientBuilder.newClient()) {
            Response response = client
                    .target(URI.create("http://localhost:8080/api/search"))
                    .queryParam("text", "Поисковой запрос")
                    .request(MediaType.APPLICATION_JSON_TYPE)
                    .get();

            assertEquals(200, response.getStatus());
        }
    }

    @Test
    public void testSuccessSearchWithFilter() {
        try (Client client = ClientBuilder.newClient()) {
            Response response = client
                    .target(URI.create("http://localhost:8080/api/search"))
                    .queryParam("text", "Поисковой запрос")
                    .queryParam("filters", "filter1,filter2")
                    .request(MediaType.APPLICATION_JSON_TYPE)
                    .get();

            assertEquals(200, response.getStatus());
        }
    }

    @Test
    public void testSuccessSearchWithSort() {
        try (Client client = ClientBuilder.newClient()) {
            Response response = client
                    .target(URI.create("http://localhost:8080/api/search"))
                    .queryParam("text", "Поисковой запрос")
                    .queryParam("sorts", "sort1,sort2")
                    .request(MediaType.APPLICATION_JSON_TYPE)
                    .get();

            assertEquals(200, response.getStatus());
        }
    }
}
