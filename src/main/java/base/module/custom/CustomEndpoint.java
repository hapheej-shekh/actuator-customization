package base.module.custom;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import base.module.beans.CustomHealth;

@Component
@Endpoint(id="customhealth")
public class CustomEndpoint {

	
	@ReadOperation
    public String customEndPointByName(@Selector String name) {
        return "custom-end-point";
    }
	
	@ReadOperation
    public CustomHealth health() {
        Map<String, Object> details = new LinkedHashMap<>();
        details.put("CustomHealthStatus", "Everything looks good");
        CustomHealth health = new CustomHealth();
        health.setHealthDetails(details);
        return health;
    }
}
