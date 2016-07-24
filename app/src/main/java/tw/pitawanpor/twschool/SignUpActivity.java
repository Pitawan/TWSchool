package tw.pitawanpor.twschool;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
            passwordString, statusString = "1",QRcodeString;

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

        //การทำ Radio Controller
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                switch (i) {
                    case R.id.radioButton:
                        // for Student
                        statusString = "1";

                        break;
                    case R.id.radioButton2:
                        // for Teacher
                        statusString = "0";

                        break;

                }   //switch
            }// onCheck
        });


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
            switch (Integer.parseInt(statusString)) {

                case 0:
                    QRcodeString = "teacher_" + userString;
                    break;
                case 1:
                    QRcodeString = "student_" + userString;
                    break;

            } // switch

            confirmValue();

        } //if



    }   //clickSignUp

    private void confirmValue() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setIcon(R.drawable.kon48);
        builder.setTitle("โปรดตรวจสอบข้อมูล");
        builder.setMessage("Name = "+nameString + "\n" +
        "Surname = "+ surnameString + "\n" +
                "Status = " + showStatus(statusString) + "\n" +
        "Room = " + roomString + "\n" +
                "User = " + userString + "\n" +
        "Password = " + passwordString + "\n" +
        "QRCode = " + QRcodeString);

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                upLoadValueToServer();
                dialogInterface.dismiss();
            }
        });
        builder.show();




    }   // confirmValue

    private void upLoadValueToServer() {

    }   //upload

    private String showStatus(String statusString) {

        String result = null;
        switch (Integer.parseInt(statusString)) {
            case 0 :
                result = "Teacher";
                break;
            case 1:
                result = "Student";
                break;
        }

        return result;
    }


}   //Main Class
