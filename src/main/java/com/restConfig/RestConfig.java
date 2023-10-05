package com.restConfig;
import java.util.HashMap;
import java.util.Map;

//JAX-RS와 관련된 패키지는 꼭 javax.ws.rs.*을 사용
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
@ApplicationPath("/api") //RESR API 서비스 진입점을 의미.
public class RestConfig extends Application {
    public Map<String, Object> getProperties() {
        Map<String, Object> properties = new HashMap<>();

        properties.put("jersey.config.server.provider.packages", "restAPI");
        return properties;
    }
}

