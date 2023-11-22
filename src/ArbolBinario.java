import javax.swing.JOptionPane;

public class ArbolBinario {

    private Nodo Raiz;
    public String Name;

    public ArbolBinario() {
        this.Raiz = null;
    }
    public ArbolBinario(String Name) {
        this.Name=Name;
        this.Raiz = null;
    }

    public Nodo getRaiz() {
        return Raiz;
    }

    public int acum=0;

    public void Preorder(Nodo R) {
        if (R != null) {
            System.out.println(R.getCedula() + "   " + R.getNombre() + "   " + R.getEdad());
            Preorder(R.getLi());
            Preorder(R.getLd());
        }
    }

    public void Inorder(Nodo R) {
        if (R != null) {
            this.Inorder(R.getLi());
            System.out.println(R.getCedula() + "   " + R.getNombre() + "   " + R.getEdad());
            this.Inorder(R.getLd());
        }
    }

    public void Postorder(Nodo R) {

        if (R != null) {
            this.Postorder(R.getLi());
            this.Postorder(R.getLd());
            System.out.println(R.getCedula() + "   " + R.getNombre() + "   " + R.getEdad());
        }
    }

    public void Insert(String cedula, String nombre, int edad) {
        Nodo R = Raiz, Ant = null;
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

        if (Raiz == null) {
            Raiz = R;
        } else {
            if ((cedula.compareTo(Ant.getCedula()) < 0)) {
                Ant.setLi(R);
            } else {
                Ant.setLd(R);
            }
        }
    }

    public void Delete(String dato) {
        Nodo Aux = null, B = Raiz;
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

    public void Level() {
        Nodo B = Raiz, C = Raiz;
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

    public boolean SearchData(String dato) {
        Nodo B = Raiz;
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

    public void SearchBrothers(String dato) {
        Nodo Aux = null, B = Raiz;
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

    public void SearchParent(String dato) {
        Nodo Aux = null, B = Raiz;
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

    public void SearchChild(String dato) {
        Nodo B = Raiz;
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


    public int CountRoots(Nodo B) {

        if (B != null) {
            if(B.getLi()!=null || B.getLd()!=null){
                acum++;
            }
            this.CountRoots(B.getLi());
            this.CountRoots(B.getLd());

        }


        return acum;

    }

    public void LevelData(String dato) {
        Nodo B = Raiz, C = Raiz;
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



    public void TreeLeaves(Nodo nodo, int profundidad) {

        if(nodo!=null){
            if (nodo.getLi() == null && nodo.getLd() == null) {
                System.out.println("Hoja  - " + "Nombre: "+nodo.getNombre() + "  Cedula: " + nodo.getCedula() +" Edad: "+ nodo.getEdad() + " Nivel: " + profundidad);
            }

            TreeLeaves(nodo.getLi(), profundidad + 1);
            TreeLeaves(nodo.getLd(), profundidad + 1);
        }

    }

    public void DataByLevel(Nodo F, int nivel, int j) {

        if (F!=null){

            if (j==nivel) {
                System.out.println("Nombre: "+F.getNombre() + "  Cedula: " + F.getCedula() +" Edad: "+ F.getEdad() + " Nivel: "+j);
            }

            DataByLevel(F.getLi(), nivel,j + 1);
            DataByLevel(F.getLd(), nivel,j+ 1);
        }

    }

    void GradeNodes(Nodo B) {

        if(B!=null) {
            if(B.getLi()!=null && B.getLd()!=null){
                System.out.println("Nombre: "+B.getNombre() + "  Cedula: " + B.getCedula() +" Edad: "+ B.getEdad() + " Grado: "+2 );
            }
            else if(B.getLi()!=null||B.getLd()!=null){
                System.out.println("Nombre: "+B.getNombre() + "  Cedula: " + B.getCedula() +" Edad: "+ B.getEdad() + " Grado: "+1 );
            }
            else System.out.println("Nombre: "+B.getNombre() + "  Cedula: " + B.getCedula() +" Edad: "+ B.getEdad() + " Grado: "+0 );
            GradeNodes(B.getLi());
            GradeNodes(B.getLd());

        }


    }

}
