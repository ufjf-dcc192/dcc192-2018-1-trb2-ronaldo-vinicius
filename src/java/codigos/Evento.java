/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigos;

import java.util.Date;

/**
 *
 * @author ice
 */
public class Evento {

    public String codigo;
    public String titulos;
    public Float minimo;
    public Date data;
    public Date sorteio;

    public Evento(String codigo, String titulos, Float minimo, Date data, Date sorteio) {
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getSorteio() {
        return sorteio;
    }

    public void setSorteio(Date sorteio) {
        this.sorteio = sorteio;
    }

}
