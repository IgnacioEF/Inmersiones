package vista;

import controlador.BuceadoresController;
import controlador.InmersionController;
import controlador.MonitorController;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import modelo.Buceadores;
import modelo.Inmersion;
import modelo.Monitor;

public class Menu{
    
    public static Buceadores rellenarBuceador(){
        Buceadores buceador = new Buceadores();
        System.out.println("Introduzca los datos del buceador: ");
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Nombre: ");
        buceador.setNombre(scan.next());
        
        System.out.print("Titulación: ");
        buceador.setTitulacion(scan.next());
        
        buceador.setInmersions(new HashSet());
        
        return buceador;
    }
    
    public static Inmersion rellenarInmersion(){
        Inmersion inmersion = new Inmersion();
        System.out.println("Por favor introduzca los datos de la inmersion: ");
        
        
        System.out.println("Introduzca la duracion: ");
        Scanner scan = new Scanner(System.in);
        inmersion.setDuracion(scan.next());
        
        System.out.println("Introduzca el lugar de la inmersion: ");
        inmersion.setLugar(scan.next());
        
        System.out.println("Introduce el id del monitor: ");
        inmersion.setIdMonitor(scan.nextInt());
        
        inmersion.setBuceadoreses(new HashSet());
        
        return inmersion;
    }
    
    public static Monitor rellenarMonitor(){
        Monitor monitor = new Monitor();
        System.out.println("Por favor introduzca los datos del monitor: ");
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Introduzca el nombre: ");
        monitor.setNombre(scan.next());
        
        System.out.println("Introduzca el club del monitor: ");
        monitor.setClub(scan.next());
        
        System.out.println("Introduzca la provincia de el monitor");
        monitor.setProvincia(scan.next());
        
        return monitor;
    }
    
    

