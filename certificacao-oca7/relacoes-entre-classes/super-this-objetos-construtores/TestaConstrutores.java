class B {
    B() {
        System.out.println("PAI");
    }
}

class A extends B {
    A(String s) {
        super();
        System.out.println("FILHO COM STRING");
    }

    A() {
        System.out.println("FILHO DEFAULT");
    }
    public static void main(String[] args) {
        new A("SDASDF");
    }

}

