package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {
String port;
String ml;
String ii;
String ia;

   public EnvController(@Value("${port:NOT SET}") String port,
                         @Value("${memory.limit:NOT SET}")String ml,
                         @Value("${cf.instance.index:NOT SET}") String ii,
                         @Value("${cf.instance.addr:NOT SET}") String ia) {
    this.port=port;
    this.ml=ml;
    this.ii=ii;
    this.ia=ia;
    }

    @GetMapping("/env")
    public Map<String, String> getEnv(){
        Map<String,String> env=new HashMap<>();

        env.put("PORT", port);
        env.put("MEMORY_LIMIT", ml);
        env.put("CF_INSTANCE_INDEX", ii);
        env.put("CF_INSTANCE_ADDR", ia);
return env;
    }
}
