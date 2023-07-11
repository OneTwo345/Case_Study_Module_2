package service;

import java.io.IOException;
import java.util.List;

public interface BasicCRUD<T> {
    T getById(int id);

    List<T> getAll();

    void create(T obj);

    void update(T obj);

    void delete(int id) ;

    boolean isExist(int id);

    void print();




}
