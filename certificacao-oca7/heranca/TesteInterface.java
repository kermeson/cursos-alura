interface Z {}
interface W {}
interface Y extends Z, W {}
class B {}
class C extends B implements Y {}
class D extends B implements Z, W {}
class E extends C {}
class A {
    public static void main(String[] args) {
      //  D d = (D) (Y) (B) new D();

        System.out.println(((B) (Z) (W) (Y) new C()) instanceof C);
    }
}