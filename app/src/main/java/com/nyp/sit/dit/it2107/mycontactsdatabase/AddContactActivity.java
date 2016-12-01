package com.nyp.sit.dit.it2107.mycontactsdatabase;


        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;

public class AddContactActivity extends AppCompatActivity {

    Button myAddRecordBtn;
    EditText addNameET;
    EditText addNumET;
    MyContacts mc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        addNameET = (EditText) findViewById(R.id.addNameET);
        addNumET = (EditText) findViewById(R.id.addNumET);
        myAddRecordBtn = (Button) findViewById(R.id.addRecordsBtn);

        //step 36 - add listener to add contact into database
        mc = MyContacts.getInstance();
        myAddRecordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String addNameStr = addNameET.getText().toString();
                String addNumberStr = addNumET.getText().toString();

                mc.addToDatabase(addNameStr,addNumberStr,getApplicationContext());
                finish();
            }
        });

    }



}
