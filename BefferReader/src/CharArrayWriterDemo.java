import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
 
public class ----------------------- {
 
    public static void main(String args[]) throws IOException {
 
        char[] c = { 'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd', '!' };
        CharArrayWriter out = new CharArrayWriter();
 
        out.write(c);
 
        File dir = new File("C:/test");
        dir.mkdirs();
 
        FileWriter f1 = new FileWriter(new File("C:/test/a.txt"));
 
        // Write data of 'out' to 'f1'.
        out.writeTo(f1);
 
        FileWriter f2 = new FileWriter(new File("C:/test/b.txt"));
 
        // Write data of 'out' to 'f2'.
        out.writeTo(f2);
 
        f1.close();
        f2.close();
 
        // Close CharArrayWriter 'out'.
        out.close();
 
        FileWriter f3 = new FileWriter(new File("C:/test/c.txt"));
 
        // With CharArrayWriter, after close.
        // writeTo(..) method no longer works.
        // Also does not cause an exception if you use writeTo (..).
        out.writeTo(f3);
 
        System.out.println("Done!");
    }
}