import java.util.ArrayList;

public class ArrayInitialize {
    public static void main(String[] args) {
        int[] arraya = new int[10];

        int arrayb[] = new int[10];

        //  int[] arrayc = new int[];

        //   int arrayd[] = new int[];

        //   int[] arraye = new int[2]{1, 2};

        int[] arrayf = new int[] { 1, 2 };

        //   int[] arrayg = int[10];

        //   int[] arrayh = new int[1, 2, 3];

        //   int arrayi[] = new int[1, 2, 3];

        int arrayj[] = { 1, 2, 3 };

        int zyx[][] = new int[3][10];
        int[] x = new int[20];
        int[] y = new int[10];
        int[] z = new int[30];

        System.out.println(zyx[2].length);

        zyx[0] = x;
        zyx[1] = y;
        zyx[2] = z;
        System.out.println(zyx[2].length);

        // int[][][] cubo = new int[][][]; 
        int[][][] cubo = new int[2][][];

        ArrayList<String> lista = new ArrayList<>();

        fora: for (int a = 0; a < 30; a++)
            for (int b = 0; b < 1; b++)
                if (a + b == 25)
                    continue fora;
                else if (a + b == 20)
                    break fora;
        if (a == 0)
            break fora;
        else
            System.out.println(a);

        fora: for (int a = 0; a < 30; a++)
            for (int b = 0; b < 1; b++)
                if (a + b == 25)
                    continue fora;
                else if (a + b == 20)
                    break;
                else
                    System.out.println(a);

        int a = args.length;
        int i = 0;
        switch (a) {
        case 0:
        case 1:
            for (i = 0; i < 15; i++, System.out.println(i))
                if (i == 5)
                    continue;
            if (i == 15)
                break;
        case 2:
            System.out.println("2");
        }
        System.out.println("fim");

    }
}