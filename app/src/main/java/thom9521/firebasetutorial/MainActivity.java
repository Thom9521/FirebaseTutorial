package thom9521.firebasetutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private EditText editName;
    //private EditText editEmail;
    private Button tilmeldBtn;
    private Button hentIdBtn;
    //private ListView listView;

   // private ArrayList<String> listOplysninger = new ArrayList<>();

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = (EditText) findViewById(R.id.editName);
       // editEmail = (EditText) findViewById(R.id.editEmail);
        tilmeldBtn = (Button) findViewById(R.id.tilmeldBtn);
        hentIdBtn = (Button) findViewById(R.id.hentIdBtn);
       // listView = (ListView) findViewById(R.id.listView);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        tilmeldBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString().trim();
                //String email = editEmail.getText().toString().trim();

               // HashMap<String, String> dataMap = new HashMap<String, String>();
               // dataMap.put("Navn", name);
                //dataMap.put("Email", email);

               // mDatabase.push().setValue(dataMap);
                mDatabase.child("Name").setValue(name);
            }
        });
/*
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listOplysninger);
        listView.setAdapter(arrayAdapter);

        mDatabase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                String value = dataSnapshot.getValue(String.class);
                listOplysninger.add(value);
                arrayAdapter.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        }); */


        hentIdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent main2Activity = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(main2Activity);
            }
        });
    }
}
