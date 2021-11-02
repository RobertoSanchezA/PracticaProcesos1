import java.io.*;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner intro = new Scanner(System.in);

        ProcessBuilder pc = new ProcessBuilder();
        pc.command("C:\\Program Files\\Mozilla Firefox\\firefox.exe");

        System.out.println("Introduce el numero de ventanas que quieres abrir");
        int windows = intro.nextInt();
        try{
            Process p = null;
            for (int i = 1; i <= windows; i++) {
                System.out.println("Iniciando proceso: " + i);
                p = pc.start();
            }
            while (p.isAlive()){
                p.waitFor();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Procesos cerrados");
    }
}
