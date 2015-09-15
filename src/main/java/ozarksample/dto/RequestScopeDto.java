package ozarksample.dto;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("dto")
@RequestScoped
public class RequestScopeDto {
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
