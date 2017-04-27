package com.ambuj;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by Aj on 06-04-2017.
 */
@ConfigurationProperties(prefix = "service", ignoreUnknownFields = false)
public class HelloWorldProperties {


    private String name = "World";

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
