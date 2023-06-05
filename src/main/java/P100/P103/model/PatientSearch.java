package P100.P103.model;

public class PatientSearch {
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

    public void setPatid(String patid) {
        this.patid = patid;
    }

    public String getPatfname() {
        return patfname;
    }

    public void setPatfname(String patfname) {
        this.patfname = patfname;
    }

    public String getPatlname() {
        return patlname;
    }

    public void setPatlname(String patlname) {
        this.patlname = patlname;
    }

    public String getHokenmei() {
        return hokenmei;
    }

    public void setHokenmei(String hokenmei) {
        this.hokenmei = hokenmei;
    }

    public String getHokenexp() {
        return hokenexp;
    }

    public void setHokenexp(String hokenexp) {
        this.hokenexp = hokenexp;
    }
}
