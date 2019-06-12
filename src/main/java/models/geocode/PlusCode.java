package models.geocode;

public class PlusCode {
    public String compoundCode;
    public String globalCode;

    public PlusCode() {
    }

    public PlusCode(String compoundCode, String globalCode) {
        this.compoundCode = compoundCode;
        this.globalCode = globalCode;
    }

    public String getCompoundCode() {
        return this.compoundCode;
    }

    public void setCompoundCode(String compoundCode) {
        this.compoundCode = compoundCode;
    }

    public String getGlobalCode() {
        return this.globalCode;
    }

    public void setGlobalCode(String globalCode) {
        this.globalCode = globalCode;
    }

    @Override
    public String toString() {
        return "{" + " compoundCode='" + getCompoundCode() + "'" + ", globalCode='" + getGlobalCode() + "'" + "}";
    }

}