class TestaCastArray {
    public static void main(String[] args) {
        String[] valores = new String[2];
        valores[0] = "Certificação";
        valores[1] = "Java";
        Object[] vals =  valores;
        vals[1] = "Daniela";

        System.out.println(vals[1]);
        System.out.println(valores[1]);
        System.out.println(vals[1].equals(valores[1]));

        for(Object valor : vals) {
            System.out.println(valor);
        }


        B[] valores2 = new B[2];
        valores2[0] = new B();;
        

        A[] vals2 = valores2;
        System.out.println(valores2.getClass().getName());
        System.out.println(vals2.getClass().getName());
       
        
    }
}

class A {

}

class B extends A {

}