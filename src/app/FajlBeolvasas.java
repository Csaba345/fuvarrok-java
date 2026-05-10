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
    private static void osszeszFuvar(){
        int fuv =0;
        for(Fuvar f : fuvarok){
            fuv += f.getOsszeg();
        }
        System.out.println("Összes fuvar értéke: " + fuv);
    }
//2.feladat
    private static void legdragabbRendszam(){
        int max = fuvarok.get(0).getOsszeg();
        String rsz = fuvarok.get(0).getRsz();
        
        for(Fuvar f : fuvarok){
            if(f.getOsszeg() > max){
                max = f.getOsszeg();
                rsz = f.getRsz();
            }
        }
        System.out.println("Legdrágább fuvar rendszáma: " + rsz);
    }
// 3.feladat
    private static void legolcsobb(){
        int min = fuvarok.get(0).getOsszeg();
        
        for(Fuvar f : fuvarok){
            if(f.getOsszeg() < min){
                min = f.getOsszeg();
            }
        }
        System.out.println("Legolcsób fuvar forintban: " + min);
    }
// 4.feladat
    private static void hanyKartyas(){
        int db = 0;
        
        for(Fuvar f : fuvarok){
            if(f.getFitmod().equals("kartya")){
                db++;
            }
        }
        System.out.println("Hány kártyás fizetés volt: " + db);
    }
    
// 5.feladat
    private static void mindenFitmod(){
        int i =0;
        final int N = fuvarok.size();
        
        while (i < N && !fuvarok.get(i).getFitmod().equals("")){
            i++;
        } 
        String valasz = "nem";
        if(i >=N){
            valasz = "igen";
        }
        System.out.println("Minden fizetési mód meghatároozott: " + valasz);
    }
// 6.feladat
    private static void hanyDBAuto() {
        String[] rendszamok = new String[fuvarok.size()];
        int db = 0;
        for(Fuvar f : fuvarok){
            String rsz = f.getRsz();
            boolean benneVan = false;
            
            for(int i=0;i < db; i++){
                if(rendszamok[i].equals(rsz)){
                    benneVan = true;
                }
            }
            if(!benneVan){
                rendszamok[db]= rsz;
                db++;
            }
        }
        System.out.println("Hány darab autó van a rendszerben: "+db);
    }
 }
   

