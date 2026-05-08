package app;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Fuvarrok {

    private  String rsz;
    private int idomp;
    private int osszeg;
    private String fitmod;
    public static void main(String[] args) {
        Path path = Path.of("fuvarrok.csv");
        String fuvarok = Files.readString(path);
        
        System.out.println("fuvarok = " + fuvarok);
        
        List<String> rend = Files.readAllLines(path);
        for(String )
    }
    
}
