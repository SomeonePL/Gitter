package gitter.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import  java.io.IOException;
@RestController
public class GitController {
    @GetMapping("/allegrogit")
    public @ResponseBody Gitter recent() {
        Gitter git = new Gitter();
        git.recent();
        return git;
    }
}

