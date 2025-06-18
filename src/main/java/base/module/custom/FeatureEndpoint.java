package base.module.custom;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.server.PathParam;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import base.module.beans.Feature;

@Component
@Endpoint(id = "features")
public class FeatureEndpoint {

	
	private Map<String, Feature> features = new ConcurrentHashMap<>();
	
	@ReadOperation
    public Map<String, Feature> features() {
        return features;
    }

    @ReadOperation
    public Feature feature(@Selector String name) {
        return features.get(name);
    }

    @WriteOperation
    public void configureFeature(@Selector String key, @PathParam(value = "enabled") boolean enabled,
    		@PathParam(value = "name") String name,
    		@PathParam(value = "detail") String detail) {
    	
    	
        features.put(key, new Feature(enabled, name, detail));
    }

    @DeleteOperation
    public void deleteFeature(@Selector String name) {
        features.remove(name);
    }
}
