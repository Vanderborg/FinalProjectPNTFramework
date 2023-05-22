package nopcommerceenums.computeroptions;

public enum OSOption {
    OS_OPTION_1("Vista Home [+$50.00]"),
    OS_OPTION_2("Vista Premium [+$60.00]");

    private final String oS;

    private OSOption(String oS) {
        this.oS = oS;
    }

    public String getOSOption() {
        return oS;
    }
}