package com.ambuj;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

/**
 * Created by Aj on 05-04-2017.
 */
@Controller
@Description("A controller for handling requests for hello messages")
public class HelloController {

    private final HelloWorldProperties helloWorldProperties;

    public HelloController(HelloWorldProperties helloWorldProperties) {
        this.helloWorldProperties = helloWorldProperties;
    }

    @GetMapping("/")
    @ResponseBody
    public Map<String, String> hello() {
        return Collections.singletonMap("message",
                "Hello " + this.helloWorldProperties.getName());
    }


}
