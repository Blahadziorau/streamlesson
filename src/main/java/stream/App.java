package stream;

import java.io.*;
import java.util.Arrays;

public class App {
    private static final String PATH = "C:\\Users\\Java.Rollershopby-ПК\\Desktop\\12.txt";

    public static void main(String[] args) { /*   OutputStream stream= null;
        try {
       stream=  new FileOutputStream(PATH);
       System.setOut(new PrintStream(stream));
        for (byte i = 0; i <Byte.MAX_VALUE; i++) {
            System.out.println(i+"t\n");
        }

        stream.flush();

          }catch(FileNotFoundException e){
        e.printStackTrace();
    }catch(IOException e){
        e.printStackTrace();
    }*/
        File file = new File(PATH);
        InputStream inputStream = null;
        byte[] buffer= new byte[11];
        try {
            inputStream = new FileInputStream(file);
            while (inputStream.available() > 0) {
               //fill buffer
               int i= inputStream.read(buffer);
                System.out.println(i);
                System.out.println(Arrays.copyOfRange(buffer,0,i) );
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeClosable(inputStream);
        }
    }

    private static void closeClosable(Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

