import java.math.BigDecimal;
public class Model {
    private BigDecimal result;
    private final ResponseType respType;
    public Model(ResponseType respType) {
        this.respType = respType;
    }
    public BigDecimal getResult() {
        return result;
    }
    public void setResult(BigDecimal result) {
        this.result = result;
    }
    public ResponseType getRespType() {
        return respType;
    }
}
