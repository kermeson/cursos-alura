class B {
   static int x = 1;
}
class A extends B {
    static int x = 2;
    public static void main(String[] args) {
        System.out.println(super.x);
    }
}