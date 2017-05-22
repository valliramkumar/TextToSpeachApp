package dxc.com.valli_student_application.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import dxc.com.valli_student_application.data.Student;

/**
 * Created by jayasees on 5/16/2017.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "students_manager";
    private static final String TABLE_STUDENTS = "STUDENTS";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_CONTACT_NO = "contact_number";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_DEPARTMENT = "department";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_STUDENTS_TABLE = "CREATE TABLE " + TABLE_STUDENTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_CONTACT_NO + " INTEGER," +KEY_EMAIL + " TEXT)";
        db.execSQL(CREATE_STUDENTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addStudent(Student objStudent)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_NAME,objStudent.getName());
        values.put(KEY_CONTACT_NO,objStudent.getContactNumber());
        values.put(KEY_EMAIL,objStudent.geteMail());
        values.put(KEY_DEPARTMENT, objStudent.getDepartment());

        // Inserting Row
        db.insert(TABLE_STUDENTS, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    Student getStudent(int id)
    {
        Student objStudent = null;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_STUDENTS, new String[] { KEY_ID,
                        KEY_NAME, KEY_DEPARTMENT, KEY_CONTACT_NO,KEY_EMAIL }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);

        if(cursor!=null)
            objStudent=new Student(cursor.getInt(0),cursor.getString(1),
                    cursor.getInt(2),cursor.getString(3),cursor.getString(4));
        return objStudent;
    }

    public List<Student> getAllStudents()
    {
        List<Student> listStudent = new ArrayList<Student>();

        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM" + TABLE_STUDENTS;

        Cursor cursor = db.rawQuery(query,null);

        if(cursor !=null)
        {
            if(cursor.moveToFirst())
            {
                do{

                    Student student = new Student();

                    student.setID(cursor.getInt(0));
                    student.setName(cursor.getString(1));
                    student.setDepartment(cursor.getString(2));
                    student.setContactNumber(cursor.getInt(3));
                    student.seteMail(cursor.getString(4));

                    listStudent.add(student);

                }while(cursor.moveToNext());
            }
        }

        return listStudent;
    }
}
