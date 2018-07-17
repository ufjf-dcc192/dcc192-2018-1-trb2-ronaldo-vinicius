package codigos;

import java.util.ArrayList;
import java.util.List;

public class Evento {

    private String codigo;
    private String titulos;
    private Float minimo;
    private String data;
    private String sorteio;
    private String sorteado;
    public List<Participante> inscritos = new ArrayList<>(); 

            
    public Evento(String codigo, String titulos, Float minimo, String data, String sorteio) {
        this.codigo = codigo;
        this.titulos = titulos;
        this.minimo = minimo;
        this.data = data;
        this.sorteio = sorteio;
    }

    public Evento() {
    }

    public void sorteia() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulos() {
        return titulos;
    }

    public void setTitulos(String titulos) {
        this.titulos = titulos;
    }

    public Float getMinimo() {
        return minimo;
    }

    public void setMinimo(Float minimo) {
        this.minimo = minimo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getSorteio() {
        return sorteio;
    }

    public void setSorteio(String sorteio) {
        this.sorteio = sorteio;
    }
    
    public List<Participante> getInscritos() {
        return inscritos;
    }

    public void setInscritos(List<Participante> inscritos) {
        this.inscritos = inscritos;
    }

    public String getSorteado() {
        return sorteado;
    }

    public void setSorteado(String sorteado) {
        this.sorteado = sorteado;
    }
    
    @Override
    public String toString() {
        return codigo + " - " + titulos + " - " + minimo + " - " + data + " - " + sorteio;
    }
    

}
