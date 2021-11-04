package com.example.pruebaviewmodel.ui.main;

import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private int numero;

    public int getNumero() {return numero;}

    public void setNumero(int numero) {this.numero = numero;}
}