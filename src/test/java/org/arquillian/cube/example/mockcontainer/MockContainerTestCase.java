package org.arquillian.cube.example.mockcontainer;

import java.net.Socket;

import org.arquillian.cube.HostIp;
import org.arquillian.cube.docker.impl.util.IOUtil;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class MockContainerTestCase {

    @HostIp
    private String hostIp;
    
    @Test
    public void shouldMockGoogleCom() throws Exception {
        Socket socket = new Socket(hostIp, 8085);
        String response = IOUtil.asString(socket.getInputStream());

        socket.close();
        
        System.out.println(response);
        Assert.assertTrue(response.contains("INTERCEPTED"));
    }
}
