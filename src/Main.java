
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        ArbolBinario Arbol1 = new ArbolBinario();
        boolean app=true;
        int ed, datos;
        String x, ced, nom, opcion;

        while(app) {
            opcion = Menu();
            switch (opcion) {
                case "Insertar":
                    datos = Integer.parseInt(JOptionPane.showInputDialog(" Ingrese cantidad de personas: "));
                    for (int i = 0; i < datos; i++) {
                        ced = JOptionPane.showInputDialog(" Ingrese la cedula de la persona " + (i + 1) + ": ");
                        nom = JOptionPane.showInputDialog(" Ingrese el nombre de la persona " + (i + 1) + ": ");
                        ed = Integer.parseInt(JOptionPane.showInputDialog(" Ingrese la edad de la persona " + (i + 1) + ": "));
                        Arbol1.Insertar(ced, nom, ed);
                    }
                    break;

                case "Mostrar en Preorden":
                    if (Arbol1.getRaiz() == null) {
                        JOptionPane.showMessageDialog(null, "\n El arbol esta vacio");
                    } else {
                        System.out.println("\n" + "Datos en preorden: ");
                        Arbol1.Preordenrec(Arbol1.getRaiz());
                    }
                    break;

                case "Mostrar en Inorden":
                    if (Arbol1.getRaiz() == null) {
                        JOptionPane.showMessageDialog(null, " El arbol esta vacio");
                    } else {
                        System.out.println("\n" + "Datos en inorden: ");
                        Arbol1.Inordenrec(Arbol1.getRaiz());
                    }
                    break;

                case "Mostrar en Posorden":
                    if (Arbol1.getRaiz() == null) {
                        JOptionPane.showMessageDialog(null, "\n" + " El arbol esta vacio");
                    } else {
                        System.out.println("\n" + "Datos en posorden: ");
                        Arbol1.Posordenrec(Arbol1.getRaiz());
                    }
                    break;

                case "Eliminar":
                    x = JOptionPane.showInputDialog("\n Digite la cedula del usuario que desea eliminar: ");
                    Arbol1.Eliminar(x);
                    break;
                case "Altura del arbol":
                    Arbol1.Nivel();
                    break;

                case "Buscar un dato":
                    x = JOptionPane.showInputDialog("\n Digite la cedula del usuario que desea buscar: ");
                    if (!Arbol1.Buscardato(x)) {
                        JOptionPane.showMessageDialog(null, " La cedula del usuario no existe");
                    } else {
                        JOptionPane.showMessageDialog(null, " La cedula del usuario " + x + " existe");
                    }
                    break;

                case "Buscar hermanos de un dato":
                    x = JOptionPane.showInputDialog("\n Digite la cedula del usuario al que desea buscar sus hermanos: ");
                    Arbol1.Buscarhermanos(x);
                    break;

                case "Buscar padre de un dato":
                    x = JOptionPane.showInputDialog("\n Digite la cedula del usuario al que desea buscar su Padre: ");
                    Arbol1.Buscarpadre(x);
                    break;

                case "Buscar hijos de un dato":
                    x = JOptionPane.showInputDialog("\n Digite la cedula del usuario al que desea buscar sus hijos: ");
                    Arbol1.Buscarhijos(x);
                    break;

                case "Contar raices del arbol":
                    JOptionPane.showMessageDialog(null,"La cantidad de raices en el arbol es de "+Arbol1.contarraices(Arbol1.getRaiz()) );
                    break;

                case "Nivel de un dato":
                    x = JOptionPane.showInputDialog("\n Digite la cedula del usuario al que desea buscar su nivel: ");
                    Arbol1.niveldato(x);
                    break;
                case "Nodos en un nivel del arbol":
                    if (Arbol1.getRaiz() == null) {
                        JOptionPane.showMessageDialog(null, "El arbol esta vacio");

                    }else{
                        datos = Integer.parseInt(JOptionPane.showInputDialog(" Ingrese nivel de los datos a buscar: "));
                        Arbol1.datosnivel(Arbol1.getRaiz(),datos,1);
                    }

                    break;
                case "Hojas del arbol y su nivel":
                    if (Arbol1.getRaiz() == null) {
                        JOptionPane.showMessageDialog(null, "El arbol esta vacio");

                    }else{
                        Arbol1.mostrarHojasYProfundidad(Arbol1.getRaiz(),1);
                    }
                    break;
                case "Grado de cada Nodo":
                    if (Arbol1.getRaiz() == null) {
                        JOptionPane.showMessageDialog(null, "\n El arbol esta vacio");
                    } else {
                        System.out.println("\n" + "Todos los nodos con su grado: ");
                        Arbol1.gradonodos(Arbol1.getRaiz());
                    }
                    break;

                case "Salir":
                    app=false;
                    System.out.println("Saliendo...");
                    break;
            }
        }

    }

    public static String Menu() {
        String[] Options = {
                "Insertar",
                "Mostrar en Preorden",
                "Mostrar en Inorden",
                "Mostrar en Posorden",
                "Eliminar",
                "Altura del arbol",
                "Buscar un dato",
                "Buscar hermanos de un dato",
                "Buscar padre de un dato",
                "Buscar hijos de un dato",
                "Contar raices del arbol",
                "Nivel de un dato",
                "Nodos en un nivel del arbol",
                "Hojas del arbol y su nivel",
                "Grado de cada Nodo",
                "Salir"
        };

        String Option = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione una Opcion: ",
                "Menu de Arboles Binarios",
                JOptionPane.QUESTION_MESSAGE,
                null,
                Options,
                Options[0]);
        return Option;
    }
}
