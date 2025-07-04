package com.marver.conversor.modulos;

public class monedaJson {
    private String monedaInicial;
    private String monedaFinal;
    private double cantidad;
    private double resultado;

    public monedaJson(MonedaAPI miMoneda){
        this.monedaInicial = miMoneda.base_code();
        this.monedaFinal = miMoneda.target_code();
        this.cantidad = miMoneda.conversion_rate();
        this.resultado = miMoneda.conversion_result();
    }

    public String getMonedaInicial() {

        return monedaInicial;
    }

    public void setMonedaInicial(String monedaInicial) {

        this.monedaInicial = monedaInicial;
    }

    public String getMonedaFinal() {
        return monedaFinal;
    }

    public void setMonedaFinal(String monedaFinal) {
        this.monedaFinal = monedaFinal;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return  "MonedaJson \n" +
                "monedaInicial='" + monedaInicial +
                ", monedaFinal='" + monedaFinal +
                ", cantidad=" + cantidad +
                ", resultado=" + resultado;
    }
}
