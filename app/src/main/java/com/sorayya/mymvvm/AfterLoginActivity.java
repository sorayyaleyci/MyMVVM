package com.sorayya.mymvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Toast;

import com.sorayya.mymvvm.databinding.ActivityAfterLoginBinding;


public class AfterLoginActivity extends AppCompatActivity {
    public static Handler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityAfterLoginBinding activityAfterLoginBinding=DataBindingUtil.setContentView(this,R.layout.activity_after_login);
        activityAfterLoginBinding.setInboxViewModel(new InboxViewModel());
        activityAfterLoginBinding.executePendingBindings();
        handler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ InboxModel.getInstance().getDestinationEmail()});
                email.putExtra(Intent.EXTRA_SUBJECT, "Test myMVVM");
                email.putExtra(Intent.EXTRA_TEXT, InboxModel.getInstance().getMessageText());

               //send email from an other pp like gmail
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client :"));


                System.out.println(InboxModel.getInstance().getMessageText());

            }
        };



    }
    // any change in toastMessage attribute
    // defined on the Button with bind prefix
    // invokes this method
    @BindingAdapter({"toastMessagenw"})
    public static void runMe(View view, String message) {
        if (message != null){
            Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
            if(message.equals("sent")){

                handler.obtainMessage(1).sendToTarget();

            }
        }
    }
}