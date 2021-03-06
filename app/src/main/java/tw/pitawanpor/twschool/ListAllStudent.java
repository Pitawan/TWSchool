package tw.pitawanpor.twschool;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class ListAllStudent extends AppCompatActivity {

    //explicit
    private ListView listView;
    private String roomString;
    private String[] nameStrings, surnameStrings,
            latStrings, lngStrings, loginStrings;
    private TextView textView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_all_student);

        //blind widget

        listView = (ListView) findViewById(R.id.listView);
        textView = (TextView) findViewById(R.id.textView16);


        // Get Value from Intent
        roomString = getIntent().getStringExtra("Room");
        nameStrings = getIntent().getStringArrayExtra("Name");
        surnameStrings = getIntent().getStringArrayExtra("Surname");
        latStrings = getIntent().getStringArrayExtra("Lat");
        lngStrings = getIntent().getStringArrayExtra("Lng");
        loginStrings = getIntent().getStringArrayExtra("Login");


        //show text
        textView.setText("รายชื่อนักเรียน ห้อง "+ roomString);

        //show listview
        StudentAdapter studentAdapter = new StudentAdapter(this, nameStrings, surnameStrings);
        listView.setAdapter(studentAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(ListAllStudent.this, TeacherLogin.class);
                intent.putExtra("Login", loginStrings);
                intent.putExtra("Status", true);
                intent.putExtra("Lat", latStrings[i]);
                intent.putExtra("Lng", lngStrings[i]);
                startActivity(intent);
                finish();

            } // onItemclick
        });


    }//Main Method
    public void  clickBackListStudent(View view) {
        finish();
    }
}// Main class


