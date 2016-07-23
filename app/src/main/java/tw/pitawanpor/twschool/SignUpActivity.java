package tw.pitawanpor.twschool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.security.PublicKey;

public class SignUpActivity extends AppCompatActivity {

    //Explicit  การประกาศตัวแปร เพื่อสำรองหน่วยความจำแรม

    private EditText nameEditText, surnameEditText, roomEditText,
    userEditText, passwordEditText;

    private RadioGroup radioGroup;
    private RadioButton studentRadioButton, teacherRadioButton;
    private String nameString, surnameString, roomString, userString,
            passwordString, statusString,QRcodeString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        //Initial Widget
        nameEditText = (EditText) findViewById(R.id.editText);
        surnameEditText = (EditText) findViewById(R.id.editText2);
        roomEditText = (EditText) findViewById(R.id.editText3);
        userEditText = (EditText) findViewById(R.id.editText4);
        passwordEditText = (EditText) findViewById(R.id.editText5);
        radioGroup = (RadioGroup) findViewById(R.id.ragStatus);
        studentRadioButton = (RadioButton) findViewById(R.id.radioButton);
        teacherRadioButton = (RadioButton) findViewById(R.id.radioButton2);


    }   //Main Method

    public void clickSignUpSign(View view) {

        //Get Value From Edit Text ดึงค่าจาก Edit Text
        nameString = nameEditText.getText().toString().trim();
        surnameString = surnameEditText.getText().toString().trim();
        roomString = roomEditText.getText().toString().trim();
        userString = userEditText.getText().toString().trim();
        passwordString = passwordEditText.getText().toString().trim();

        //Check Space ตรวจสอบว่าสิ่งที่เป็นสตริงมี่องว่าง

        if (nameString.equals("") || surnameString.equals("") ||
                roomString.equals("") || userString.equals("") ||
                passwordString.equals("")) {
            //Have Space

            Toast.makeText(this, "กรุณากรอกทุกช่องค่ะ", Toast.LENGTH_SHORT).show();

        } else {
            //No Space
        } //if



    }   //clickSignUp
}   //Main Class
