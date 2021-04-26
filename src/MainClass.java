import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args){
        ArrayList<Peli> ListaP = new ArrayList();
        ArrayList<Cliente> ListaC = new ArrayList();
        String n,d,g,s,opc;
        int cl, ed;
        Scanner e = new Scanner(System.in);
        try{
            do{
                System.out.println("---- Bienvenido a NECFLIS! ---- \n");
                System.out.println(" Selecciona una opción: \n1. CLIENTES \n2. PELICULAS \n3. SALIR \n");
                opc = e.nextLine();
                switch(opc){
                    case "1":
                        do {
                            System.out.println(" \n1. VER LISTADO DE CLIENTES \n2. CREAR NUEVO CLIENTE \n3. SELECCIONAR CLIENTE \n4. ATRÄS");
                            opc = e.nextLine();
                            switch(opc){
                                case "1":
                                    if(ListaC.size()==0){
                                        System.out.println(" \n---Por El momento no existen Clientes registrados---");
                                        e.nextLine();
                                    }else{
                                        imprimirC(ListaC);
                                        e.nextLine();
                                    }
                                    break;
                                case "2":
                                    System.out.println(" \n---Crear un Nuevo Cliente--- \n\nIngrese el Nombre del Cliente: ");
                                    n = e.nextLine();
                                    System.out.println("Ingrese la dirección del Cliente: ");
                                    d = e.nextLine();
                                    System.out.println("Ingrese la Edad del Cliente: ");
                                    ed = Integer.parseInt(e.nextLine());
                                    ListaC.add(new Cliente(n,d,ed));
                                    System.out.println(" \nCliente Registrado Exitosamente! \n");
                                    e.nextLine();
                                    imprimirC(ListaC);
                                    e.nextLine();
                                    break;
                                case "3":
                                    if(ListaC.size()==0){
                                        System.out.println(" \nPor el Momento no se encuentra ningún cliente registrado para Seleccionar ");
                                        e.nextLine();
                                    }else{
                                        do{
                                            System.out.println(" \n\nSeleccione El CLiente que desea Modificar: (ó ingrese '0' para volver atrás)");
                                            imprimirC(ListaC);
                                            cl = Integer.parseInt(e.nextLine());
                                            if(cl==0){

                                            }else{
                                                do{
                                                    System.out.println(" \n\nCliente Seleccionado Número : "+cl+" \nNombre: "+ListaC.get(cl-1).n+" \nDirección: "+ListaC.get(cl-1).d+" \nEdad: "+ListaC.get(cl-1).e);
                                                    System.out.println(" \n\nQUE DESEA HACER CON ESTE CLIENTE? \n1. Ver Playlist \n2. Agregar pelicula a su Playlist \n3. ATRÁS");
                                                    opc = e.nextLine();
                                                    if(opc.equals("1")){
                                                        if(ListaC.get(cl-1).Pelic.size()==0){
                                                            System.out.println(" \nEn este momento la PlayList del Cliente seleccionado esta vacía...");
                                                            e.nextLine();
                                                        }else{
                                                            imprimir(ListaC.get(cl-1).Pelic);
                                                            e.nextLine();
                                                        }
                                                    }else if(opc.equals("2")){
                                                        System.out.println(" \nQue pelicula deseas agregar a la Playlist del Cliente? \n(Para Cancelar Ingresa '0' ) \n");
                                                        if(ListaP.size()==0){
                                                            System.out.println(" \nPor el Momento no hay peliculas Registradas Disponibles");
                                                            e.nextLine();
                                                        }else{
                                                            imprimir(ListaP);
                                                            opc = e.nextLine();
                                                            if(opc.equals("0")){

                                                            }else if(Numero(opc)){
                                                                if((Integer.parseInt(opc)-1)>=ListaP.size()){
                                                                    System.out.println(" \nEL indice de la pelicula ingresado NO Existe :)");
                                                                    e.nextLine();
                                                                }else{
                                                                    ListaC.get(cl-1).Pelic.add(ListaP.get(Integer.parseInt(opc)-1));
                                                                    System.out.println(" \nLa pelicula fué agregada a la PlayList del Cliente de manera Exitosa ;)");
                                                                    e.nextLine();
                                                                }
                                                            }else{
                                                                error(e);
                                                            }
                                                        }
                                                    }
                                                }while(!opc.equals("3"));
                                            }
                                        }while(cl!=0);
                                    }
                                    break;
                                case "4":
                                    break;
                                default:
                                    error(e);
                                    break;
                            }
                        }while(!opc.equals("4"));
                        break;
                    case "2":
                        do{
                            System.out.println(" \n1. VER LISTADO DE PELICULAS \n2. CREAR PELICULA \n3. ATRÁS ");
                            opc = e.nextLine();
                            switch(opc){
                                case "1":
                                    if(ListaP.size()==0){
                                        System.out.println(" \nEn este momento la Playlist de Peliculas disponibles esta vacía");
                                        e.nextLine();
                                    }else{
                                        imprimir(ListaP);
                                        e.nextLine();
                                    }
                                    break;
                                case "2":
                                        System.out.println(" \n\n---Crear una Pelicula--- \nIngrese el nombre de la pelicula: ");
                                        n = e.nextLine();
                                        System.out.println(" \nIngrese el tipo de Pelicula: (Serie ó Pelicula)");
                                        d = e.nextLine();
                                        System.out.println(" \nIngrese el Genero de la Pelicula (Drama, Comedia, Terror, Suspenso)");
                                        g = e.nextLine();
                                        System.out.println(" \nEscriba una pequeña sinopsis de la Pelicula Ingresada: ");
                                        s = e.nextLine();
                                        ListaP.add(new Peli(n,d,g,s));
                                        imprimir(ListaP);
                                        e.nextLine();
                                    break;
                                case "3":
                                    opc += "1";
                                    break;
                                default:
                                    error(e);
                                    break;
                            }
                        }while(!opc.equals("31"));
                        break;
                    case "3":
                        System.out.println(" \n\nGRACIAS POR UTILIZAR MI PROGRAMA! ESPERO HAYA SIDO DE TU AGRADO ;)");
                        e.nextLine();
                        break;
                    default:
                            error(e);
                        break;
                }
            }while(!opc.equals("3"));
        }catch(Exception x){
            System.out.println(x.getMessage());
            e.nextLine();
        }
    }
    public static void imprimirC(ArrayList<Cliente> w){
        System.out.println(" \n---Listado de Clientes Registrados--- \n");
        for(int x=0; x<w.size();x++){
            System.out.println((x+1)+". " + w.get(x).n);
        }
    }
    public static void imprimir(ArrayList<Peli> w){
        System.out.println(" \n\n---PlayList de Peliculas---\n");
        for(int x=0; x<w.size();x++){
            System.out.println((x+1)+". " + w.get(x).n);
        }
    }
    public static Boolean Numero(String x){
        int y;
        try{
            y = Integer.parseInt(x);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public static void error(Scanner e){
        System.out.println(" \nLa Opción Ingresada no existe, Ingrese una opción Válida...");
        e.nextLine();
    }
}