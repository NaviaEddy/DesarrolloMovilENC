package com.example.prueba_java.backend;

public class operaciones {
    private int x;
    private int y;

    public operaciones(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int suma(){
        return this.x+this.y;
    }

    public int resta(){
        return this.x-this.y;
    }

    public int multiplicacion(){
        return this.x*this.y;
    }

    public int division(){
        return this.x/this.y;
    }
}
