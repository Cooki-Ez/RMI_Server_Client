
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Random;

public class Writer {

    static final String READ_WRITE_MODE = "rw";
    static final int INTEGER_LENGTH = 32;

    public static void main(String[] args) throws IOException {

        // here, we have our random access file generator with mapped byte buffer and file channel
        MappedByteBuffer mappedByteBuffer;
        File textFile = new File("textFile.txt");
        RandomAccessFile randomAccessFile = new RandomAccessFile(textFile, READ_WRITE_MODE);
        FileChannel fileChannel = randomAccessFile.getChannel();

        // this is needed to generate a random number for the buffer
        Random randomNumberGenerator = new Random();

        try {
            mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, INTEGER_LENGTH);
            mappedByteBuffer.clear();

            while (true) {
                if (mappedByteBuffer.getInt() == 0) {
                    if(mappedByteBuffer != null) {

                        int value1 = randomNumberGenerator.nextInt(342);
                        int value2 = randomNumberGenerator.nextInt(457);
                        int temp = value1 + value2;
                        System.out.println("value1: " + value1);
                        System.out.println("value2: "+ value2);
                        System.out.println(temp);

                        mappedByteBuffer.putInt(value1);
                        mappedByteBuffer.putInt(value2);

                        mappedByteBuffer.clear();
                        mappedByteBuffer.putInt(1);
                    }
                }


                mappedByteBuffer.rewind();
            }
        } catch (IOException ioex) {
            System.err.println("Oops! Lookes like there is something wrong in this code...");
            ioex.printStackTrace();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException iex) {
            System.err.println("The process has been interrupted!");
            iex.printStackTrace();
        }
    }
}
