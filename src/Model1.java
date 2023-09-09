public class Model1 {
    private String value;
    private TokenType1 type;

    public Model1(String value, TokenType1 type) {
        this.value = value;
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public TokenType1 getType() {
        return type;
    }
}
