import java.io.*;

class X {
    InputStream y() throws FileNotFoundException {

        return new FileInputStream("a.txt");

    }

    void z() throws FileNotFoundException {
        InputStream is = y();
        is.close();
    }

}