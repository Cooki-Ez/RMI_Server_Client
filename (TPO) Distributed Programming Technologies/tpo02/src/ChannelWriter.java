import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Objects;

public interface ChannelWriter {
    default void doWrite(ByteBuffer buffer, ByteBuffer buffer2, SocketChannel channel) throws IOException {



        if (Objects.isNull(buffer) || Objects.isNull(channel)){
            throw new IllegalArgumentException("Required Buffer and Channel!");
        }



        while (buffer.hasRemaining() == true){
            channel.write(buffer);
        }
    }
}