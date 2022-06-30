import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class Reader {

    static final String READ_ONLY_MODE = "rw";
    static final int INTEGER_LENGTH = 32;

    public static void main(String[] args) throws IOException {

        // our mapped byte buffer with file channel
        MappedByteBuffer mappedByteBuffer;
        File textFile = new File("textFile.txt");
        RandomAccessFile randomAccessFile = new RandomAccessFile(textFile, READ_ONLY_MODE);
        FileChannel fileChannel = randomAccessFile.getChannel();


        try {
            mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, INTEGER_LENGTH);

            while (true) {
                if (mappedByteBuffer.getInt() == 1)
                {
                    mappedByteBuffer.putInt(0, 0);
                    int value1 = mappedByteBuffer.getInt();
                    int value2 = mappedByteBuffer.getInt();

                    int sum = value1 + value2;
                    System.out.println("The sum: " + sum);


                    mappedByteBuffer.rewind();
                }

                mappedByteBuffer.rewind();

            }
        } catch (IIOException iioex) {


            System.err.println("There is something went wrong while reading the buffer...");
            iioex.printStackTrace();
        }
    }
}
