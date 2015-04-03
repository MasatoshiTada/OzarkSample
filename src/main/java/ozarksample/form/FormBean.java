package ozarksample.form;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.FormParam;

@RequestScoped
@Named
public class FormBean {
    
    @NotNull
    @Size(min = 1, max = 10)
    @FormParam("name")
    private String name;
    
    @NotNull
    @Min(0)
    @Max(200)
    @FormParam("age")
    private Integer age;

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

    /**
     * @return the age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(Integer age) {
        this.age = age;
    }
}
