import java.lang.annotation.*;
import java.lang.reflect.*;

@Test(2)
public class Index {

    @Test(3)
    public int a;

    public static void main (String args[]) {
        boolean exists = Index.class.isAnnotationPresent(Test.class);

        try {
            Class<?> index = Class.forName("Index");
            System.out.println(index);
        } catch (Exception e) {}

        try {
        
            Field a = Index.class.getField("a");
            Annotation xx = a.getAnnotation(Test.class);
            System.out.println(xx);
        } catch (Exception e) {}



        Test test = Index.class.getAnnotation(Test.class);

        System.out.println(test);

        System.out.println(exists);
    }
}


@Retention(RetentionPolicy.RUNTIME)
@interface Test {
    int value() default 1;
}
