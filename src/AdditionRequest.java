import java.io.Serializable;
import java.math.BigInteger;

public class AdditionRequest implements Serializable {
    public final int parm1;
    public final int parm2;

    public AdditionRequest(int parm1, int parm2) {
        this.parm1 = parm1;
        this.parm2 = parm2;
    }

    @Override
    public String toString() {
        return "AdditionRequest{" +
                "parm1=" + parm1 +
                ", parm2=" + parm2 +
                '}';
    }
}
