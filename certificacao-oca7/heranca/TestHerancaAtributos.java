public class TestHerancaAtributos {
    final String name = "c";

   public TestHerancaAtributos () {
       System.out.println(b());
   }
   public int a() {
       return b();
   }

   public int b() {
       return 0;
   }
}

class B  extends TestHerancaAtributos {
    final String name = "b";

    public int a() {
        return b();
    }

    public int b() {
        return 2;
    }

    public static void main(String[] args) {
        B b = new B();
        System.out.println(b.name);
       // System.out.println(((TestHerancaAtributos) b).name);
        //System.out.println(b.a());
        //System.out.println(((TestHerancaAtributos) b).a());

    }
}

