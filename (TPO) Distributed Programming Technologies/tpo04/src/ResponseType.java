
public enum ResponseType {
    OK("OK"),
    MISSING_PARAMETER("missingParameters"),
    NAN_PARAMETER("wrongParameters");

    public String response;

    ResponseType(String response) {
        this.response = response;
    }
}
