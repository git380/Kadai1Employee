package L100.L101.model;

public class Login {
    private String empid;
    private String emppasswd;

    public Login(String empId, String emppasswd) {
        this.empid = empId;
        this.emppasswd = emppasswd;
    }

    public String getEmpId() {
        return empid;
    }

    public String getEmppasswd() {
        return emppasswd;
    }
}