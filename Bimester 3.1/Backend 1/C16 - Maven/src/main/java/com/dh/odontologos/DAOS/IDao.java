package com.dh.odontologos.DAOS;

import java.sql.SQLException;
import java.util.List;

public interface IDao <T> {
    public T guardar(T t);

    public List<T> buscarTodos();
}