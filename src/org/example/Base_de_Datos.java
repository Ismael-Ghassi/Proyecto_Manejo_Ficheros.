package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * En esta clase se encuentran los metodos para crear y trabajar con los ficheros del hotel.
 */
public class Base_de_Datos {

    File f = new File("C://Users//Grado Medio//Desktop//PROYECTO//hotel.txt"); //Ruta donde se almacenara el fichero (si no existe se creara)
    File f2 = new File("C://Users//Grado Medio//Desktop//PROYECTO//hotel.txt"); //Ruta para acceder al fichero.


   public void unaPersona(Hotel x) throws IOException {
       if(f2.exists() && f2.length()>0){
           FileReader fr = new FileReader(f2);
           BufferedReader br = new BufferedReader(fr);

           ArrayList<Hotel> nuevo = new ArrayList<>();
           String[] array = new String[5];
           String l;

           while((l=br.readLine())!=null){
               array=l.split(",");
               Hotel ob = new Hotel(Integer.parseInt(array[0]),array[1],array[2],array[3],Double.parseDouble(array[4]));
               nuevo.add(ob);
           }
           br.close();
           fr.close();

       //-----------------------------------------------------------------------
           FileWriter fw = new FileWriter(f2,true);
           BufferedWriter bw = new BufferedWriter(fw);

           int cont=0;
           for(int i=0;i<nuevo.size();i++){
               if(nuevo.get(i).getN_Habitacion()==x.getN_Habitacion()){
                   cont++;
               }
           }
           if (cont ==0){
               boolean esc=true;

                   if(x.getDni().equals("null") || x.getPrecio()==0){
                        esc=false;
                   }

               if(esc){
                   nuevo.add(x);
                   bw.write(x.toString());
                   bw.newLine();
                   System.out.println("La habitacion ha sido asignada correctamente");
               }else{
                   System.err.println("error");
               }

           }else{
               System.err.println("La habitacion "+x.getN_Habitacion()+" ya esta ocupada.");
           }
           bw.close();
           fw.close();



       }else{
           FileWriter fw = new FileWriter(f2);
           BufferedWriter bw = new BufferedWriter(fw);

           bw.write(x.toString());
           bw.newLine();

           bw.close();
           fw.close();
       }


   }









    /**
     * Este metodo crea el fichero con las personas pasadas por parametros, se pueden añadir mas personas sin que se sobreescriba el fichero
     * @param x son las personas
     * @throws IOException
     */
    public void introducirPersonas(ArrayList <Hotel> x) throws IOException {
        FileReader fr = new FileReader(f2); //Nos permite leer en el fichero
        BufferedReader br = new BufferedReader(fr); //Nos permite leer de linea en linea
        ArrayList<Hotel> nuevo = new ArrayList<>();

            String[] array = new String[5];
            String l;

            while ((l = br.readLine()) != null) {
                int cont = 0;
                array = l.split(",");
                Hotel h = new Hotel(Integer.parseInt(array[0]), array[1], array[2], array[3], Double.parseDouble(array[4]));
                nuevo.add(h);

            }

            /* Este bucle anidado sirve para controlar la redundancia de los datos, si la habitacion ya esta
            asignada no la escribirá */
            for(int i=0; i<x.size();i++){
                int cont=0;
                for (int j=0; j<nuevo.size(); j++ ){
                    if(nuevo.get(j).getN_Habitacion()==x.get(i).getN_Habitacion()){
                        cont++;
                        System.err.println("La habitacion ya esta asignada");
                    }
                }
                if(cont==0){
                    nuevo.add(x.get(i));
                    System.out.println("La habitacion ha sido asignada correctamente");
                }
            }


            br.close();
            fr.close();



            FileWriter fw = new FileWriter(f); //Con esta clase escribimos en el fichero.
            BufferedWriter bw = new BufferedWriter(fw); //Nos permite escribir linea por linea

            for (int i = 0; i < nuevo.size(); i++) { //Bucle para escribir en el fichero
                bw.write(nuevo.get(i).toString());
                bw.newLine();   //Sirve para que cada br.write escriba en una linea distinta
            }

            bw.close();
            fw.close();

    }


    /**
     * Es identico al metodo introducir personas con la pequeña diferencia de que este metodo sobreescribe el fichero
     * @param x son las personasson las personas
     * @throws IOException
     */
    public void sobreescribirPersonas(ArrayList <Hotel> x) throws IOException {
        FileWriter fw = new FileWriter(f);
        BufferedWriter br = new BufferedWriter(fw);
        for(int i=0; i<x.size();i++){
            br.write(x.get(i).toString());
            br.newLine();
        }

        br.close();
        fw.close();
    }


