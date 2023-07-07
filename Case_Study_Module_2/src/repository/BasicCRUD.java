package repository;

import java.io.IOException;
import java.util.List;

public interface BasicCRUD<T> {
    T getById(int id);


    void create() throws IOException;

    void update(int id);

    void delete(int id) throws IOException;





}
