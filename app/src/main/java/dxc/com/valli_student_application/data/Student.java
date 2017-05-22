package dxc.com.valli_student_application.data;

/**
 * Created by jayasees on 5/16/2017.
 */
public class Student {

    int _id;
    String _name;
    int contactNumber;
    String department;
    String eMail;

    public Student(){   }

    public Student(int id, String paramName, int paramContactNumber,String paramDepartment,String paramEMail){
        this._id = id;
        this._name = paramName;
        this.contactNumber = paramContactNumber;
        this.department=paramDepartment;
        this.eMail= paramEMail;
    }

        public Student( String paramName, int paramContactNumber,String paramDepartment,String paramEMail){
            this._name = paramName;
            this.contactNumber = paramContactNumber;
            this.department=paramDepartment;
            this.eMail= paramEMail;
        }
        public int getID(){
            return this._id;
        }

        public void setID(int id){
            this._id = id;
        }

        public String getName(){
            return this._name;
        }

        public void setName(String name){
            this._name = name;
        }

        public int getContactNumber(){
            return this.contactNumber;
        }

        public void setContactNumber(int contactNumber){
            this.contactNumber = contactNumber;
        }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }


}
