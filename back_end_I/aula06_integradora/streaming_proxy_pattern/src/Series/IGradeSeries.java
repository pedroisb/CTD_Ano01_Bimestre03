package Series;

import Series.SerieNaoHabilitadaException;

public interface IGradeSeries {

    public String getSerie(String nome) throws SerieNaoHabilitadaException;
}
