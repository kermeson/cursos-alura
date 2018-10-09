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


        B[] valoresB = new B[2];
        valoresB[0] = new B();;
        

        A[] valoresA = valoresB;
        System.out.println(valoresB.getClass().getName());
        System.out.println(valoresA.getClass().getName());

        System.out.println(valoresA.equals(valoresB));

        A[] valsA = new A[2];
        B[] valsB = (B[])valsA;
       
        
    }
}

class A {

}

class B extends A {

}