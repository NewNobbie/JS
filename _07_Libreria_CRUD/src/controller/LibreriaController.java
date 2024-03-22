package controller;

import entity.Autores;
import model.LibreriaModel;

import javax.swing.*;

public class LibreriaController {

    public static void getAllAutores() {
        LibreriaModel objModel = new LibreriaModel();
        String listAutores = "AUTHOR LIST \n";

        for (Object iterador : objModel.findAllAutors()) {
            //Obj to coder convert
            Autores objAutor = (Autores) iterador;
            listAutores += objAutor.toString() + "\n";
        }

        JOptionPane.showMessageDialog(null, listAutores);
    }

    public static String getAllAutoresStr() {
        LibreriaModel objModel = new LibreriaModel();
        String listAutores = "AUTHOR LIST \n";

        for (Object iterador : objModel.findAllAutors()) {
            //Obj to coder convert
            Autores objAutor = (Autores) iterador;
            listAutores += objAutor.toString() + "\n";
        }

        return listAutores;
    }

    public static void createAutor() {
        LibreriaModel objLibreriaModel = new LibreriaModel();

        String name = JOptionPane.showInputDialog("Insert name");
        String nacionalidad = JOptionPane.showInputDialog("Insert Nacionalidad");

        Autores objAutor = new Autores();
        objAutor.setName(name);
        objAutor.setNacionalidad(nacionalidad);

        //Llamamos el metodo de inserccion y guardamos el objeto que retorna coder instanciado, se debe castear
        objAutor = (Autores) objLibreriaModel.insertAutor(objAutor);

        JOptionPane.showMessageDialog(null, objAutor.toString());
    }

    public static void deleteAutor() {
        LibreriaModel objLibreriaModel = new LibreriaModel();

        String listAutor = getAllAutoresStr();

        int idDelete = Integer.parseInt(JOptionPane.showInputDialog(listAutor + "\n Enter the ID of the author to delete: "));

        Autores objAutor = objLibreriaModel.findById(idDelete);
        int confirm = 1;

        if (objAutor == null) {
            JOptionPane.showMessageDialog(null, "Author not found...");
        } else {
            confirm = JOptionPane.showConfirmDialog(null, "Are u sure want to delete the Author?\n" + objAutor.toString());

            if (confirm == 0) objLibreriaModel.deleteAutor(objAutor);
        }
    }

    public static void getAutorByName() {
        String name = JOptionPane.showInputDialog("Insert Name: ");
        LibreriaModel objModel = new LibreriaModel();

        String listaString = "COINCIDENCIA \n";
        for (Autores iterador : objModel.findByName(name)) {
            listaString += iterador.toString() + "\n";
        }

        JOptionPane.showMessageDialog(null, listaString);
    }

    public static void updateAutor() {
        //1. Use Model
        LibreriaModel objLibreriaModel = new LibreriaModel();

        String listAutor = getAllAutoresStr();

        int idUpdate = Integer.parseInt(JOptionPane.showInputDialog(listAutor + "\nEnter the Id Author to edit: "));

        //Obteniendo un AUtor por id
        Autores objAutor = objLibreriaModel.findById(idUpdate);
        //Validamos que exista
        if (objAutor == null) {
            JOptionPane.showMessageDialog(null, "Author no found!");
        } else {
            String name = JOptionPane.showInputDialog(null, "Enter new name: ", String.valueOf(objAutor.getName()));
            String nacionalidad = JOptionPane.showInputDialog(null, "Enter new nacionality: ", objAutor.getNacionalidad());

            objAutor.setName(name);
            objAutor.setNacionalidad(nacionalidad);

            objLibreriaModel.updateAutor(objAutor);
        }
    }

    public static void menuAuthors() {


        String option = "";

        do {
            option = JOptionPane.showInputDialog("""
                    1. Insert Authors.
                    . Consult Authors. 
                    3. Update Authors.
                    4. Delete Authors.
                    5. Exit
                                    
                    Choose an option:""");
            switch (option) {
                case "1":
                    LibreriaController.createAutor();
                    break;
                case "2":
                    LibreriaController.getAllAutores();
                    break;
                case "3":
                    LibreriaController.updateAutor();
                    break;
                case "4":
                    LibreriaController.deleteAutor();
            }
        } while (!option.equals("6"));
    }
}
