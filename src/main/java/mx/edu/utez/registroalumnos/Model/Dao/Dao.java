package mx.edu.utez.registroalumnos.Model.Dao;

import java.util.List;

public interface Dao<T, K> {
    boolean create (T t);
    List<T> getAll();
    T getById(K id);
    boolean update (T t);
    boolean delete (Integer id);

    ;
}