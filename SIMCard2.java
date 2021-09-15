/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jlctm.grafica;

/**
 *
 * @author Jose Luis Camilo Torres Meriño
 */
public class SIMCard {
    
    //Atributos
    private String empresaTelefonia = "HI";
    private double saldo = 0;
    private String numeroTelefono = "";
    private boolean celularApagado = true;
    private boolean modoAvionActivado = false;
    private boolean datosActivados = false;
    private int saldoDatos = 0;
    
    //Constructor
    public SIMCard(String numeroTelefono){
        this.numeroTelefono = numeroTelefono;
    }
    
    //Metodos
    public void comprarDatos(int c){
        int costo = 0;
        int GB = c;
        if(c<=10){
            costo = c*3000;
        }else if(c>=10 && c<=30){
            c-=10;
            costo = (10*3000)+(c*2500);
        }else if(c>30){
            c-=20;
            costo = (20*3000)+(c*1500);
        }
        if(costo < this.saldo){
            this.setSaldo(this.getSaldo()-costo);
            this.setSaldoDatos(GB);
        }
    }
    
    public void consumirDatos(int c){
        if(this.isCelularApagado() != true && this.isModoAvionActivado() != true && this.getSaldoDatos() > 0){
            this.setSaldoDatos(this.getSaldoDatos()-c);
        }
    }
    
    public void llamar(int s){
        double valor = 0;
        if(this.isCelularApagado() != true || this.isModoAvionActivado() != true && this.getSaldo() > 0){
            if(s<=60){
                valor = s * 1;
            }else if(s>60){
                s-=60;
                valor = (60) + (s * 0.5);
            }
        }
        this.setSaldo(this.getSaldo()-valor);
    }
    
    public void recargarSaldo(double s){
        this.setSaldo(this.getSaldo()+s);
    }
    
    public void gestionarEncendidoCelular(){
        if (this.isCelularApagado() == true){
            this.setCelularApagado(false);
        }else{
            if (this.isCelularApagado() != true){
                this.setCelularApagado(true);
                this.setDatosActivados(false);
                this.setModoAvionActivado(false);
            }   
        }
    }
    
    public void gestionarModoAvion(){
        if (this.isModoAvionActivado() == true){
            this.setModoAvionActivado(false);
        }else{
            if(this.isModoAvionActivado() != true && this.isCelularApagado() != true){
                this.setModoAvionActivado(true);
                this.setDatosActivados(false);
            }
        }
        
    }
    
    public void gestionarDatos(){
        if(this.isDatosActivados() == false && this.isModoAvionActivado() !=true && this.isCelularApagado() != true){
            this.setDatosActivados(true);
        }else{
            this.setDatosActivados(false);
        }
    }
    
    //Setters y Geeters
    public String getEmpresaTelefonia() {
        return empresaTelefonia;
    }

    public void setEmpresaTelefonia(String empresaTelefonia) {
        this.empresaTelefonia = empresaTelefonia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public boolean isCelularApagado() {
        return celularApagado;
    }

    public void setCelularApagado(boolean celularApagado) {
        this.celularApagado = celularApagado;
    }

    public boolean isModoAvionActivado() {
        return modoAvionActivado;
    }

    public void setModoAvionActivado(boolean modoAvionActivado) {
        this.modoAvionActivado = modoAvionActivado;
    }

    public boolean isDatosActivados() {
        return datosActivados;
    }

    public void setDatosActivados(boolean datosActivados) {
        this.datosActivados = datosActivados;
    }

    public int getSaldoDatos() {
        return saldoDatos;
    }

    public void setSaldoDatos(int saldoDatos) {
        this.saldoDatos = saldoDatos;
    }
}
