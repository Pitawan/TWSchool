package tw.pitawanpor.twschool;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class TeacherLogin extends FragmentActivity implements OnMapReadyCallback {

    //eplicit
    private GoogleMap mMap;
    private String[] userLoginStrings;
    private TextView textView;
    private static final String urlJSON = "http://swiftcodingthai.com/tw/get_user_where_room.php";
    private String jsonString;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_login_layout);

        textView = (TextView) findViewById(R.id.textView15);

        userLoginStrings = getIntent().getStringArrayExtra("Login");

        textView.setText(userLoginStrings[1]+ " "+
        userLoginStrings[2]+" ห้อง "+ userLoginStrings[4]);


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    } // main method



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

        //create student marker
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = new FormEncodingBuilder()
                .add("isAdd", "true")
                .add("Room", userLoginStrings[4])
                .build();
        Request.Builder builder = new Request.Builder();

        Request request = builder.url(urlJSON).post(requestBody).build();

        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                jsonString = response.body().string();
                Log.d("12SepV2", "JSON ==> " + jsonString);


            }//onresponse
        });




    } // onmapready

} //main class
