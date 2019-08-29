package org.eastwill.domain;

import java.util.HashMap;


public class Response extends HashMap<String, Object> {

    private static final long serialVersionUID = -8713837118340960775L;

    public Response message(String message) {
        this.put("message", message);
        return this;
    }

    public Response data(Object data) {
        this.put("result", data);
        return this;
    }
    
    public Response timestamp(Long timestamp) {
    	this.put("timestamp", timestamp);
    	return this;
    }

    public Response code(Integer code) {
    	this.put("code", code);
    	return this;
    }
    @Override
    public Response put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
