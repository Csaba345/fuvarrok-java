package app;



public class Fuvar {

    private  String rsz;
    private int idomp;
    private int osszeg;
    private String fitmod;
    
    public Fuvar(String rsz, int idomp, int osszeg, String fitmod) {
        this.rsz = rsz;
        this.fitmod = fitmod;
        this.idomp=idomp;
        this.osszeg=osszeg;
    }
    public String getRsz(){
        return rsz;
    }
    public String getFitmod(){
        return fitmod;
    }
    public int getIdomp(){
        return idomp;
    }
    public int getOsszeg(){
        return osszeg;
    }
}
