import java.io.*;

public class Test {
    public static void main (String args[]) {
        try {
            var a = 1 / 0;
        } catch (Exception e) {
            System.out.println(e);
            System.out.print("===============\n");
            e.printStackTrace();
            System.out.print("===============\n");
            e.printStackTrace(new PrintWriter(new StringWriter()));
        }

    }
}
