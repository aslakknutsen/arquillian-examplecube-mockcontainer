package org.arquillian.cube.example.mockcontainer;

import org.junit.Test;
import org.mockserver.client.server.MockServerClient;
import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;
import static org.mockserver.model.HttpForward.forward;
import static org.mockserver.model.Header.header;
import static org.mockserver.model.HttpResponse.notFoundResponse;
import static org.mockserver.model.HttpResponse.response;
import static org.mockserver.matchers.Times.exactly;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.mockserver.model.HttpForward.Scheme.HTTP;
import static org.mockserver.model.HttpStatusCode.ACCEPTED_202;

public class MockServerTest {

    @Test
    public void should() throws Exception {
        new MockServerClient("192.168.99.100", 1080)
            .when(
                    request()
                        .withMethod("GET")
                        .withPath("/")
            ).respond(
                    response()
                        .withStatusCode(200)
                        .withBody("INTERCEPTED"));
        
        Thread.sleep(2000);
    }
}
