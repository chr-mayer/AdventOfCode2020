package day04;

import java.util.Objects;

public class Passport {
    private String byr;
    private String iyr;
    private String eyr;
    private String hgt;
    private String hcl;
    private String ecl;
    private String pid;
    private String cid;

    public Passport(String byr, String iyr, String eyr, String hgt, String hcl, String ecl, String pid, String cid) {
        this.byr = byr;
        this.iyr = iyr;
        this.eyr = eyr;
        this.hgt = hgt;
        this.hcl = hcl;
        this.ecl = ecl;
        this.pid = pid;
        this.cid = cid;
    }

    public String getByr() {
        return byr;
    }

    public String getIyr() {
        return iyr;
    }

    public String getEyr() {
        return eyr;
    }

    public String getHgt() {
        return hgt;
    }

    public String getHcl() {
        return hcl;
    }

    public String getEcl() {
        return ecl;
    }

    public String getPid() {
        return pid;
    }

    public String getCid() {
        return cid;
    }

    public void setByr(String byr) {
        this.byr = byr;
    }

    public void setIyr(String iyr) {
        this.iyr = iyr;
    }

    public void setEyr(String eyr) {
        this.eyr = eyr;
    }

    public void setHgt(String hgt) {
        this.hgt = hgt;
    }

    public void setHcl(String hcl) {
        this.hcl = hcl;
    }

    public void setEcl(String ecl) {
        this.ecl = ecl;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Passport)) return false;
        Passport passport = (Passport) o;
        return Objects.equals(byr, passport.byr) && Objects.equals(iyr, passport.iyr) && Objects.equals(eyr, passport.eyr) && Objects.equals(hgt, passport.hgt) && Objects.equals(hcl, passport.hcl) && Objects.equals(ecl, passport.ecl) && Objects.equals(pid, passport.pid) && Objects.equals(cid, passport.cid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(byr, iyr, eyr, hgt, hcl, ecl, pid, cid);
    }


}
