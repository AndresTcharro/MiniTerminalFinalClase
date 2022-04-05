package miniterminal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author AndresTCharro
 */
public class MiniFileManager {

    File rutaActual = new File("");

    //Constructor 
    public MiniFileManager(File rutaActual) {
        this.rutaActual = rutaActual;
    }

    //Getters&Setters
    public File getRutaActual() {
        return rutaActual;
    }

    public void setRutaActual(File rutaActual) {
        this.rutaActual = rutaActual;
    }

    //Método para que nos muestre la la ruta en la que estamos.
    public String getPWD() throws IOException {

        String ruta = this.rutaActual.getAbsolutePath();//Creamos un "String ruta" para pasarle la direción de la ruta 
        System.out.println(ruta);
        return ruta;
    }

    //Método para cambiar de ruta 
    public boolean changeDir(String ruta) throws FileNotFoundException {
        File nuevaruta = new File(ruta);  //Creamos un nuevo destino donde almacenaremos la ruta que le demos 
        if (!nuevaruta.exists()) {          //Comprobamos primero que esa nueva ruta que le pasamos exista 
            throw new FileNotFoundException("Ruta no valida");
        }
        rutaActual = nuevaruta;             //a la variable ruta le asignamos la nueva ruta
        System.out.println("Se ha cambiado de directorio");
        return true;
    }

    //Método para imprimir el nombre de los directorios y archivos que contiene la ruta en la que estamos.
    public void printList(boolean info) throws FileNotFoundException {
        try {
            String ruta = rutaActual.getAbsolutePath();  //
            System.out.println(ruta);
            File carpeta = new File(ruta);
            if (!carpeta.exists()) {
                throw new FileNotFoundException();
            }
            if (carpeta.isFile()) {  // Si la ruta que le hemos pasado imprimimos el nombre de la ruta 
                //  System.out.println("Nombre de la ruta: " + carpeta.getName());
            }
            if (carpeta.isDirectory()) {   //Creamos "ruta2" para almacenar los directoiros dentro de "carpeta" y que nos muestre su nombre 
                System.out.println("Directorio: " + carpeta.getName());
                for (File ruta2 : carpeta.listFiles()) {
                    if (ruta2.isDirectory()) {
                        System.out.println("Directorio: " + ruta2.getName());

                    }

                    for (File ruta3 : carpeta.listFiles()) {   // //Creamos "ruta3" para almacenar los archivos dentro de "carpeta" y que nos muestre su nombre
                        if (ruta3.isFile()) {
                            System.out.println("Archivo: " + ruta3.getName());
                        }
                    }
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("No hay elemenmtos dentro de la ruta actual");
        }
    }

    //Método de morstrar la información completa utilizamos la estructura anterio, solamente que esta vez le pedimos que nos muestre  el tamaño y la ultima modificación de cada elementos dentro de la ruta
    public void infoCompleta(boolean infoCompleta) throws FileNotFoundException {
        try {
            String ruta = rutaActual.getAbsolutePath();
            System.out.println(ruta);
            File carpeta = new File(ruta);
            if (!carpeta.exists()) {
                throw new FileNotFoundException();
            }
            if (carpeta.isFile()) {
                System.out.println("Nombre: " + carpeta.getName() + "\nTamaño: " + carpeta.length() + "\nÚltima modificación: " + carpeta.lastModified());
            }
            if (carpeta.isDirectory()) {
                System.out.println("Nombre  directorio: " + carpeta.getName() + "\nTamaño: " + carpeta.length() + "\nÚltima modificación: " + carpeta.lastModified());
                for (File ruta2 : carpeta.listFiles()) {
                    if (ruta2.isDirectory()) {
                        System.out.println("Nombre  archivo: " + ruta2.getName() + "\nTamaño: " + ruta2.length() + "\nÚltima modificación: " + ruta2.lastModified());
                    }

                }
                for (File ruta3 : carpeta.listFiles()) {
                    if (ruta3.isFile()) {
                        System.out.println("Nombre directorio: " + ruta3.getName());
                    }

                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("No hay elemenmtos dentro de la ruta actual");
        }
    }

    //Método crear carpeta 
    public boolean crearCarpeta(String ruta) throws FileNotFoundException {

        File Carpeta = new File(ruta);
        if (Carpeta.exists()) {
            throw new FileNotFoundException("El directorio ya existe");  //Si existe lanzamos una Exception 
        }

        if (!Carpeta.exists()) {        //Primero preguntar  que el directorio no exista 
            if (Carpeta.mkdirs()) {     //".mkdirs" para crear el directorio
                System.out.println("Directorio creado");
                return true;
            } else {
                System.out.println("No se ha podido crear el directorio");
                return false;
            }
        }
        return true;
    }

    //Método para borrar un directorio 
    public boolean borrarCarpeta(String ruta) {
        boolean flag = false;
        File Carpeta = new File(ruta);
        if (Carpeta.isFile() && Carpeta.exists()) {
            Carpeta.delete();
            flag = true;
        }
        return flag;
    }

    public void help() {
        System.out.println();
        System.out.println();
        System.out.println("--pwd,        Muestra el directorio de trabajo actual.");
        System.out.println("--cd<DIR>,    Cambia el directorio actual(por omision va al directorio propio.).");
        System.out.println("--ls,         Lista el contenido de directorios o información de archivos.");
        System.out.println("--ll,         Lista en formato largo iformación de archivo o directorio.");
        System.out.println("--mkdir,      Crea el directorio 'nombredir'.");
        System.out.println("--rm,         Suprime archivos.");
        System.out.println("--mv,         Mueve 'arch1' a 'destino'.");
        System.out.println("--help,       Descripción de lo que hace cada comando.");
        System.out.println("--exit,       Salida del Shell.");
        System.out.println();
        System.out.println();
    }

}
