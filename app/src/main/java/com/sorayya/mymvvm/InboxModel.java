package com.sorayya.mymvvm;


import lombok.Getter;
import lombok.Setter;

public class InboxModel {
    /*
    @Getter
    @Setter
    private String destinationEmail,messageText;

    private InboxModel(String destinationEmail, String messageText) {
        this.destinationEmail = destinationEmail;
        this.messageText = messageText;
    }

     */

    private static InboxModel inboxModel;
    @Getter
    @Setter
    private String destinationEmail,messageText;
    private InboxModel(String destinationEmail, String messageText) {
        this.destinationEmail = destinationEmail;
        this.messageText = messageText;
    }
    public static InboxModel getInstance(String destinationEmail, String messageText) {

        // create object if it's not already created
        if(inboxModel == null) {
            inboxModel = new InboxModel(destinationEmail, messageText);
        }

        // returns the singleton object
        return inboxModel;
    }
    public static InboxModel getInstance() {

        // create object if it's not already created


        // returns the singleton object
        return inboxModel;
    }


}
