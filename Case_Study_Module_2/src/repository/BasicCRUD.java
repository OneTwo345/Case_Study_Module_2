package repository;

import java.io.IOException;
import java.util.List;

public interface BasicCRUD<T> {
    T getById(int id);


    void create(T obj) throws IOException;

    void update(T obj);

    void delete(int id) throws IOException;



}
