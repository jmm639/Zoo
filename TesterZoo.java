package _07POO_Zoo;

import java.util.Scanner;

public class TesterZoo {

    // ***************************
    // ***************************
    // Código principal del tester
    // ***************************
    // ***************************
    public static void main(String[] args) {
        // Me creo un zoo para jugar una E/S
        Zoo zoo = new Zoo(18);
        ZooES menu = new ZooES();

        // Proceso las opciones y el menú
        menu.gestionMenu(zoo);
    }
}