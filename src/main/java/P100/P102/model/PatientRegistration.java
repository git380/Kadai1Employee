package P100.P102.model;

public class PatientRegistration {
    private String patid;
    private String hokenmei;
    private String hokenexp;

    public PatientRegistration(String patid, String hokenmei, String hokenexp) {
        this.patid = patid;
        this.hokenmei = hokenmei;
        this.hokenexp = hokenexp;
    }

    public String getPatid() {
        return patid;
    }

    public String getHokenmei() {
        return hokenmei;
    }

    public String getHokenexp() {
        return hokenexp;
    }
}