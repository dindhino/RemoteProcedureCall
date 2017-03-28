
import org.apache.xmlrpc.*;

public class JavaServer {

    public Integer tambah(int x, int y) {
        return new Integer(x + y);
    }

    public Integer kurang(int x, int y) {
        return new Integer(x - y);
    }

    public String bagi(int x, int y) {
        if (y != 0) {
            return String.valueOf((float) x / (float) y);
        } else {
            if (x == 0) {
                return "Tak Terdefinisi";
            } else {
                return "Tak Terhingga";
            }
        }
    }

    public Integer kali(int x, int y) {
        return new Integer(x * y);
    }

    public static void main(String[] args) {

        try {

            System.out.println("Attempting to start XML-RPC Server...");

            WebServer server = new WebServer(8888);
            server.addHandler("sample", new JavaServer());
            server.start();

            System.out.println("Started successfully.");
            System.out.println("Accepting requests. (Halt program to stop.)");

        } catch (Exception exception) {
            System.err.println("JavaServer: " + exception);
        }
    }
}
