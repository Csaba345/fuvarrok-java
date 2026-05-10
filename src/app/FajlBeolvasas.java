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
    
//1.feladat
    private static int osszeszFuvar(){
        int fuv =0;
        for(Fuvar f : fuvarok){
            fuv += f.getOsszeg();
        }
        return fuv;
    }
//2.feladat
    private static String legdragabbRendszam(){
        int max = fuvarok.get(0).getOsszeg();
        String rsz = fuvarok.get(0).getRsz();
        
        for(Fuvar f : fuvarok){
            if(f.getOsszeg() > max){
                max = f.getOsszeg();
                rsz = f.getRsz();
            }
        }
        return rsz;
    }
// 3.feldat
    private static int legolcsobb(){
        int min = fuvarok.get(0).getOsszeg();
        
        for(Fuvar f : fuvarok){
            if(f.getOsszeg() < min){
                min = f.getOsszeg();
            }
        }
        return min;
    }
    
 }
   

