package miniterminal;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author AndresTCharro
 */
public class MiniTerminal {

    public static void main(String[] args) throws IOException {

        Scanner entrada = new Scanner(System.in);
        File ruta = new File("C:\\Users\\DAW\\Desktop\\Documentos"); //Objeto donde almacenamos la ruta   
        MiniFileManager terminal = new MiniFileManager(ruta); //Objeto de "MiniFileManager" a la cual le pasaremos "ruta"

        boolean salir = false; // variable para aplicarla al " Do While" para salir
        boolean info = false;  // variable que utilizaremos para devolver la "info"  del metodo printList e infoCompleta
        String comando;       //varibale utilizada dentro del "do"

        //  Uitlizamos el "Do While" como cuando lo utilizamos para crear un menu. Asi debe de hacer todo lo que esta dentro del "do" hasta "while(!salir)
        do {
            System.out.print("ubuntu@ubuntu: $ ");
            comando = entrada.nextLine();                           //alamacenamos la entrada en la variable "comando" que es un string 
            String[] Comando = comando.split(" ");                  //En un array de string le pasamos los valores de "comando"
            if (Comando[0].equals("pwd")) {                          //En la primera posición que es la cero, preguntamos si el String es igual a "pwd"
                if (Comando.length <= 1) {                          //Si lo es, hacemos que recorra el array hasta el siguiente array [1]
                    terminal.getPWD();                               //le indicamos que muestre lo indicado en el método getPWD
                }
            }
            if (Comando[0].equals("cd")) {                          //En este "if"  volvemos a preguntarle si el parametro es cd, si lo es vuelve a recorrer 
                if (Comando.length <= 2) {                          //Lo recorre hasta la posición 2 
                    String rutaAlternativa = Comando[1];            // Creamos "rutaAlternatica" y le asignamos la posción [1] en la cual la guardaremos
                    terminal.changeDir(rutaAlternativa);             //Una vez le pasemos el String con la nueca ruta lo almancera en dicha posición 
                }

            }
            if (Comando[0].equals("ls")) {                         //Preguntamos nuevamente hasta que el String que le pasamos  sea igual a "ls"
                if (Comando.length <= 1) {                         //Recorre el array hasta la posición [1]
                    terminal.printList(info);                       //le pamos el método "printList "
                }
            }

            if (Comando[0].equals("ll")) {                          //Volvemos a preguntarle si el String introducido es igual a "ll"            
                if (Comando.length <= 1) {                          //Si lo es recorremos el array hasta la primera posición
                    terminal.infoCompleta(info);                     //le aplicamos el metodo "infoCompleta"
                }
                if (Comando.length <= 2 && Comando.length > 1) {    //Tambien lo recorremos desde la posicon 2 y desde la posicon 1 

                    terminal.infoCompleta(info);                     //Asi logramos aplicarle el método al contenido dentro del array[1]
                }

            }
            if (Comando[0].equals("mkdir")) {                         //Volvemos a comprobar que el String que le psamos sea igual a "mkdir"
                if (Comando.length <= 1) {                               //Si lo es recorremos el array 

                    terminal.crearCarpeta(comando);                 //Creamos la nueva carpeta dentro de la ruta 
                }
            }

            if (Comando[0].equals("rm")) {
                if (Comando.length <= 1) {
                    terminal.borrarCarpeta(comando);
                }

            }

            if (Comando[0].equals("help")) {                        //Nuevamente volvemos a comparar el String hasta que se igual a "help"

                terminal.help();                                     //Mostramos el contenido que tenemos dentro del método help

            }

            if (Comando[0].equals("exit")) {                        // Si el parametro String que introducimos es igual a "exit"

                salir = true;                                  //  le decimos que la la variable "salir" que es un boolean es true salga del programa 

            }
        } while (!salir);                                         //hasta que  salir no sea true el bucle seguira repidiendse al pasarle el true a salir  el progrma termina
    }

}
