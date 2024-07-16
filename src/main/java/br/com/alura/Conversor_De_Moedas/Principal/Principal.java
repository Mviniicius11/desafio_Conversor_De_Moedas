package br.com.alura.Conversor_De_Moedas.Principal;

import br.com.alura.Conversor_De_Moedas.Modulos.Menu;

public class Principal {
    Menu menu = new Menu();

    private final String ENDERECO = "https://v6.exchangerate-api.com/v6/";
    private final String API_KEY = "59601955ddc5876f4d5e0149/pair";

    String moeda1;
    String moeda2;

    public String getENDERECO() {
        return ENDERECO;
    }

    public String getAPI_KEY() {
        return API_KEY;
    }

    public String getMoeda1() {
        return moeda1;
    }

    public void setMoeda1(String moeda1) {
        this.moeda1 = moeda1;
    }

    public String getMoeda2() {
        return moeda2;
    }

    public void setMoeda2(String moeda2) {
        this.moeda2 = moeda2;
    }

    public void exibeMenu(){
        menu.menuInicial();

    }}
