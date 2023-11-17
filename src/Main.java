
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        ArbolBinario Arbol1 = new ArbolBinario();
        int opcion, ed, datos;

        String x, ced, nom, menu
                = "MENU\n"
                + "1): Insertar\n"
                + "2): Mostrar en Preorden\n"
                + "3): Mostrar en Inorden\n"
                + "4) Mostrar en Posorden\n"
                + "5) Eliminar\n"
                + "6) Altura del arbol\n"
                + "7) Buscar un dato\n"
                + "8) Buscar hermanos de un dato\n"
                + "9) Buscar padre de un dato\n"
                + "10) Buscar hijos de un dato\n"
                + "11) Contar raices del arbol\n"
                + "12) Nivel de un dato\n"
                + "13) Nodos en un nivel del arbol\n"
                + "14) Hojas del arbol y su nivel\n"
                + "15) Grado de cada Nodo\n"
                + "0) Salir\n"
                + "Digite la opción: ";

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (opcion) {
                case 1:
                    datos = Integer.parseInt(JOptionPane.showInputDialog(" Ingrese cantidad de personas: "));
                    for (int i = 0; i < datos; i++) {
                        ced = JOptionPane.showInputDialog(" Ingrese la cedula de la persona " + (i + 1) + ": ");
                        nom = JOptionPane.showInputDialog(" Ingrese el nombre de la persona " + (i + 1) + ": ");
                        ed = Integer.parseInt(JOptionPane.showInputDialog(" Ingrese la edad de la persona " + (i + 1) + ": "));
                        Arbol1.Insertar(ced, nom, ed);
                    }
                    break;

                case 2:
                    if (Arbol1.getRaiz() == null) {
                        JOptionPane.showMessageDialog(null, "\n El arbol esta vacio");
                    } else {
                        System.out.println("\n" + "Datos en preorden: ");
                        Arbol1.Preordenrec(Arbol1.getRaiz());
                    }
                    break;

                case 3:
                    if (Arbol1.getRaiz() == null) {
                        JOptionPane.showMessageDialog(null, " El arbol esta vacio");
                    } else {
                        System.out.println("\n" + "Datos en inorden: ");
                        Arbol1.Inordenrec(Arbol1.getRaiz());
                    }
                    break;

                case 4:
                    if (Arbol1.getRaiz() == null) {
                        JOptionPane.showMessageDialog(null, "\n" + " El arbol esta vacio");
                    } else {
                        System.out.println("\n" + "Datos en posorden: ");
                        Arbol1.Posordenrec(Arbol1.getRaiz());
                    }
                    break;

                case 5:
                    x = JOptionPane.showInputDialog("\n Digite la cedula del usuario que desea eliminar: ");
                    Arbol1.Eliminar(x);
                    break;
                case 6:
                    Arbol1.Nivel();
                    break;

                case 7:
                    x = JOptionPane.showInputDialog("\n Digite la cedula del usuario que desea buscar: ");
                    if (Arbol1.Buscardato(x) == false) {
                        JOptionPane.showMessageDialog(null, " La cedula del usuario no existe");
                    } else {
                        JOptionPane.showMessageDialog(null, " La cedula del usuario " + x + " existe");
                    }
                    break;

                case 8:
                    x = JOptionPane.showInputDialog("\n Digite la cedula del usuario al que desea buscar sus hermanos: ");
                    Arbol1.Buscarhermanos(x);
                    break;

                case 9:
                    x = JOptionPane.showInputDialog("\n Digite la cedula del usuario al que desea buscar su Padre: ");
                    Arbol1.Buscarpadre(x);
                    break;

                case 10:
                    x = JOptionPane.showInputDialog("\n Digite la cedula del usuario al que desea buscar sus hijos: ");
                    Arbol1.Buscarhijos(x);
                    break;

                case 11:
                    JOptionPane.showMessageDialog(null,"La cantidad de raices en el arbol es de "+Arbol1.contarraices(Arbol1.getRaiz()) );
                    break;

                case 12:
                    x = JOptionPane.showInputDialog("\n Digite la cedula del usuario al que desea buscar su nivel: ");
                    Arbol1.niveldato(x);
                    break;
                case 13:
                    if (Arbol1.getRaiz() == null) {
                        JOptionPane.showMessageDialog(null, "El arbol esta vacio");

                    }else{
                        datos = Integer.parseInt(JOptionPane.showInputDialog(" Ingrese nivel de los datos a buscar: "));
                        Arbol1.datosnivel(Arbol1.getRaiz(),datos,1);
                    }

                    break;
                case 14:
                    if (Arbol1.getRaiz() == null) {
                        JOptionPane.showMessageDialog(null, "El arbol esta vacio");

                    }else{
                        Arbol1.mostrarHojasYProfundidad(Arbol1.getRaiz(),1);
                    }
                    break;
                case 15:
                    if (Arbol1.getRaiz() == null) {
                        JOptionPane.showMessageDialog(null, "\n El arbol esta vacio");
                    } else {
                        System.out.println("\n" + "Todos los nodos con su grado: ");
                        Arbol1.gradonodos(Arbol1.getRaiz());
                    }
                    break;

                case 0:
                    System.exit(0);

                default:
                    JOptionPane.showMessageDialog(null, "\n Opcion invalida");
                    break;
            }
        } while (opcion != 0);

    }

}
