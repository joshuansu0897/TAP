/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author joshuansu
 */
public class Tarea4 {

    static class MyThread implements Runnable {

        private final File path;

        public MyThread(String path) {
            this.path = new File(path);
        }

        @Override
        public void run() {
            FileReader fr;
            BufferedReader br;
            try {
                String line;
                fr = new FileReader(this.path);
                br = new BufferedReader(fr);

                int ln = 1;
                while ((line = br.readLine()) != null) {
                    System.out.printf("\u001B[34m%s(%d):\u001B[0m %s%n",this.path.getName(), ln++,line);
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new MyThread("./resources/file1.txt")).start();
        new Thread(new MyThread("./resources/file2.txt")).start();
    }

}
