package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int opcion;

        ArrayList<Hotel> hotel = new ArrayList<>(); //array de donde se almacenaran las personas.
        int cont=1;
        for (int i=0; i<5; i++){ //Generar array de las personas.
            Hotel x = new Hotel(cont,"xxx","yyy","49807320R",(int)(Math.random()*100));
            hotel.add(x);//añadimos a las persona generada.
            cont++;
        }


        Base_de_Datos p = new Base_de_Datos();
        boolean salida=false;
        while(salida==false) {
            System.out.println("Que accion quieres realizar: \n 1->> añadir una persona \n 2--> añadir un grupo de personas \n 3--> sobreescribir el fichero \n 4--> leer personas \n 5--> eliminar persona \n 6--> actualizar persona \n");

            System.out.println("Opcion: ");
            opcion = scan.nextInt();
            switch (opcion) {
                case 1:
                    Scanner scan1 = new Scanner(System.in);
                    System.out.println("Actualizar persona: ");
                    System.out.println("Introduce los datos de la persona:");
                    System.out.println("Nombre: "); Scanner noms = new Scanner(System.in); String nom = noms.nextLine();
                    System.out.println("Nª de habitacion: "); Scanner habs = new Scanner(System.in); int hab = habs.nextInt();
                    System.out.println("Apellido: "); Scanner apes = new Scanner(System.in); String ape = apes.nextLine();
                    System.out.println("precio"); Scanner pres = new Scanner(System.in); double pre= pres.nextDouble();
                    System.out.println("DNI: "); Scanner dnis = new Scanner(System.in); String dni = dnis.nextLine();
                    Hotel pe = new Hotel(hab,nom,ape, dni,pre);

                    p.unaPersona(pe);
                    break;

                case 2:
                    System.out.println("Introducir grupo de personas: ");
                    p.introducirPersonas(hotel);
                    break;

                case 3:
                    System.out.println("Sobreescribir grupo de personas: ");
                    p.sobreescribirPersonas(hotel);
                    break;

                case 4:
                    System.out.println("Leer personas: ");
                    p.leerPersonas();
                    break;

                case 5:
                    System.out.println("Eliminar persona:");
                    System.out.println("Nª de habitacion: "); int habE = scan.nextInt();
                    System.out.println(habE);
                    p.eliminarPersona(habE);
                    break;

                case 6:
                    //Scanner scan2 = new Scanner(System.in);
                    System.out.println("Actualizar persona: ");
                    System.out.println("Introduce los datos de la persona:");
                    System.out.println("Nombre: "); Scanner nomrs = new Scanner(System.in); String nomr = nomrs.nextLine();
                    System.out.println("Nª de habitacion: "); Scanner habrr = new Scanner(System.in); int habr = habrr.nextInt();
                    System.out.println("Apellido: "); Scanner aperr = new Scanner(System.in); String aper = aperr.nextLine();
                    System.out.println("precio"); Scanner prerr = new Scanner(System.in); double prer= prerr.nextDouble();
                    System.out.println("DNI: "); Scanner dnirr = new Scanner(System.in); String dnir = dnirr.nextLine();
                    Hotel pr = new Hotel(habr,nomr,aper,dnir,prer);
                    p.actualizar(pr);
                    break;
            }

            System.out.println("Quieres seguir? (Si o No)");
            String exit= scan.next();
            if(exit.equals("no")){
                salida=true;
            }

        }
    }
}