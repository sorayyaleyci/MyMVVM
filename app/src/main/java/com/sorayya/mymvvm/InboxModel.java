package com.sorayya.mymvvm;


import lombok.Getter;
import lombok.Setter;

public class InboxModel {
    @Getter
    @Setter
    private String destinationEmail,messageText;

    InboxModel(String destinationEmail, String messageText) {
        this.destinationEmail = destinationEmail;
        this.messageText = messageText;
    }
}
