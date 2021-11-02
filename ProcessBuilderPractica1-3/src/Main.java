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


        System.out.println("Introduce el numero de ventanas que quieres abrir");
        String filePath = intro.nextLine();
        //No se si seria algo asi, porque no se como sacar la salida de ese comando por pantalla
        pc.command("powershell.exe","cat", filePath, "|", "wc", "-l");
        Process p = null;
        try{
            File file = new File(filePath);
            if (file.exists()){
               p = pc.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
