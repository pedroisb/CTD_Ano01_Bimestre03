package dao;

import java.util.List;

public interface IDao<T> {

    public T cadastrar (T t);
    public List<T> exibirTodos();

}
