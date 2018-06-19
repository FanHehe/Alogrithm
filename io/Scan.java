import java.io.File;
import java.util.stream.Stream;
import java.io.IOException;
import static java.lang.System.out;

public class Scan {
    public static void main (String args[]) {

        try {
            var pwd = new File(".");

            find(pwd, 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void find (File dir, int depth) {

        if (depth <= 0) return ;

        if (dir.isFile()) out.println(dir.getName());
        if (dir.isDirectory() == false) out.println(dir.getAbsolutePath());

        

        File[] files = dir.listFiles();

        Stream.of(files).forEach(item -> {

            if (item.isFile()) { out.println(item.getName()); return ; }

            find(item, depth - 1);
        });
    }
}