    public static void main(String[] args) {
        String opcion = null;    
        BuceadoresController bc = new BuceadoresController();
        InmersionController ic = new InmersionController();
        MonitorController mc = new MonitorController();
        
        while(!"13".equals(opcion)){    
            System.out.println("¿Qué desea hacer? \n"
                            + "1- Introducir monitor \n"
                            + "2- Introducir inmersion \n"
                            + "3- Introducir buceador\n"
                            + "4- listar monitores \n"
                            + "5- listar inmersiones \n"
                            + "6- listar buceadores \n"
                            + "7- modificar monitor \n"
                            + "8- modificar inmersion \n"
                            + "9- modificar buceador \n"
                            + "10- eliminar monitor \n"
                            + "11- eliminar inmersion\n"
                            + "12- eliminar buceador\n"
                            + "13- realizar inmersion\n"
                            + "14- salir");
                    Scanner scan = new Scanner(System.in);
                    opcion = scan.next();

                    if(opcion.equals("1")){
                        System.out.println("**************************\n"
                                        +  "***INTRODUCIR MONITOR***\n"
                                        +  "**************************");
                        mc.AddMonitor(rellenarMonitor());
                    }
                    else if(opcion.equals("2")){
                        System.out.println("*************************\n"
                                        +  "***INTRODUCIR INMERSION***\n"
                                        +  "*************************");
                        ic.AddInmersion(rellenarInmersion());
                    }
                    else if(opcion.equals("3")){
                        System.out.println("************************\n"
                                        +  "***INTRODUCIR BUCEADOR***\n"
                                        +  "************************");
                        bc.AddBuceador(rellenarBuceador());
                    }
                    else if(opcion.equals("4")){
                        System.out.println("************************\n"
                                        +  "***LISTAR MONITORES***\n"
                                        +  "************************");
                        List<Monitor> monitores = mc.getMonitor();
                        for (Monitor next : monitores) {
                            System.out.println("******Monitor******" + "\nnombre: " + next.getNombre() + "\nclub: " + next.getClub()+ 
                                    "\nprovincia: " + next.getProvincia()+ "\nid: " + next.getId());
                        }
                    }
                    else if(opcion.equals("5")){
                        System.out.println("*********************\n"
                                        +  "***LISTAR INMERSIONES***\n"
                                        +  "*********************");
                        List<Inmersion> inmersion = ic.getInmersiones();
                        for (Inmersion next : inmersion) {
                            System.out.println("******Inmersiones******" + "\nlugar: " + next.getLugar()+ "\nDuracion: " + next.getDuracion()+ 
                                    "\nid: " + next.getId() + "\nid monitor: " + next.getIdMonitor());
                        }
                    }
                    else if(opcion.equals("6")){
                        System.out.println("********************\n"
                                        +  "***LISTAR BUCEADORES***\n"
                                        +  "********************");
                        List<Buceadores> buceadores =  bc.getBuceadores();
                        for (Buceadores next : buceadores) {
                            System.out.println("******Buceadores******" + "\nnombre: " + next.getNombre() + "\nTitulo: " + next.getTitulacion()+ 
                                    "\nid: " + next.getId());
                            
                        }
                    }
                    else if(opcion.equals("7")){
                        System.out.println("***************************\n"
                                        +  "***MODIFICAR MONITOR***\n"
                                        +  "***************************");
                        System.out.println("Introduzca el id del monitor que quiere modificar: ");
                        Monitor p = mc.getMonitorById(Integer.parseInt(scan.next()));
                        System.out.println("Introduzca los nuevos datos del monitor"
                                + "\nnombre: ");
                        p.setNombre(scan.next());
                        System.out.println("club: ");
                        p.setClub(scan.next());
                        System.out.println("provincia: ");
                        p.setProvincia(scan.next());
                        mc.modifyMonitor(p);
                    }
                    else if(opcion.equals("8")){
                        System.out.println("************************\n"
                                        +  "***MODIFICAR INMERSION***\n"
                                        +  "************************");
                        System.out.println("Introduzca el id de la inmersión que quiere modificar: ");
                        Inmersion c = ic.getInmersionById(Integer.parseInt(scan.next()));
                        System.out.println("Introduzca los nuevos datos de la inmersion");
                        
                        System.out.println("Introduzca el lugar donde se realizo la inmersion: ");
                        c.setLugar(scan.next());
                        
                        System.out.println("Introduzca la duracion de la inmersion");
                        c.setDuracion(scan.next());
                        
                        System.out.println("Introduzca la id del monitor de la inmersion");
                        c.setIdMonitor(scan.nextInt());
                        
                        ic.AddInmersion(c);
                    }
                    else if(opcion.equals("9")){
                        System.out.println("***********************\n"
                                        +  "***MODIFICAR BUCEADOR***\n"
                                        +  "***********************");
                        System.out.println("Introduzca el id del monitor que quiere modificar: ");
                        Buceadores c = bc.getBuceadorById(Integer.parseInt(scan.next()));
                        System.out.println("Introduzca los nuevos datos del buceador");
                        
                        System.out.println("Introduzca el nombre: ");
                        c.setNombre(scan.next());
                        
                        System.out.println("Introduzca la titulacion: ");
                        c.setTitulacion(scan.next());
                        bc.modifyBuceador(c);
                    }
                    else if(opcion.equals("10")){
                        System.out.println("**********************\n"
                                        +  "***BORRAR MONITOR***\n"
                                        +  "**********************");
                        System.out.println("Introduzca el id del buceador que quiere eliminar: ");
                        
                        mc.deleteMonitor(Integer.parseInt(scan.next()));
                    }
                    else if(opcion.equals("11")){
                        System.out.println("*********************\n"
                                        +  "***BORRAR INMERSION***\n"
                                        +  "*********************");
                        System.out.println("Introduzca el id de la inmersion que quiere eliminar: ");
                        
                        ic.deleteInmersion(Integer.parseInt(scan.next()));
                    }
                    else if(opcion.equals("12")){
                        System.out.println("********************\n"
                                        +  "***BORRAR BUCEADOR***\n"
                                        +  "********************");
                        System.out.println("Introduzca el id del buceador que quiere eliminar: ");
                        
                        bc.deleteBuceador(Integer.parseInt(scan.next()));
                    }
                    else if(opcion.equals("13")){
                        System.out.println("********************\n"
                                        +  "***BUCEADOR REALIZA INMERSION***\n"
                                        +  "********************");
                        System.out.println("Introduzca el id del cliente que quiere que realice la inmersion: ");
                        int idB = scan.nextInt();
                        
                        
                        System.out.println("Introduzca el id de la inmersion que quiere que realice el cliente ");
                        int idI = scan.nextInt();
                        
                        
                        ic.NM(idB, idI);
                        
                        
                    }
                    else if(opcion.equals("14")){
                        System.out.println("***********\n"
                                        +  "***SALIR***\n"
                                        +  "***********");
                    }
        }    
                
    }
    
}