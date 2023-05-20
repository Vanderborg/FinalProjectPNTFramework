package nopcommerceenums.computeroptions;

public enum HDD {
    HDD_1("320 GB"),
    HDD_2("400 GB [+$100.00]");

    private final String hDD;

    private HDD(String hDD) {
        this.hDD = hDD;
    }

    public String getHDDOption() {
        return hDD;
    }
}