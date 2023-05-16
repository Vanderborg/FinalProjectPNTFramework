package lumaenums;

public enum Login {
    EMAIL("adamvanderborg@gmail.com"),
    PASSWORD("Panera76!");

    private final String login;

    private Login(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }
}
