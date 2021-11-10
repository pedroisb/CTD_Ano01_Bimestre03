package dao;

import java.util.List;
import java.util.Optional;

public interface IDao<T> {

    public T cadastrar (T t);
    public T modificar (T t);
    public void excluir (Integer id);
    public Optional<T> buscar (Integer id);
    public List<T> exibirTodos();

}
