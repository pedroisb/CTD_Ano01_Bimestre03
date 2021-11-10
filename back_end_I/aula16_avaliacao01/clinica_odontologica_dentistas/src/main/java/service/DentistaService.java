package service;

import dao.IDao;
import model.Dentista;

import java.util.List;

public class DentistaService {

    private IDao<Dentista> dentistaIDao;

    public DentistaService(IDao<Dentista> dentistaIDao) {
        this.dentistaIDao = dentistaIDao;
    }

    public Dentista cadastrar(Dentista dentista) {
        return dentistaIDao.cadastrar(dentista);
    }

    public List<Dentista> exibirTodos(){
        return dentistaIDao.exibirTodos();
    }
}
