package common.communciation;

import java.io.Serializable;

public class EchoResponse implements Serializable {

    private String response;

    public EchoResponse(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "\"" + response + "\"";
    }
}
