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
public class ConversationScopeDto implements Serializable {
    
    private String name;
    private String address;

    @Inject
    private Conversation conversation;
    
    @PostConstruct
    public void init() {
        System.out.println("===== " + this.getClass().getSimpleName() + ".init()"
                + " conversation id = " + conversation.getId());
    }
    
    @PreDestroy
    public void destroy() {
        System.out.println("===== " + this.getClass().getSimpleName() + ".destroy()"
                + " conversation id = " + conversation.getId());
    }
    
    public void beginConversation() {
        if (conversation.isTransient()) {
            conversation.begin();
            conversation.setTimeout(60000);
            System.out.println("===== Conversation.begin()"
                    + " conversation id = " + conversation.getId());
        }
    }
    
    public void endConversation() {
        if (!conversation.isTransient()) {
            conversation.end();
            System.out.println("===== Conversation.end()"
                    + " conversation id = " + conversation.getId());
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
        System.out.println("===== " + this.getClass().getSimpleName() + ".setName()"
                + " conversation id = " + conversation.getId());
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
        System.out.println("===== " + this.getClass().getSimpleName() + "setAddress()"
                + " conversation id = " + conversation.getId());
        this.address = address;
    }
}
