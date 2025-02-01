
package features.message.model;

/**
 *
 * @author Pratiksha
 */
public class MessageInfo {
    private String title;
    private String message;
    private String messageType;

    public String getMessageType() {
        return this.messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public MessageInfo(){}
    
    public MessageInfo(String title,String message){
    this.title = title;
    this.message = message;
    }
}
