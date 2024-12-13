package util;

public class Persona {
    public String nombre;
    public int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public void celebrarCumpleaños() {
        edad = edad + 1;
        System.out.println(nombre + " acaba de celebrar su cumpleaños!");
    }
}