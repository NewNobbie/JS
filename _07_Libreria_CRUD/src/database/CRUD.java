package database;

import java.util.List;

public interface CRUD {

    //- - - Autores - - -
    public Object insertAutor(Object obj);

    public List<Object> findAllAutors();

    public boolean updateAutor(Object obj);

    public boolean deleteAutor(Object obj);

}
