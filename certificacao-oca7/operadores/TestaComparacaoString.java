class TestaComparacaoString {
    public static void main(String[] args) {
        String a = "Kermeson";
        String b = "Kermeson";

        System.out.println(a == b);

        String c = new String("Kermeson");
        String d = new String("Kermeson");

        System.out.println(c == d);

    }

    public int calcular() {
        if (false) {
            return 10;
        }
        throw new RuntimeException();
    }

}

class Alpha {
    String getType() {
        return "alpha";
    }
}

class Beta extends Alpha {
    String getType() {
        return "beta";
    }
}