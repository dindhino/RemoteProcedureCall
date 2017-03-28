
import java.util.*;
import org.apache.xmlrpc.*;

public class JavaClient {

    public static void main(String[] args) {

        try {
            XmlRpcClient server = new XmlRpcClient("http://localhost:8888/RPC2");
            Vector params = new Vector();
            params.addElement(new Integer(17));
            params.addElement(new Integer(13));

            Object hasil = server.execute("sample.tambah", params);
            System.out.println("Hasil penjumlahan " + params + " adalah " + ((Integer) hasil).intValue());

            hasil = server.execute("sample.kurang", params);
            System.out.println("Hasil pengurangan " + params + " adalah " + ((Integer) hasil).intValue());

            hasil = server.execute("sample.bagi", params);
            System.out.println("Hasil pembagian " + params + " adalah " + ((String) hasil));

            hasil = server.execute("sample.kali", params);
            System.out.println("Hasil perkalian " + params + " adalah " + ((Integer) hasil).intValue());
            
            Scanner scan = new Scanner(System.in);
            Vector inputan = new Vector();
            Vector param = new Vector();
            int inp = 0;
            param.addElement(inp);
            param.addElement(inp);
            System.out.print("Banyaknya bilangan: ");
            int n = scan.nextInt();
            for (int i=1; i<=n; i++) {
                System.out.print("Bilangan ke-"+i+": ");
                inp = scan.nextInt();
                inputan.addElement(inp);
                param.setElementAt(inp, 1);
                hasil = server.execute("sample.tambah", param);
                param.setElementAt(hasil, 0);
//                System.out.println(param);
            }
            System.out.println("Hasil penjumlahan " + inputan + " adalah " + ((Integer) hasil).intValue());
            
        } catch (Exception exception) {
            System.err.println("JavaClient: " + exception);
        }
    }
}
