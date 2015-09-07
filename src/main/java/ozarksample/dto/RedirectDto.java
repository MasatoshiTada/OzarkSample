package ozarksample.dto;

import java.io.Serializable;
import javax.inject.Named;
import javax.mvc.annotation.RedirectScoped;

@Named
@RedirectScoped
public class RedirectDto implements Serializable {
    private String name;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
