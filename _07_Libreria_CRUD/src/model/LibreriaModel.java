package model;

import database.CRUD;
import database.ConfigDB;
import entity.Autores;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibreriaModel implements CRUD {
    @Override
    public Object insertAutor(Object obj) {

        //1. Abrimos la Conexión
        Connection objConnection = ConfigDB.openConnection();

        //2. Convert obj to Author
        Autores objAutor = (Autores) obj;

        try {
            //3. Escribimos el sql
            String sql = "INSERT INTO Autor (name,nacionalidad) VALUES (?,?);";

            //4. Preparar el Statement, +agg propiedad RETURN_GENERETED_KEYS que hace que la sentencia SQL nos retorne los id fenerados por la DB
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            //5. Asignar valor a los ???
            objPrepare.setString(1, objAutor.getName());
            objPrepare.setString(2, objAutor.getNacionalidad());

            //6. Ejecuta el query
            objPrepare.execute();

            //7. Obtener el resultado con los Ids
            ResultSet objRest = objPrepare.getGeneratedKeys();

            //8. Iterar mientras haya registro
            while (objRest.next()){
                objAutor.setId_autores(objRest.getInt(1));
            }

            JOptionPane.showMessageDialog(null, "Coder insertion was successful. ");


        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());

        }

        ConfigDB.closeConnection();
        return null;
    }

    @Override
    public List<Object> findAllAutors() {
        //1. Crear lista para guardar lo que nos devuelve la db
        List<Object> listAutores = new ArrayList<>();

        //2. Abrir la conexión
        Connection objConnection = ConfigDB.openConnection();

        try {
            //3. Escribimos el query
            String sql = "SELECT * FROM autores;";

            //4. Use PrepareStatement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            //5. Ejecutar el query y obtener el resultado (Resulset)

            ResultSet objResult = objPrepare.executeQuery();

            //6. Mientras haya un resultado
            while (objResult.next()){

                //6.1 Crea un Autor
                Autores objAutor = new Autores();

                //6.2 Llenar objeto con la info de la db que se itera
                objAutor.setName(objResult.getString("name"));
                objAutor.setNacionalidad(objResult.getString("nacionalidad"));
                objAutor.setId_autores(objResult.getInt("id"));

                //6.3 Agg el Autor a la tabla
                listAutores.add(objAutor);

            }
        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }

        //7. Cerrar la conexión
        ConfigDB.closeConnection();

        return listAutores;
    }

    @Override
    public boolean updateAutor(Object obj) {

        //1. Abrimos la conexión
        Connection objConnection = ConfigDB.openConnection();

        //2 Convert to Author
        Autores objAutor = (Autores) obj;

        //3. Variable para conocer el estado de la conexión
        boolean isUpdated = false;

        try {
            //4. Sentenia SQL
            String sql = "UPDATE autores SET name = ?, nacionalidad = ?  WHERE id = ?;";
            //5. Crear el Statement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            //6. Asignar valor a los parametros del Query
            objPrepare.setString(1,objAutor.getName());
            objPrepare.setString(2,objAutor.getNacionalidad());

            //7. Ejecutar el Query
            int totalRowAffected = objPrepare.executeUpdate();

            if (totalRowAffected > 0){
                isUpdated=true;
                JOptionPane.showMessageDialog(null,"The update was succesful");

            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally {
            ConfigDB.closeConnection();
        }

        return isUpdated;
    }

    @Override
    public boolean deleteAutor(Object obj) {
        //1. Convert obj to entity
        Autores objAutor = (Autores) obj;

        //2. Abrir la conexión
        Connection objConnection =  ConfigDB.openConnection();

        //3. Crear una variable de estado
        boolean isDeleted = false;

        try {
            //4. Escribir sql
            String sql = "DELETE FROM Autores WHERE id = ?;";

            //5. Create prepare Statement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            //6. Dar el valor al simbolo
            objPrepare.setInt(1,objAutor.getId_autores());

            //7. Ejecutamos el Query (executeUpdate) devuleve el número de registros afectados
            int totalAffectedRows = objPrepare.executeUpdate();

            //Si la afectacion es mayor a 0 quiere decir que si elimino algo
            if (totalAffectedRows > 0){
                isDeleted = true;
                JOptionPane.showMessageDialog(null, "The update was successful. ");

            }

        }catch (Exception e){

            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        //8. Cerramos la conexión
        ConfigDB.closeConnection();

        return isDeleted;
    }

    public Autores findById(int getId_autores) {
        //1. Abrimos la conexión
        Connection objConnection = ConfigDB.openConnection();

        //2. Crear el Autor a retornar
        Autores objAutor = null;

        //3. Sentencia SQL
        try {
            String sql = "SELECT * FROM Autores WHERE id =?;";
            //4. Prepare Statement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            //5. Darle valor al parametro del query
            objPrepare.setInt(1, getId_autores);

            //6. Ejecutamos el Query
            ResultSet objResult = objPrepare.executeQuery();
            if (objResult.next()){
                objAutor = new Autores();
                objAutor.setName(objResult.getString("name"));
                objAutor.setNacionalidad(objResult.getString("nacionalidad"));
                objAutor.setId_autores(objResult.getInt("id"));
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        //7.
        return objAutor;
    }

    public List<Autores> findByName(String name){
        //Create list
        List<Autores> autoresList = new ArrayList<>();
        //Open connection
        Connection objConnection = ConfigDB.openConnection();

        try {
            //Sentencia sql
            String sql = "SELECT * FROM Autores WHERE name LIKE ?;";

            //Preparar Statement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setString(1,"%"+name+"%");

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()){
                Autores objAutor = new Autores();
                objAutor.setName(objResult.getString("name"));
                objAutor.setNacionalidad(objResult.getString("nacionalidad"));
                objAutor.setId_autores(objResult.getInt("id"));

            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        ConfigDB.closeConnection();
        return autoresList;
    }
}
