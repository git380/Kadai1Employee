package A100.model;

public class Account {
    private String empId;
    private String empFName;
    private String empLName;
    private String empPasswd;
    private int empRole;

    public Account(String empId, String empFName, String empLName, String empPasswd, int empRole) {
        this.empId = empId;
        this.empFName = empFName;
        this.empLName = empLName;
        this.empPasswd = empPasswd;
        this.empRole = empRole;
    }

    public String getEmpId() {
        return empId;
    }

    public String getEmpFName() {
        return empFName;
    }

    public String getEmpLName() {
        return empLName;
    }

    public String getEmpPasswd() {
        return empPasswd;
    }

    public int getEmpRole() {
        return empRole;
    }
}