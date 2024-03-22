import controller.LibreriaController;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        LibreriaController objLibreriaController = new LibreriaController();

        String option ="";

        do {
            option = JOptionPane.showInputDialog("""
                    1. Menú de Autores.
                    2. Menú de libros.
                    3. Exit
                    
                    Choose an option:""");

            switch (option){
                case "1":
                    LibreriaController.menuAuthors();

            }

        }while (!option.equals("3"));

    }
}