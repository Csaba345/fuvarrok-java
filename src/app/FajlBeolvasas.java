package app;
   import java.io.IOException;
   import java.nio.file.Files;
   import java.nio.file.Path;
   import java.util.ArrayList;
   import java.util.List;

public class FajlBeolvasas {
    static List<Fuvar>fuvarok = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        Path path = Path.of("fuvarrok.csv");
        String egyFuvar = Files.readString(path);
        System.out.println("fuvar = " + egyFuvar);
        List<String> rendek = Files.readAllLines(path);
        
        
        for(String rend : rendek ){
            String r[]=rend.split(";");
            String rsz = r[0];
            int idomp = Integer.parseInt(r[1]);
            int osszeg = Integer.parseInt(r[2]);
            String fitmod = r[3];
            Fuvar fuvar = new Fuvar(rsz, idomp, osszeg, fitmod);
            fuvarok.add(fuvar);
        }
        feladtok();
    
    }

    private static void feladtok() {
        final int N = fuvarok.size();
        int i = 0;

        while (i < N && fuvarok.get(i).getFitmod().equals("igen")) {
            i++;
        }

        String valasz = i >= N ? "igen" : "nem";
        System.out.println("Minden fuvar fitmod értéke 'igen': " + valasz);
        }
 }
   

