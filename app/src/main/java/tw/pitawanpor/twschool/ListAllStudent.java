package tw.pitawanpor.twschool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class ListAllStudent extends AppCompatActivity {

    //explicit
    private ListView listView;
    private String roomString;
    private String[] nameStrings, surnameStrings,
            latStrings, lngStrings;
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

        //show text
        textView.setText("รายชื่อนักเรียน ห้อง "+ roomString);

        //show listview
        StudentAdapter studentAdapter = new StudentAdapter(this, nameStrings, surnameStrings);
        listView.setAdapter(studentAdapter);


    }//Main Method
    public void  clickBackListStudent(View view) {
        finish();
    }
}// Main class


