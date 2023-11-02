package packages.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
public class homeConfig {

    @Value("${server.port}")
    private String appPort;


    @EventListener({ApplicationReadyEvent.class})
    public void applicationReadyEvent(){
        String url="http://localhost:"+appPort+"/src/resource/static/html/elementTest.html";

        Runtime run=Runtime.getRuntime();
        try {
            run.exec("rundll32 url.dll,FileProtocolHandler"+url);
        }catch (Exception e){
            e.printStackTrace();
        }


    }

}
