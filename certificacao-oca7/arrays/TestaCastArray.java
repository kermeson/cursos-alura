class TestaCastArray {
    public static void main(String[] args) {
        String[] valores = new String[2];
        valores[0] = "Certificação";
        valores[1] = "Java";
        Object[] vals = (Object[]) valores;
        vals[1] = "Daniela";

        System.out.println(vals[1]);
        System.out.println(valores[1]);
        System.out.println(vals[1].equals(valores[1]));


        Object[] valores2 = new Object[2];
        valores[0] = "Certificação";
        valores[1] = "Java";
        String[] vals2 = (String[]) valores2;
        for(Object valor : vals2) {
            System.out.println(valor);
        }

       
        
    }
}