package com.example.openappnapp.Activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.openappnapp.R;
import com.example.openappnapp.Utility;

public class LoginActivity extends AppCompatActivity {

//    ActivityLoginBinding binding;
    AppCompatActivity activity = this;
    TextView total,save,cancel;
    EditText firstText;
    EditText secondText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        firstText = findViewById(R.id.eidFirstName);
        secondText = findViewById(R.id.eidLastName);
        total = findViewById(R.id.total);
        save = findViewById(R.id.textAddition);
        cancel = findViewById(R.id.textCancel);

        setInIt();

    }

    private void setInIt() {

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    int first = Integer.parseInt(firstText.getText().toString());
                    int number = Integer.parseInt(secondText.getText().toString());
                    int answer = first + number;
                    Log.e("Response", "addDatatoFirebase: " + answer);
                    if(answer > 0) {
                        total.setText(Integer.toString(answer));
                    } else {
                        Utility.ShowToast(activity, "Please Valid Addition Value");
                    }
                } catch (NullPointerException e) {
                    System.out.println("Caught inside help().");
                }


//                String email = binding.eidEmail.getText().toString();
//
//                if (Utility.isEmptyVal(String.valueOf(first))) {
//                    Utility.ShowToast(activity, "Please enter your first name");
//                } else if (Utility.isEmptyVal(String.valueOf(number))) {
//                    Utility.ShowToast(activity, "Please enter your number name");
//                }else if (Utility.isEmptyVal(String.valueOf(answer))) {
//                    Utility.ShowToast(activity, "Please enter your email name");
//                }
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int first = Integer.parseInt(firstText.getText().toString());
                    int number = Integer.parseInt(secondText.getText().toString());
                    int answer = first - number;
                    Log.e("Response", "addDatatoFirebase: " + answer);
                    if(answer < 0) {
                        total.setText(Integer.toString(answer));
                    } else {
                        Utility.ShowToast(activity, "Please Valid Addition Value");
                    }
                } catch (NullPointerException e) {
                    System.out.println("Caught inside help().");
                }

            }
        });
    }

}