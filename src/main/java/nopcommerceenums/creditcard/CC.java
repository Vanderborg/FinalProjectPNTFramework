package nopcommerceenums.creditcard;

public enum CC {
    CC_NUMBER("6575647567754754754"),
    CC_CODE("6575");

    private final String ccCredentials;

    private CC(String ccNumber) {
        this.ccCredentials = ccNumber;
    }

    public String getCcCredentials(){
        return ccCredentials;
    }
}
