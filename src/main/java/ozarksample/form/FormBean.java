package ozarksample.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;
import javax.ws.rs.FormParam;

public class FormBean {
    
    @Size(min = 1, max = 10, groups = {Default.class, Group1.class})
    @FormParam("name")
    private String name;

    @Size(min = 1, max = 3, groups = {Default.class, Group1.class})
    @Pattern(regexp = "[1-9][0-9]*", groups = {Default.class, Group2.class})
    @Min(value = 0, groups = {Default.class, Group3.class})
    @Max(value = 200, groups = {Default.class, Group3.class})
    @FormParam("age")
    private String age;

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
    public String getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(String age) {
        this.age = age;
    }
}
