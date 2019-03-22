package com.im.easycontacts;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EditContactActivity extends AppCompatActivity {

    String id,name,phone,email,address,company;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle!=null){
            id = bundle.getString("id");
            name = bundle.getString("name");
            phone = bundle.getString("phone");
            email = bundle.getString("email");
            address = bundle.getString("address");
            company = bundle.getString("company");

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

    public void contactEdit(View v){


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        id = bundle.getString("id");

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

        Toast.makeText(this, contactName, Toast.LENGTH_SHORT).show();

        String sql;

        sql = "UPDATE person SET name='"+contactName+"', phone='"+contactPhone+"' , email='"+contactEmail+"' , address='"+contactAddress+"'" +
                " ,company='"+contactCompany+"'  WHERE _id='"+id+"'";

        db.execSQL(sql);

        Toast.makeText(this, "Edited", Toast.LENGTH_SHORT).show();

        Intent intent2 = new Intent(this,ContactListActivity.class);
        startActivity(intent2);
    }
}
