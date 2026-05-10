package app;
   import java.io.IOException;
   import java.nio.file.Files;
   import java.nio.file.Path;
   import java.util.ArrayList;
   import java.util.List;

public class FajlBeolvasas {
    static List<Fuvar>fuvar = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        Path path = Path.of("fuvarrok.csv");
        String egyFuvar = Files.readString(path);
        System.out.println("fuvar = " + egyFuvar);
        List<String> rendek = Files.readAllLines(path);
        
        
        for(String rend : rendek ){
            String r[] = rend.split(";");
            String rsz=r[0];
            
        }
    
    }
   
}
