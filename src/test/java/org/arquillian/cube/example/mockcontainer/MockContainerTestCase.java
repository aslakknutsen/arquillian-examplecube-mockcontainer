package org.arquillian.cube.example.mockcontainer;

import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

import java.net.URL;

import org.arquillian.cube.HostIp;
import org.arquillian.cube.containerobject.HostPort;
import org.arquillian.cube.docker.impl.util.IOUtil;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockserver.client.server.MockServerClient;

@RunWith(Arquillian.class)
public class MockContainerTestCase {

    @HostIp
    private String hostIp;

    private MockServerClient mock;

    @Before
    public void setupMock() {
        mock = new MockServerClient(hostIp, 1080);
        mock
        .when(
                request()
                    .withMethod("GET")
        ).respond(
                response()
                    .withStatusCode(200)
                    .withBody("INTERCEPTED"));
    }

    @After
    public void clear() {
        mock.clear(null);
    }
    
    @Test
    public void shouldMockGoogleCom() throws Exception {
        String response = IOUtil.asString(new URL("http", hostIp, 8085, "").openStream());

        System.out.println(response);
        Assert.assertTrue(response.contains("INTERCEPTED"));
    }
}
