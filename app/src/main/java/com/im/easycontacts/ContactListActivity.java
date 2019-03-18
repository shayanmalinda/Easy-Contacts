package com.im.easycontacts;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;


public class ContactListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);
    }

    @Override
    protected void onResume() {
        super.onResume();

        String sql = "SELECT _id,name,phone,email,address,company FROM person";
        DBHelper mydb = new DBHelper(this);
        SQLiteDatabase db = mydb.getReadableDatabase();

        Cursor cursor = db.rawQuery(sql,null);

        cursor.moveToFirst();

        ListView lv = findViewById(R.id.contactList);

        String[] cols = {"name","phone","email","address","company","_id"};
        int[] views = {R.id.ContactName,R.id.ContactPhone,R.id.ContactEmail,R.id.ContactAddress,R.id.ContactCompany,R.id.ContactID};
        int layout = R.layout.segment_task;

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,layout,cursor,cols,views);
        lv.setAdapter(adapter);

    }

    public void NewContact(View v){
        Intent intent = new Intent(this,NewContactActivity.class);
        startActivity(intent);
    }

    public void open(View v){
        TextView name = v.findViewById(R.id.ContactName);
        String contactName = name.getText().toString();

        TextView phone = v.findViewById(R.id.ContactPhone);
        String contactPhone = phone.getText().toString();

        TextView email = v.findViewById(R.id.ContactEmail);
        String contactEmail = email.getText().toString();

        TextView address = v.findViewById(R.id.ContactAddress);
        String contactAddress = address.getText().toString();

        TextView company = v.findViewById(R.id.ContactCompany);
        String contactCompany = company.getText().toString();

        Intent intent = new Intent(this,NewContactActivity.class);

        intent.putExtra("name",contactName);
        intent.putExtra("phone",contactPhone);
        intent.putExtra("email",contactEmail);
        intent.putExtra("address",contactAddress);
        intent.putExtra("company",contactCompany);

        startActivity(intent);

    }
}
