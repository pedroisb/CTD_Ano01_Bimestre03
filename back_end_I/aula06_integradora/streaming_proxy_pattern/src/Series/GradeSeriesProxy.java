package Series;

import UsuarioIP.Ip;

public class GradeSeriesProxy implements IGradeSeries {

    private Ip ip;
    private GradeSeries gradeSeries;
    private static int qtdVistas;

    public GradeSeriesProxy(Ip ip, GradeSeries gradeSeries) {
        this.ip = ip;
        this.gradeSeries = gradeSeries;
        qtdVistas = 1;
    }

    @Override
    public String getSerie(String nome) throws SerieNaoHabilitadaException{
        if(qtdVistas > 5)
            throw new SerieNaoHabilitadaException("Excedido o limite de reproduções permitidas");

        ++qtdVistas;
        return this.gradeSeries.getSerie(nome);
    }

    public Ip getIp() {
        return ip;
    }

    public void setIp(Ip ip) {
        this.ip = ip;
    }

    public GradeSeries getGradeSeries() {
        return gradeSeries;
    }

    public void setGradeSeries(GradeSeries gradeSeries) {
        this.gradeSeries = gradeSeries;
    }

    public int getQtdVistas() {
        return qtdVistas;
    }

    public static void setQtdVistas(int qtdVistas) {
        GradeSeriesProxy.qtdVistas = qtdVistas;
    }
}
