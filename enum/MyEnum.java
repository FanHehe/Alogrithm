enum MyOperation {
    ADD ("+") {
        public int exec (int a, int b) { return a + b; }
    },
    SUB ("-") {
        public int exec (int a, int b) { return a - b; }
    };

    String value;

    private MyOperation (String _value) { this.value = _value; }

    public String getValue (String value) { return this.value;}
    
    public abstract int exec (int a, int b);
}

public class MyEnum {

      public static void main (String[] args) {
            System.out.println(MyOperation.ADD.exec(1, 2));
      }

}
