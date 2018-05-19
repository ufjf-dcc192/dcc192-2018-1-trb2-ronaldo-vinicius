package codigos;

import java.util.Date;
public class Evento {

    public String codigo;
    public String titulos;
    public Float minimo;
    public String data;
    public String sorteio;

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

    @Override
    public String toString() {
        return codigo + " - " + titulos + " - " + minimo + " - " + data + " - " + sorteio;
    }
    

}
