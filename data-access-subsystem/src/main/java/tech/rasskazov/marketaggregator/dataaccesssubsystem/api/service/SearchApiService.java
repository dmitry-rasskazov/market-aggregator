package tech.rasskazov.marketaggregator.dataaccesssubsystem.api.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Specializes;
import jakarta.inject.Inject;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.text.StringEscapeUtils;
import tech.rasskazov.marketaggregator.dataaccesssubsystem.component.ResponseFactory;
import tech.rasskazov.marketaggregator.dataaccesssubsystem.generated.api.impl.SearchApiServiceImpl;
import tech.rasskazov.marketaggregator.dataaccesssubsystem.generated.model.ResultResponse;

@Slf4j
@ApplicationScoped
@Specializes
public class SearchApiService extends SearchApiServiceImpl
{
    private static final String DATA_MANAGEMENT_SEARCH_URL = "http://data-management-subsystem:8080/api/search";

    private final Client client;

    private final ResponseFactory responseFactory;

    @Inject
    public SearchApiService(ResponseFactory responseFactory)
    {
        this.client = ClientBuilder.newClient();
        this.responseFactory = responseFactory;
    }

    @Override
    public Response searchGet(String text, String filters, String sort, Integer limit, Integer offset, SecurityContext securityContext)
    {
        var targetSearch = this.client.target(DATA_MANAGEMENT_SEARCH_URL);

        try {
            var result = targetSearch
                    .queryParam("text", StringEscapeUtils.escapeJava(text))
                    .queryParam("filters", StringEscapeUtils.escapeJava(filters))
                    .queryParam("sort", StringEscapeUtils.escapeJava(sort))
                    .queryParam("limit", limit)
                    .queryParam("offset", offset)
                    .request(MediaType.APPLICATION_JSON_TYPE)
                    .get(ResultResponse.class);

            return this.responseFactory.createSuccessResponse(result);
        } catch (Exception exception) {
            log.error(exception.getMessage(), exception);
            return this.responseFactory.createInternalServerError("Search result error!");
        }
    }
}
