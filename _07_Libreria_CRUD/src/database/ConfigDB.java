package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Clase encargada de establecer y cerrar la conexión
public class ConfigDB {
    //Atributo que tendrá el estado de la conexión
    public static Connection objConnection = null;

    //Método para conectar la DB
    public static Connection openConnection(){

        try{
            //Call Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Creamos las clases de la conexión
            String url = "jdbc:mysql://bjlfor8xnihehebgeosa-mysql.services.clever-cloud.com:3306/bjlfor8xnihehebgeosa";
            String user = "uccnmnvhsfyjhhhc";
            String password = "nCBApGxYjZLbQ2fniJ6k";


            //Establecemos conexión
            objConnection = (Connection) DriverManager.getConnection(url,user,password);
            System.out.println("Conexión establecida mi pez!");

        }catch (ClassNotFoundException error){
            System.out.println("ERROR >> Driver no instalado " + error.getMessage());
        }catch (SQLException error){
            System.out.println("ERROR >> error al conectar con la DB mi pez "+ error.getMessage());
        }

        return objConnection;
    }

    //Método para finalizar la conexión
    public static void closeConnection(){
        try{
            //Al detectar una conexión activa la cierra
            if (objConnection != null){
                objConnection.close();
                System.out.println("Se finalizó la conexión con éxito mi pez");
            }
        }catch (SQLException e){
            System.out.println("Error: "+ e.getMessage());
        }

    }
}
