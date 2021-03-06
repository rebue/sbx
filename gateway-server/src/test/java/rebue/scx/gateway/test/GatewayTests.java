package rebue.scx.gateway.test;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
import rebue.wheel.net.httpclient.HttpClient;
import rebue.wheel.net.httpclient.impl.OkHttpClientImpl;

@Slf4j
public class GatewayTests {

    private final String     _hostUrl    = "http://127.0.0.1:10080";
    private final HttpClient _httpClient = new OkHttpClientImpl();

    @Test
    public void testCrud() throws IOException {
        // final String jsonParams = String.format("", _loginname, _loginpswd);
        // _httpClient.postByJsonParams(_hostUrl + "/login", jsonParams);
        log.info(_httpClient.get(_hostUrl + "/sgn-svr/sgn/secret/get-by-id?id=1"));
    }
}
