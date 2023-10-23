package com.example.openappnapp.Activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

//import com.bee.nativedemo3.Model.User;
//import com.bee.nativedemo3.Utility;
//import com.bee.nativedemo3.databinding.ActivityLoginBinding;
import com.example.openappnapp.Model.User;
import com.example.openappnapp.Utility;
import com.example.openappnapp.databinding.ActivityLoginBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    AppCompatActivity activity = this;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("UserInfo");
        user = new User();

        setInIt();

    }

    private void setInIt() {

        binding.textContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String first = binding.eidFirstName.getText().toString();
                String number = binding.eidLastName.getText().toString();
                String email = binding.eidEmail.getText().toString();

                if (Utility.isEmptyVal(first)) {
                    Utility.ShowToast(activity, "Please enter your first name");
                } else if (Utility.isEmptyVal(number)) {
                    Utility.ShowToast(activity, "Please enter your number name");
                }else if (Utility.isEmptyVal(email)) {
                    Utility.ShowToast(activity, "Please enter your email name");
                }else {
                    addDatatoFirebase(first,number,email);
                    finish();
                }

            }
        });
        binding.textCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void addDatatoFirebase(String first, String Last,String email) {

        Log.e("Response", "addDatatoFirebase: " + email);

        user.setFirstName(first);
        user.setLastName(Last);
        user.setEmail(email);

        // we are use add value event listener method
        // which is called with database reference.
        databaseReference.addValueEventListener(new ValueEventListener() {

            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // inside the method of on Data change we are setting
                // our object class to our database reference.
                // data base reference will sends data to firebase.
                databaseReference.setValue(user);

                // after adding this data we are showing toast message.
                Utility.ShowToast(activity, "data added");
            }

            public void onCancelled(@NonNull DatabaseError error) {
                // if the data is not added or it is cancelled then
                // we are displaying a failure toast message.
                Utility.ShowToast(activity, "Fail to add data " + error);
            }
        });
    }

}