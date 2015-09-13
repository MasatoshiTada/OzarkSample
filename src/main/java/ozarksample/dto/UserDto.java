package ozarksample.dto;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ConversationScoped
public class UserDto implements Serializable {
    
    @PostConstruct
    public void init() {
        System.out.println("init:" + this.toString());
    }
    
    @PreDestroy
    public void destroy() {
        System.out.println("destroy:" + this.toString());
    }
    
    @Inject
    private Conversation conversation;
    
    private String name;
    private String address;

    public void beginConversation() {
        if (conversation.isTransient()) {
            conversation.begin();
            System.out.println("begin: conv = " + conversation.toString() 
                    + ", UserDto = " + this.toString());
        }
    }
    
    public void endConversation() {
        if (!conversation.isTransient()) {
            conversation.end();
            System.out.println("end: conv = " + conversation.toString() 
                    + ", UserDto = " + this.toString());
        }
    }
    
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
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }
}
