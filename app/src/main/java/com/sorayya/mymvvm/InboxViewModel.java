package com.sorayya.mymvvm;

import android.text.TextUtils;
import android.util.Patterns;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

public class InboxViewModel extends BaseObservable {
    private InboxModel inboxModel;

    // string variables for
    // toast messages
    private String successMessage = "sent";
    private String errorMessage = "message did not send";
    public InboxViewModel() {

        // instantiating object of
        // model class
        inboxModel = new InboxModel("","");
    }


    private String toastMessage = null;

    // getter and setter methods
    // for toast message

    public String getToastMessage() {
        return toastMessage;
    }

    private void setToastMessage(String toastMessage) {
        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);
    }
    // getter and setter methods
    // for email variable
    @Bindable
    public String getDestinationEmail() {
        return inboxModel.getDestinationEmail();
    }

    public void setDestinationEmail(String email) {
        inboxModel.setDestinationEmail(email);
        notifyPropertyChanged(com.sorayya.mymvvm.BR.destinationEmail);
    }

    // getter and setter methods
    // for password variable
    @Bindable
    public String getUserMessage() {
        return inboxModel.getMessageText();
    }

    public void setUserMessage(String msg) {
        inboxModel.setMessageText(msg);
        notifyPropertyChanged(com.sorayya.mymvvm.BR.userMessage);
    }


    // actions to be performed
    // when user clicks
    // the LOGIN button
    public void onButtonClicked() {
        if (isValid())
            setToastMessage(successMessage);
        else
            setToastMessage(errorMessage);
    }

    // method to keep a check
    // that variable fields must
    // not be kept empty by user
    public boolean isValid() {
        return !TextUtils.isEmpty(getDestinationEmail()) && Patterns.EMAIL_ADDRESS.matcher(getDestinationEmail()).matches()
                && getUserMessage().length() > 5;
    }


}
