package com.sorayya.mymvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.sorayya.mymvvm.databinding.ActivityAfterLoginBinding;
import com.sorayya.mymvvm.databinding.ActivityMainBinding;

public class AfterLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityAfterLoginBinding activityAfterLoginBinding=DataBindingUtil.setContentView(this,R.layout.activity_after_login);
        activityAfterLoginBinding.setInboxViewModel(new InboxViewModel());
        activityAfterLoginBinding.executePendingBindings();
    }
    // any change in toastMessage attribute
    // defined on the Button with bind prefix
    // invokes this method
    @BindingAdapter({"toastMessagenw"})
    public static void runMe(View view, String message) {
        if (message != null)
            Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
    }
}