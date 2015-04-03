package ozarksample;

import com.oracle.ozark.engine.JspViewEngine;
import com.oracle.ozark.jersey.OzarkFeature;
import java.util.Map;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.mvc.engine.ViewEngine;
import javax.mvc.event.ViewEngineSelected;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("api")
public class MyApplication extends Application {

    
    @Override
    public Map<String, Object> getProperties() {
        Map<String, Object> prop = super.getProperties();
        //prop.put("VIEW_ENGINE", JspViewEngine.class);
        return prop;
    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> set = super.getClasses();
        //set.add(OzarkFeature.class);
        //set.add(JspViewEngine.class);
        return set;
    }
    
    
}
