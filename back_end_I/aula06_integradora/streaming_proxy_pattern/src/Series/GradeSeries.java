package Series;

import java.util.ArrayList;
import java.util.List;

public class GradeSeries implements IGradeSeries {

    private List<Serie> series;

    public GradeSeries() {
        this.series = new ArrayList<>();
    }

    @Override
    public String getSerie(String nome) throws SerieNaoHabilitadaException {
        Serie serieSelecionada = series.stream().filter(serie -> serie.getNome().equals(nome)).findFirst().orElse(null);
        return serieSelecionada.getLink();
    }

    public List<Serie> getSeries() {
        return series;
    }

    public void setSeries(List<Serie> series) {
        this.series = series;
    }
}
