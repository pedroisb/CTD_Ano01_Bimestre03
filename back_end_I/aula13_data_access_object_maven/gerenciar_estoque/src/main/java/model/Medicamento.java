package model;

public class Medicamento {

    private Integer id;
    private Integer codigoNumerico;
    private String nome;
    private String laboratorio;
    private Integer qnt;
    private Double preco;

    public Medicamento(Integer codigoNumerico, String nome, String laboratorio, Integer qnt, Double preco) {
        this.codigoNumerico = codigoNumerico;
        this.nome = nome;
        this.laboratorio = laboratorio;
        this.qnt = qnt;
        this.preco = preco;
    }

    public Medicamento(Integer id, Integer codigoNumerico, String nome, String laboratorio, Integer qnt, Double preco) {
        this.id = id;
        this.codigoNumerico = codigoNumerico;
        this.nome = nome;
        this.laboratorio = laboratorio;
        this.qnt = qnt;
        this.preco = preco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodigoNumerico() {
        return codigoNumerico;
    }

    public void setCodigoNumerico(Integer codigoNumerico) {
        this.codigoNumerico = codigoNumerico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public Integer getQnt() {
        return qnt;
    }

    public void setQnt(Integer qnt) {
        this.qnt = qnt;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Medicamento{" +
                "codigoNumerico=" + codigoNumerico +
                ", nome='" + nome + '\'' +
                ", laboratorio='" + laboratorio + '\'' +
                ", qnt=" + qnt +
                ", preco=" + preco +
                '}';
    }
}