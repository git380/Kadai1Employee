package P100.P105.model;

import java.io.Serializable;

public class PatientSearch implements Serializable {
    private static final long serialVersionUID = 1L;

    private String patid;
    private String patfname;
    private String patlname;
    private String hokenmei;
    private String hokenexp;

    public PatientSearch(String patid, String patfname, String patlname, String hokenmei, String hokenexp) {
        this.patid = patid;
        this.patfname = patfname;
        this.patlname = patlname;
        this.hokenmei = hokenmei;
        this.hokenexp = hokenexp;
    }

    public String getPatid() {
        return patid;
    }

    public String getPatfname() {
        return patfname;
    }

    public String getPatlname() {
        return patlname;
    }

    public String getHokenmei() {
        return hokenmei;
    }

    public String getHokenexp() {
        return hokenexp;
    }
}
