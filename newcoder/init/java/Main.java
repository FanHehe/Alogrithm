import java.util.Arrays;
import java.lang.Comparable;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.stream.Stream;



public class Main {
    public static void main(String args[]) {
        System.out.println(Main.<String>indexOf(new String[]{"1", "2", "3"}, "3"));
        System.out.println(Main.<String>indexOf(new String[]{"1", "2", "3"}, "-1"));
    }

    public static <T extends Comparable<T>> int indexOf(T[] array, T item) {

        // 法一：


        for (int i = 0; i < array.length; i++) {
            if (item.compareTo(array[i]) == 0) {
                return i;
            }
        }

        return -1;


        // ------------------------------
        // 法二：

        // LinkedList<T> list = new LinkedList<T>(Arrays.asList(array));

        // Iterator<T> iterator = list.iterator();

        // int i = 0;
        // while(iterator.hasNext()) {
        //     if (item.compareTo((T)iterator.next()) == 0) {
        //         return i;
        //     }
        //     i++;
        // }

        // return -1;

        // ------------------------------

        // LinkedList<T> list = new LinkedList<T>(Arrays.asList(array));

        // int i = 0;
        // for (T value: list) {
        //     if (item.compareTo(value) == 0) {
        //         return i;
        //     }
        //     i++;
        // }
        // return -1;

        // ------------------------------
    }
}
