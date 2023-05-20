package nopcommerceenums.datesoptions;

public enum Month {
    January("January"),
    February("February"),
    March("March"),
    April("April"),
    May("May"),
    June("June"),
    July("July"),
    August("August"),
    September("September"),
    October("October"),
    November("November"),
    December("December");

    private final String stringValue;

    private Month(String monthValue) {
        this.stringValue = monthValue;
    }

    public String getMonthValue() {
        return stringValue;
    }
}
