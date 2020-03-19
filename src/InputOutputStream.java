import java.io.*;

public class InputOutputStream {
    public static void main(String[] args) {
        try (OutputStream outputStream = new FileOutputStream("src/source")) {
            int l = 12022;
            byte[] value1 = new byte[4];
            for (int k = 0; k < value1.length; k++) {
                value1[k] = (byte) (l >> (3 - k) * 8);
                outputStream.write(value1[k]);
            }
            char i = 'з';
            byte[] value2 = new byte[2];
            for (int k = 0; k < value2.length; k++) {
                value2[k] = (byte) (i >> (1 - k) * 8);
                outputStream.write(value2[k]);
            }
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (InputStream inputStream = new FileInputStream("src/source")) {
            int c = 0;
            c += inputStream.read() << 24;
            c += inputStream.read() << 16;
            c += inputStream.read() << 8;
            c += inputStream.read();
            int b = 0;
            b += inputStream.read() << 8;
            b += inputStream.read();
            System.out.println(c);
            System.out.println((char)b);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
