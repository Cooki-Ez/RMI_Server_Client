import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Objects;

public final class EchoClient implements ChannelWriter {

    private final InetSocketAddress hostAddress;

    public static void main(final String[] args) {

        if (args.length < 2) {
            throw new IllegalArgumentException("Expected arguments are port number and messages!");
        }

        new EchoClient(Integer.valueOf(args[0])).start( args[1],args[2]);

    }

    private EchoClient(final int port) {
        this.hostAddress = new InetSocketAddress(port);
    }

    private void start( String message1, String message2) {

        // this String.isNotEmpty() => checks if the passed string value is empty or not
        assert StringUtils.isNotEmpty(message1);
        assert StringUtils.isNotEmpty(message1);


        // wrapping the messages into buffers and writing the buffers into channel
        try (SocketChannel client = SocketChannel.open(this.hostAddress)) {
            ByteBuffer buffer1 = ByteBuffer.wrap((message1 + ":END").trim().getBytes());
            ByteBuffer buffer2 = ByteBuffer.wrap((message1 + ":END").trim().getBytes());
            doWrite(buffer1,buffer2, client);
            buffer1.flip();
            final StringBuilder echo = new StringBuilder();
            doRead(echo, buffer1, buffer2,client);

            // this string is the result after appending those two messages
            String result = message1+message1;

            // here we can parse the values to integer and add them together
            int _message1 = Integer.parseInt(message1);
            int _message2 = Integer.parseInt(message1);
            int sum= _message1 + _message2;

            System.out.println(String.format("Echo messages: %s \nResult: %s\nJoined string: %s\n",
                                                echo.toString().replace(":END", " "),sum, result));



            System.out.println("The operation has finished successfully!");
        } catch (IOException e) {



            throw new RuntimeException("Oops! An error occurred whilst trying to communicate with the server.", e);
        }
    }

    private void doRead( StringBuilder data, ByteBuffer buffer,ByteBuffer buffer2, SocketChannel channel) throws IOException {

        // checking if the passed parameters are null or not
        assert !Objects.isNull(data) && !Objects.isNull(buffer) && !Objects.isNull(channel);
        assert !Objects.isNull(buffer2);

        while ((channel.read(buffer) & channel.read(buffer2) )!= -1) {
            data.append(new String(buffer.array()).trim());
            data.append(new String(buffer2.array()).trim());




            // clearing the buffers
            buffer.clear();
            buffer2.clear();
        }
    }
}
