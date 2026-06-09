package Encapsulation;

public class Message {
    protected String message;

    void setMessage(String message){
        this.message = message;
    }

    String getMessage(){
        return message;
    }

    void sendMessage(){
        System.out.println("The message is being printed is normal message");
    }
}
