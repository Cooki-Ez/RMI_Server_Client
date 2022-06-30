import java.io.Serializable;
import java.math.BigInteger;

public class AdditionResponse implements Serializable {
    public final int sum;

    public AdditionResponse(int x, int y) {
        sum = responseAddition(x, y);
    }

    public int responseAddition(int x, int y) {
        if (x != 0 && y != 0) return x+y;
        else if (x != 0 && y == 0) return x;
        else if (y != 0 && x == 0) return y;
        else return 0;
    }

    @Override
    public String toString() {
        return "AdditionResponse{" +
                "sum=" + sum +
                '}';
    }
}
