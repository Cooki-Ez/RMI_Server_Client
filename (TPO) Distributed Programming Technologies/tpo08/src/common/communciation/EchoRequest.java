package common.communciation;

import java.io.Serializable;

public class EchoRequest implements Serializable {

    private String request;

    public EchoRequest(String request) {
        this.request = request;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    @Override
    public String toString() {
        return "\"" + request + "\"";
    }
}
