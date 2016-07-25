package tw.pitawanpor.twschool;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class StudentService extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private String[] loginStrings;
    private TextView nameTextView, roomTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_layout);

        // Bind Widget
        nameTextView = (TextView) findViewById(R.id.textView13);
        roomTextView = (TextView) findViewById(R.id.textView14);


        //Show View
        loginStrings = getIntent().getStringArrayExtra("Login");
        nameTextView.setText(loginStrings[1] + " " + loginStrings[2]);
        roomTextView.setText("นักเรียน ห้อง ==> " + loginStrings[4]);


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }   //Main Method

    public void  clickEditStudent(View view) {
        Intent intent = new Intent(StudentService.this, EditStudent.class);
        intent.putExtra("Login", loginStrings);
        startActivity(intent);
        finish();

    }

    public void clickExitStudent(View view) {
        finish();

    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // for Setup Center Map
        final double twLat = 15.350600;  //Latitude ของ รร ตว
        final double twLng = 100.492004;

        LatLng latLng = new LatLng(twLat, twLng);
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16));

        // for Marker School
        mMap.addMarker(new MarkerOptions()
        .position(latLng)
        .icon(BitmapDescriptorFactory.fromResource(R.drawable.tw_logo48))
        .title("โรงเรียนตากฟ้าวิชาประสิทธิ์")
        .snippet("โรงเรียนมัธยมอันดับหนึ่งของ นครสวรรค์"));

        // for Marker Student
        LatLng studentLatLng1 = new LatLng(Double.parseDouble(loginStrings[5]),
                Double.parseDouble(loginStrings[6]));

        mMap.addMarker(new MarkerOptions()
        .position(studentLatLng1)
        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET))
        .title(loginStrings[1]+ " "+loginStrings[2])
        .snippet("ห้อง "+loginStrings[4]));


    }   //onMap
}   //Main Class
