package nopcommerce.nopcommerceenums.sql;

public enum SQLInjection {

    SQL_INJECTION("' OR 1=1;");

    private final String sql;

    private SQLInjection(String sql) {
        this.sql = sql;
    }

    public String getSQL() {
        return sql;
    }
}
