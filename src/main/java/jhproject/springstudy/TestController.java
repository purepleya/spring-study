package jhproject.springstudy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    @GetMapping("/refresh")
    public String refresh() {
        applicationContext.refresh();

        return "refresh";
    }


    @GetMapping("/close")
    public String close() {
        applicationContext.close();

        return "close";
    }

}
