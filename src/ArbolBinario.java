import javax.swing.JOptionPane;

public class ArbolBinario {

    private Nodo raiz;

    public ArbolBinario() {
        raiz = null;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public int acum=0;

    public void Preordenrec(Nodo R) {

        if (R != null) {
            System.out.println(R.getCedula() + "   " + R.getNombre() + "   " + R.getEdad());
            Preordenrec(R.getLi());
            Preordenrec(R.getLd());
        }
    }

    public void Inordenrec(Nodo R) {
        if (R != null) {
            Inordenrec(R.getLi());
            System.out.println(R.getCedula() + "   " + R.getNombre() + "   " + R.getEdad());
            Inordenrec(R.getLd());
        }
    }

    public void Posordenrec(Nodo R) {

        if (R != null) {
            Posordenrec(R.getLi());
            Posordenrec(R.getLd());
            System.out.println(R.getCedula() + "   " + R.getNombre() + "   " + R.getEdad());
        }
    }

    public void Insertar(String cedula, String nombre, int edad) {
        Nodo R = raiz, Ant = null;
        boolean sw = false;

        while (R != null && sw == false) {
            Ant = R;
            if (cedula.compareTo(R.getCedula()) > 0) {
                R = R.getLd();
            } else if (cedula.compareTo(R.getCedula()) < 0) {
                R = R.getLi();
            } else {
                sw = true;
            }
        }

        if (sw == true) {
            JOptionPane.showMessageDialog(null, " La cedula ya existe");

        } else {
            R = new Nodo(cedula, nombre, edad);
        }

        if (raiz == null) {
            raiz = R;
        } else {
            if ((cedula.compareTo(Ant.getCedula()) < 0)) {
                Ant.setLi(R);
            } else {
                Ant.setLd(R);
            }
        }
    }

    public void Eliminar(String dato) {
        Nodo Aux = null, B = raiz;
        boolean sw = false;

        while (B != null && sw == false) {
            //Aux = B;
            if (dato.compareTo(B.getCedula()) > 0) {
                Aux = B;
                B = B.getLd();
            } else if (dato.compareTo(B.getCedula()) < 0) {
                Aux = B;
                B = B.getLi();
            } else {
                sw = true;
            }
        }

        if (sw == false) {
            JOptionPane.showMessageDialog(null, " La cedula a eliminar no existe");
        } else {
            if (B.getLd() == null && B.getLi() == null) {
                if (Aux.getLi() == B) {
                    Aux.setLi(null);
                } else {
                    Aux.setLd(null);
                }

            } else if (B.getLi() != null && B.getLd() != null) {
                Nodo P = B.getLi();
                Nodo Antp = P;

                while (P.getLd() != null) {
                    Antp = P;
                    P = P.getLd();
                }
                Antp.setLd(P.getLi());
                B.setCedula(P.getCedula());
                B.setEdad(P.getEdad());
                B.setNombre(P.getNombre());
            } else {
                if (Aux.getLi() == B) {
                    if (B.getLi() == null) {
                        Aux.setLi(B.getLd());
                    } else {
                        Aux.setLi(B.getLi());
                    }
                } else {
                    if (B.getLi() == null) {
                        Aux.setLd(B.getLd());
                    } else {
                        Aux.setLd(B.getLi());
                    }
                }
            }
        }
    }

    public void Nivel() {
        Nodo B = raiz, C = raiz;
        int acum = 0, acum2 = 0, acumf = 0;
        while (B != null) {
            if (B.getLi() == null) {
                B = B.getLd();
                acum++;
            } else {
                B = B.getLi();
                acum++;
            }
        }
        while (C != null) {
            if (C.getLd() == null) {
                C = C.getLi();
                acum2++;
            } else {
                C = C.getLd();
                acum2++;
            }
        }
        if (acum < acum2) {
            acum = acum2;
        }
        JOptionPane.showMessageDialog(null, "\n La altura del arbol es de  " + acum);
    }

    public boolean Buscardato(String dato) {
        Nodo B = raiz;
        boolean sw = false;

        while (B != null && sw == false) {

            if (dato.compareTo(B.getCedula()) > 0) {
                B = B.getLd();
            } else if (dato.compareTo(B.getCedula()) < 0) {
                B = B.getLi();
            } else {
                sw = true;
            }
        }

        return sw;
    }

    public void Buscarhermanos(String dato) {
        Nodo Aux = null, B = raiz;
        boolean sw = false;

        while (B != null && sw == false) {

            if (dato.compareTo(B.getCedula()) > 0) {
                Aux = B;
                B = B.getLd();
            } else if (dato.compareTo(B.getCedula()) < 0) {
                Aux = B;
                B = B.getLi();
            } else {
                sw = true;
            }
        }

        if (sw == false) {
            JOptionPane.showMessageDialog(null, " La cedula no existe");
        } else {
            if (Aux.getLi() == B && Aux.getLd()!=null) {
                JOptionPane.showMessageDialog(null, " El hermano de " + B.getCedula() + " son " + Aux.getLd().getCedula());
            } else if (Aux.getLd() == B &&Aux.getLi()!=null) {
                JOptionPane.showMessageDialog(null, " Los hermanos de " + B.getCedula() + " son " + Aux.getLi().getCedula());
            } else{
                JOptionPane.showMessageDialog(null, " No tiene hermanos");
            }
        }
    }

    public void Buscarpadre(String dato) {
        Nodo Aux = null, B = raiz;
        boolean sw = false;

        while (B != null && sw == false) {

            if (dato.compareTo(B.getCedula()) > 0) {
                Aux = B;
                B = B.getLd();
            } else if (dato.compareTo(B.getCedula()) < 0) {
                Aux = B;
                B = B.getLi();
            } else {
                sw = true;
            }
        }

        if (sw == false) {
            JOptionPane.showMessageDialog(null, " La cedula no existe");
        } else if(Aux.getCedula()!=null) {
            JOptionPane.showMessageDialog(null, " El padre de la cedula " + B.getCedula() + " es " + Aux.getCedula());
        }
        else JOptionPane.showMessageDialog(null, " La raiz no tiene padre");
    }

    public void Buscarhijos(String dato) {
        Nodo B = raiz;
        boolean sw = false;

        while (B != null && sw == false) {

            if (dato.compareTo(B.getCedula()) > 0) {
                B = B.getLd();
            } else if (dato.compareTo(B.getCedula()) < 0) {
                B = B.getLi();
            } else {
                sw = true;
            }
        }

        if (sw == false) {
            JOptionPane.showMessageDialog(null, " La cedula no existe");
        } else {
            if (B.getLi() != null && B.getLd() != null) {
                JOptionPane.showMessageDialog(null, " Los hijos de la cedula " + B.getCedula() + " son " + B.getLi().getCedula() + " y " + B.getLd().getCedula());
            } else if (B.getLi() == null && B.getLd() == null) {
                JOptionPane.showMessageDialog(null, " El nodo no tiene hijos");
            } else if (B.getLi() == null && B.getLd() != null) {
                JOptionPane.showMessageDialog(null, " El hijo derecho de la cedula " + B.getCedula() + " es " + B.getLd().getCedula());
            } else {
                JOptionPane.showMessageDialog(null, " El hijo izquierdo de la cedula " + B.getCedula() + " es " + B.getLi().getCedula());
            }

        }
    }


    public int contarraices(Nodo B) {

        if (B != null) {
            if(B.getLi()!=null || B.getLd()!=null){
                acum++;
            }
            contarraices(B.getLi());
            contarraices(B.getLd());

        }


        return acum;

    }

    public void niveldato(String dato) {
        Nodo B = raiz, C = raiz;
        int j = 0;
        boolean sw = false;
        while (B != null && sw == false) {

            if (dato.compareTo(B.getCedula()) > 0) {
                B = B.getLd();
                j++;
            } else if (dato.compareTo(B.getCedula()) < 0) {
                B = B.getLi();
                j++;
            } else {
                sw = true;
            }
        }

        JOptionPane.showMessageDialog(null, "\n El nivel del nodo es de  " + (j+1));

    }



    public void mostrarHojasYProfundidad(Nodo nodo, int profundidad) {

        if(nodo!=null){
            if (nodo.getLi() == null && nodo.getLd() == null) {
                System.out.println("Hoja  - " + "Nombre: "+nodo.getNombre() + "  Cedula: " + nodo.getCedula() +" Edad: "+ nodo.getEdad() + " Nivel: " + profundidad);
            }

            mostrarHojasYProfundidad(nodo.getLi(), profundidad + 1);
            mostrarHojasYProfundidad(nodo.getLd(), profundidad + 1);
        }

    }

    public void datosnivel(Nodo F,int nivel,int j) {

        if (F!=null){

            if (j==nivel) {
                System.out.println("Nombre: "+F.getNombre() + "  Cedula: " + F.getCedula() +" Edad: "+ F.getEdad() + " Nivel: "+j);
            }

            datosnivel(F.getLi(), nivel,j + 1);
            datosnivel(F.getLd(), nivel,j+ 1);
        }

    }

    void gradonodos(Nodo B) {

        if(B!=null) {
            if(B.getLi()!=null && B.getLd()!=null){
                System.out.println("Nombre: "+B.getNombre() + "  Cedula: " + B.getCedula() +" Edad: "+ B.getEdad() + " Grado: "+2 );
            }
            else if(B.getLi()!=null||B.getLd()!=null){
                System.out.println("Nombre: "+B.getNombre() + "  Cedula: " + B.getCedula() +" Edad: "+ B.getEdad() + " Grado: "+1 );
            }
            else System.out.println("Nombre: "+B.getNombre() + "  Cedula: " + B.getCedula() +" Edad: "+ B.getEdad() + " Grado: "+0 );
            gradonodos(B.getLi());
            gradonodos(B.getLd());

        }


    }

}