    /**
     * Este metodo lee las personas que se encuentran en el fichero
     * @throws IOException
     */
    public void leerPersonas() throws IOException {
        FileReader fr = new FileReader(f2); //Nos permite leer en el fichero
        BufferedReader br = new BufferedReader(fr); //Nos permite leer de linea en linea

        String i;
        System.out.println("Base de datos del Hotel: ");
        br.readLine();
        while( ( i = br.readLine())!=null){ //Bucle para leer
            System.out.println(i);
        }
        br.close();
        fr.close();
    }




    /**
     * Este metodo nos permite eliminar una persona introduciendo su numero de habitacion
     * @param num es el numero de habitacion
     * @throws IOException
     */
    public void eliminarPersona(int num) throws IOException {
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);

        String [] array= new String[5]; //Array para aplicar el split
        String l;
        ArrayList <Hotel> nuevo = new ArrayList<>(); //Con este arrayList crearemos una copia de la que eliminaremos a la persona deseada
        while ((l= br.readLine())!=null){
            array= l.split(","); //Usamos el split de las comas ya que en el fichero los diferentes datos estan delimitados por comas.
            Hotel h = new Hotel(Integer.parseInt(array[0]),array[1],array[2],array[3],Double.parseDouble(array[4])); // escribimos en el objeto Hotel el contenido de la linea del fichero

            nuevo.add(h); //añadimos al nuevo array la persona que se acaba de almacenar el en objeto
        }

        br.close();
        fr.close();

        boolean exist=false;
        for(int i=0; i<nuevo.size();i++){
            if(nuevo.get(i).getN_Habitacion()==num){
                nuevo.remove(i); //borramos a la persona que será modificada
                exist=true;
            }
        }
        if(exist){
            System.out.println("Persona encontrada y eliminada con exito");
        }else{
            System.err.println("El numero de habitacion jamas fue asignado");
        }
        for (int i =0; i< nuevo.size();i++){
            System.out.println(nuevo.get(i).toString());
        }



        FileWriter fw = new FileWriter(f2); //Para escribir en el fichero en nuevo array
        BufferedWriter bw = new BufferedWriter(fw);

        for(int i=0; i< nuevo.size();i++){ //Bucle para escribir
            bw.write(nuevo.get(i).toString());
            bw.newLine();
        }
        bw.close();
        fw.close();

    }






    /**
     * Este metodo actualiza los datos de la persona en funcion de su habitacion
     * @param x es el objeto persona con sus nuevos datos
     * @throws IOException
     */
    public void actualizar( Hotel x) throws IOException {
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);

        String [] array= new String[5]; //Array para aplicar el split
        String l;
        ArrayList <Hotel> nuevo = new ArrayList<>(); //nuevo arrayList donde se almacenaran las personas que se encuentran en el fichero
        while ((l= br.readLine())!=null){
            array= l.split(","); //Sirve para escoger los distintos datos de las personas
            System.out.println(array);
            Hotel h = new Hotel(Integer.parseInt(array[0]),array[1],array[2],array[3],Double.parseDouble(array[4])); //Escribimos los datos de las personas en este objeto que mas tarde se añadira al nuevo array
            System.out.println(h.toString());
            nuevo.add(h); //Añadimos el objeto al array del Hotel
        }
        br.close();
        fr.close();

        if(x.getPrecio()==0 || x.getDni().equals("null")){
            System.err.println("error");
        }else{
            boolean exist=false;
            for(int i=0; i<nuevo.size();i++){
                if(nuevo.get(i).getN_Habitacion()==x.getN_Habitacion()){
                    nuevo.remove(i); //borramos a la persona que será modificada
                    exist=true;
                }
            }
            if (exist) {
                nuevo.add(x);// Añadimos a la persona en su antigua posicion en el array
            }else{
                System.err.println("La persona que se quiere modificar no existe");
            }
        }

        FileWriter fw = new FileWriter(f2);
        BufferedWriter bw = new BufferedWriter(fw);

        for(int i=0; i< nuevo.size();i++){ //Escribimos en el fichero en nuevo array con la persona modificada
            bw.write(nuevo.get(i).toString());
            bw.newLine();

        }
        bw.close();
        fw.close();
    }
}
