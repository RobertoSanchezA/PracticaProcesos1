
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Scanner intro = new Scanner(System.in);

        ArrayList<Process> arrayPid = new ArrayList<Process>();
        ProcessBuilder pc = new ProcessBuilder();
        pc.command("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");

        System.out.println("Introduce el numero de ventanas que quieres abrir");
        int windows = intro.nextInt();
        try{
            Process p = null;
            for (int i = 1; i <= windows; i++) {
                System.out.println("Iniciando proceso: " + i);
                p = pc.start();
                arrayPid.add(p);
                System.out.println("Añadido con PID: " + p.pid());
            }
            for (int i = 0; i < arrayPid.size(); i++) {
                //Aqui deberia para el proceso durante 500 milisegundos y despues borrarlo
                p.waitFor(500, TimeUnit.MILLISECONDS);
                p.destroy();
                System.out.println("Proceso parado");
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}
