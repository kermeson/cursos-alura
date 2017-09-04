
class TestaArray {
    public static void main(String[] args) {
        int x[] = new int[3];
        for(x[1]=x.length-1;x[1]>=0;x[1]--) {
            x[x[1]]=-5;
            System.out.println(x[1]);
        }
    }
}