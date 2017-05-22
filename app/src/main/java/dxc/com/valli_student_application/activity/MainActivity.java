package dxc.com.valli_student_application.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import dxc.com.valli_student_application.R;
import dxc.com.valli_student_application.data.Student;
import dxc.com.valli_student_application.db.DatabaseHandler;

public class MainActivity extends AppCompatActivity {

    /** Called when the activity is first created. */


    private Button buttonAddStudent;
    private EditText studentName;
    private  EditText department;
    private EditText eMail;
    private EditText contactNo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DatabaseHandler db = new DatabaseHandler(this);

        buttonAddStudent = (Button) findViewById(R.id.button1);
        studentName = (EditText) findViewById(R.id.studentName);
        department = (EditText) findViewById(R.id.department);
        contactNo = (EditText) findViewById(R.id.contactNo);
        eMail = (EditText) findViewById(R.id.email);

        buttonAddStudent.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0)
            {
                String strName = studentName.toString();
                String strDepartment = department.toString();
                String strEmail = eMail.toString();
//                int iContactNo = Integer.parseInt(contactNo.toString());
                int iContactNo = 56789;

                db.addStudent(new Student(strName,iContactNo,strDepartment,strEmail));

                String msg=studentName.getText().toString();
                Toast.makeText(getApplicationContext(), msg,
                        Toast.LENGTH_LONG).show();
            }

        });
    } // end of onCreate Method


}
