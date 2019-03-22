package com.im.easycontacts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ViewContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_contact);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle!=null){
            String name = bundle.getString("name");
            String phone = bundle.getString("phone");
            String email = bundle.getString("email");
            String address = bundle.getString("address");
            String company = bundle.getString("company");

            TextView etName = findViewById(R.id.etName);
            etName.setText(name);
            TextView etPhone = findViewById(R.id.etPhone);
            etPhone.setText(phone);
            TextView etEmail = findViewById(R.id.etEmail);
            etEmail.setText(email);
            TextView etAddress = findViewById(R.id.etAddress);
            etAddress.setText(address);
            TextView etCompany = findViewById(R.id.etCompany);
            etCompany.setText(company);
        }
    }
}
