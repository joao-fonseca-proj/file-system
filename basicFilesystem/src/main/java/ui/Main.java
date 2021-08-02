package ui;

import domain.Filesystem.Filesystem;
import service.DiretorioAtualService;
import service.InterpretadorComandos;

import java.util.Scanner;

public class Main {
    /**
     * Main
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Filesystem s = new Filesystem();
        DiretorioAtualService sv = new DiretorioAtualService();
        sv.mudarDiretorioSeguinte(s.root());
        InterpretadorComandos cmdInterpretador = new InterpretadorComandos(sv);
        String cmd = "";

        System.out.println(Menu.header());
        System.out.println(Menu.help());
        while(!cmd.equalsIgnoreCase("Exit")) {
            System.out.println(sv.oldPath + ": ");
            cmd = scan.nextLine();
            System.out.println(cmdInterpretador.comandoToAction(cmd));
        }
    }
}
