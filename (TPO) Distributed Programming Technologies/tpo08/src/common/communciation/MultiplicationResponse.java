package common.communciation;

import java.io.Serializable;
import java.math.BigDecimal;

public class MultiplicationResponse implements Serializable {

    private BigDecimal multiplication;

    public MultiplicationResponse(BigDecimal multiplication) {
        this.multiplication = multiplication;
    }

    public BigDecimal getMultiplication() {
        return multiplication;
    }

    public void setMultiplication(BigDecimal multiplication) {
        this.multiplication = multiplication;
    }

    @Override
    public String toString() {
        return "multiplication = " + multiplication;
    }
}
