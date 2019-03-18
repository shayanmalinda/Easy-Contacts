package com.im.easycontacts;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class NewContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle!=null){
            String name = bundle.getString("name");
            String phone = bundle.getString("phone");
            String email = bundle.getString("email");
            String address = bundle.getString("address");
            String company = bundle.getString("company");

            EditText etName = findViewById(R.id.etName);
            etName.setText(name);
            EditText etPhone = findViewById(R.id.etPhone);
            etPhone.setText(phone);
            EditText etEmail = findViewById(R.id.etEmail);
            etEmail.setText(email);
            EditText etAddress = findViewById(R.id.etAddress);
            etAddress.setText(address);
            EditText etCompany = findViewById(R.id.etCompany);
            etCompany.setText(company);
        }

    }

    public void contactSave(View v){
        DBHelper mydb = new DBHelper(this);
        SQLiteDatabase db = mydb.getWritableDatabase();

        EditText etName = findViewById(R.id.etName);
        EditText etPhone = findViewById(R.id.etPhone);
        EditText etEmail = findViewById(R.id.etEmail);
        EditText etAddress = findViewById(R.id.etAddress);
        EditText etCompany = findViewById(R.id.etCompany);

        String contactName = etName.getText().toString();
        String contactPhone = etPhone.getText().toString();
        String contactEmail = etEmail.getText().toString();
        String contactAddress = etAddress.getText().toString();
        String contactCompany = etCompany.getText().toString();

        String sql;

        sql = "INSERT INTO person ( name, phone, email ,address, company ,status) VALUES ('"+contactName+"' ,'"+contactPhone+"' ,'"+contactEmail+"' " +
                ",'"+contactAddress+"' ,'"+contactCompany+"' , '0') ";

        db.execSQL(sql);

        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this,ContactListActivity.class);
        startActivity(intent);
    }
}
