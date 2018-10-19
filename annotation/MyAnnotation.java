/**
 * @Retention @Documented @Target @Inherited、
 * @Native @Repeatable
 */

import java.lang.annotation.*;

enum Consts {
    TRUE,
    FALSE
}

@Inherited
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface MyClass {
    String value() default "";
}

@Inherited
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface MyField {
    Consts value();
}

@Inherited
@Documented
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@interface MyParameter {
    Consts value();
}

@Inherited
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface MyMethod {
    Consts value();
}

@Inherited
@Documented
@Target(ElementType.CONSTRUCTOR)
@Retention(RetentionPolicy.RUNTIME)
@interface MyConstructor {

    Consts value();
    public int id() default -1;
    public String message() default "Hi";
}


@Documented
@Retention(RetentionPolicy.RUNTIME)
@interface MyRepeatableStorage {
    MyRepeatable[] value();
}

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(MyRepeatableStorage.class)
@interface MyRepeatable{
    String value();
}

@MyClass
public class MyAnnotation {

    @MyField(Consts.FALSE)
    private int number = 0;

    @MyMethod(Consts.FALSE)
    public MyAnnotation run () {
        System.out.println("void run (): " + this.number);
        return this;
    }

    @MyRepeatable("static")
    @MyRepeatable("instance")
    public static MyAnnotation instance() {
        return new MyAnnotation();
    }

    @MyConstructor(Consts.FALSE)
    public MyAnnotation(){
        this(0);
    }

    @MyConstructor(Consts.TRUE)
    public MyAnnotation(int number) {
        this.number = number;
    }

    public static void main (String args[]) {
        MyAnnotation instance = new MyAnnotation().run();
    }
}
