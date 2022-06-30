package common.communciation;

import java.io.Serializable;
import java.math.BigDecimal;

public class MultiplicationRequest implements Serializable {

    private BigDecimal parameter1;
    private BigDecimal parameter2;

    public MultiplicationRequest(BigDecimal parameter1, BigDecimal parameter2) {
        this.parameter1 = parameter1;
        this.parameter2 = parameter2;
    }

    public BigDecimal getParameter1() {
        return parameter1;
    }

    public void setParameter1(BigDecimal parameter1) {
        this.parameter1 = parameter1;
    }

    public BigDecimal getParameter2() {
        return parameter2;
    }

    public void setParameter2(BigDecimal parameter2) {
        this.parameter2 = parameter2;
    }

    @Override
    public String toString() {
        return "parameter1 = " + parameter1 + " parameter2 = " + parameter2;
    }
}
