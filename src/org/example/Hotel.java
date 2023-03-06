package org.example;

import java.io.File;
import java.io.IOError;
import java.io.IOException;

/**
 * Gracias a esta clase podremos crear a las personas que mas tarde añadiremos en el fichero
 */
public class Hotel {
    int n_Habitacion;
    String nombre, apellido, dni;
    double precio;

    public Hotel(int n_Habitacion, String nombre, String apellido, String dni, double precio) {
        if(n_Habitacion>=0 && n_Habitacion<100){
            this.n_Habitacion = n_Habitacion;
        }else{
            System.err.println("La habitacion no existe");
        }
        this.nombre = nombre;
        this.apellido = apellido;
        if(dni.length()==9){
            String num= dni.substring(0,8);

            try {
                int nn = Integer.parseInt(num);
            }catch (IOError x){
                System.err.println(x);
                this.dni="null";
            }

            if(dni.charAt(8)>=65 && dni.charAt(8)<=90){
                this.dni=dni;
            }else{
                System.err.println("Dni no admitido");
                this.dni="null";
            }
        }else{
            System.err.println("Dni no admitido");
            this.dni="null";
        }
        if(precio>0){
            this.precio = precio;
        }else{
            System.err.println("Precio no admitido.");
            this.precio=0;
        }
    }





    public void setN_Habitacion(int n_Habitacion) {

        if(n_Habitacion>=0 && n_Habitacion<100){
            this.n_Habitacion = n_Habitacion;
        }else{
            System.err.println("La habitacion no existe");
        }

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDni(String dni) {
        if(dni.length()==9){
            String num= dni.substring(0,8);

            try {
                int nn = Integer.parseInt(num);
            }catch (IOError x){
                System.err.println(x);
                this.dni="null";
            }

            if(dni.charAt(8)>=65 && dni.charAt(8)<=90){
                this.dni=dni;
            }else{
                System.err.println("Dni no admitido");
                this.dni="null";
            }
        }else{
            System.err.println("Dni no admitido");
            this.dni="null";
        }
    }

    public void setPrecio(double precio) {
        if(precio>0){
            this.precio = precio;
        }else{
            System.err.println("Precio no admitido.");
            this.precio=0;
        }

    }

    public int getN_Habitacion() { return n_Habitacion;
    }
    public String getNombre() {return nombre;
    }
    public String getApellido() { return apellido;
    }
    public String getDni() { return dni;
    }
    public double getPrecio() { return precio;
    }

    @Override
    public String toString() {
        return  n_Habitacion + "," + nombre +"," + apellido  +"," + dni  +
                "," + precio ;
    }
}
