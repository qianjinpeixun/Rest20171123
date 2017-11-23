package jpgDemo;

import java.awt.image.*;
import java.io.*;
import java.util.*;

import javax.imageio.*;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.pdmodel.*;

public class ConverPDFToJpg {

    public static void main(String[] args) {
        
        File f=new File("C:/temp/roaming_notification/welcome-111.txt");
        String s="19028154962,302270010018252,232 ,Austria                       ,2017-09-05 08:45:45                                     ";
        
        try {
            FileWriter w=new FileWriter(f);
            PrintWriter p=new PrintWriter(w);
            p.println(s);
            System.out.println("line1");
            Thread.sleep(2*60*1000);
            p.println(s);
            p.close();
            w.close();
            
            System.out.println("line2");

        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
        
        
    }
    

}
