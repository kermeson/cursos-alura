public class TestSobrecarga {
    void method(Object o, String s) {
        System.out.println("object");
    }

    void method(String s, Object o) {
        System.out.println("string");
    }

    public static void main(String[] args) {
        new Xpto().method("string", "string");
    }
}