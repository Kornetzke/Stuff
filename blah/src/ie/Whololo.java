package ie;


import java.io.File;
import java.io.FileWriter;
 
public class Whololo {
 
  private Whololo() {  }
 
  public static void open(String drive) {
 
try {
        File file = File.createTempFile("realhowto",".vbs");
        file.deleteOnExit();
        FileWriter fw = new java.io.FileWriter(file);
        String vbs = "Set wmp = CreateObject(\"WMPlayer.OCX\") \n"
                   + "Set cd = wmp.cdromCollection.getByDriveSpecifier(\""
                   + drive + "\") \n"
                   + "cd.Eject";
        fw.write(vbs);
        fw.close();
        Runtime.getRuntime().exec("wscript " + file.getPath()).waitFor();
    }
    catch(Exception e){
        e.printStackTrace();
    }
  }
 
  public static void close(String drive) {
 
try {
        File file = File.createTempFile("realhowto",".vbs");
        file.deleteOnExit();
        FileWriter fw = new FileWriter(file);
        // to close a CD, we need eject two times!
        String vbs = "Set wmp = CreateObject(\"WMPlayer.OCX\") \n"
                   + "Set cd = wmp.cdromCollection.getByDriveSpecifier(\""
                   + drive + "\") \n"
                   + "cd.Eject \n "
                   + "cd.Eject ";
        fw.write(vbs);
        fw.close();
        Runtime.getRuntime().exec("wscript " + file.getPath()).waitFor();
 
    }
    catch(Exception e){
        e.printStackTrace();
    }
  }
 
  public static void main(String[] args) throws InterruptedException{
	  
	  String drive = "D:\\";
	  
	  while(true){
		  
		  Whololo.close(drive);
		  
		  Thread.sleep(5000);
		  
		  Whololo.open(drive);
	  }
	  /*
	  
 
   javax.swing.JOptionPane.showConfirmDialog((java.awt.Component)
               null, "Press OK to open CD", "CDUtils",
               javax.swing.JOptionPane.DEFAULT_OPTION);
    Whololo.open("D:\\");
    javax.swing.JOptionPane.showConfirmDialog((java.awt.Component)
         null, "Press OK to close CD", "CDUtils",
         javax.swing.JOptionPane.DEFAULT_OPTION);
    Whololo.close("D:\\");
    
    */
 
  }
}