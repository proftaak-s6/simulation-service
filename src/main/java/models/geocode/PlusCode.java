package models.geocode;

public class PlusCode {
    public String compound_code;
    public String global_code;

    public PlusCode() {
    }

    public PlusCode(String compound_code, String global_code) {
        this.compound_code = compound_code;
        this.global_code = global_code;
    }

    public String getCompound_code() {
        return this.compound_code;
    }

    public void setCompound_code(String compound_code) {
        this.compound_code = compound_code;
    }

    public String getGlobal_code() {
        return this.global_code;
    }

    public void setGlobal_code(String global_code) {
        this.global_code = global_code;
    }

    @Override
    public String toString() {
        return "{" + " compound_code='" + getCompound_code() + "'" + ", global_code='" + getGlobal_code() + "'" + "}";
    }

}