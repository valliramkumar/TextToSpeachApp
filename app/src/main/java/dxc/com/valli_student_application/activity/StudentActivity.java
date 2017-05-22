package dxc.com.valli_student_application.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import dxc.com.valli_student_application.R;

public class StudentActivity extends AppCompatActivity {

    /** Called when the activity is first created. */


    private Button buttonAddStudent;
    private EditText studentName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        buttonAddStudent = (Button) findViewById(R.id.button1);
        studentName = (EditText) findViewById(R.id.studentName);

        buttonAddStudent.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0)
            {


                String msg=studentName.getText().toString();
                Toast.makeText(getApplicationContext(), msg,
                        Toast.LENGTH_LONG).show();
            }

        });
    } // end of onCreate Method


}
