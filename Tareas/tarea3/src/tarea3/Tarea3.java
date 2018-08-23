/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author joshuansu
 */
public class Tarea3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for (String arg : args) {
            download(arg);
        }
        preguntarURL();
    }

    private static void preguntarURL() {
        String url = JOptionPane.showInputDialog("URL", null);
        if (url != null) {
            download(url);
            preguntarURL();
        }
    }

    private static void download(String strUrl) {
        URL url;
        InputStream is = null;
        BufferedReader br;
        String htmlCode;

        try {
            url = new URL(strUrl);
            is = url.openStream();
            br = new BufferedReader(new InputStreamReader(is));

            String line;
            htmlCode = "";
            while ((line = br.readLine()) != null) {
                htmlCode += line + "\n";
            }

            String path = chooseDir();
            saveFile(path, htmlCode);

        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
            JOptionPane.showMessageDialog(null, "ERROR AL DESCARGAR DEL code :" + strUrl);
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (Exception e) {
                System.out.println("Error al cerrar:" + e.getMessage());
            }
        }
    }

    private static String chooseDir() {
        JFileChooser jd = new JFileChooser();
        jd.setDialogTitle("Donde desea guardar el codigo HTML?");
        int returnVal = jd.showSaveDialog(null);
        
        if (returnVal != JFileChooser.APPROVE_OPTION) {
            return null;
        }
        
        return jd.getSelectedFile().toString();
    }

    private static void saveFile(String path, String txt) {
        
        if (path == null) {
            return;
        }
        
        try {
            File file = new File(path);
            try (BufferedWriter out = new BufferedWriter(new FileWriter(file))) {
                out.write(txt);
            }
        } catch (IOException ex) {
            System.out.println("Error al guardar:" + ex.getMessage());
        }
        
    }

}
