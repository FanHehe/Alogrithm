import java.lang.reflect.*;

interface IHuman {
    public void say ();
    public void hello ();
}


public class MyProxy implements InvocationHandler {

    IHuman target = null;

    public MyProxy (IHuman target) { this.target = target; }


    public Object invoke(Object proxy, Method method, Object[] args)  throws Exception {


        // System.out.println(proxy);
        // System.out.println(this.target);
        if (method.getName().equalsIgnoreCase("say")) System.out.println("haha\n");

        return method.invoke(this.target, args);
    }


    public static void main (String[] args) {

         IHuman man = new Man();

         MyProxy proxy = new MyProxy(man);

         IHuman manProxy = (IHuman)Proxy.newProxyInstance(man.getClass().getClassLoader(), man.getClass().getInterfaces(), proxy);

         manProxy.say();
         manProxy.hello();

    }
}

class Man implements IHuman {
    public void say () {
        System.out.println("say");
    }

    public void hello () {
        System.out.println("hello");
    }
}
