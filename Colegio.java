package clase6;

import clase7_objetos.JavaUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Colegio {

    public static void main(String args[]){

        List<Alumno> listaAlumnos = new ArrayList<>();
        List<Profesor> listaProfesores = new ArrayList<>();

        System.out.println("*************** BIENVENIDO ****************");
        Alumno a1 = new Alumno("Ana Maria", 1111, "Informatica");
        Alumno a2 = new Alumno("Juan Pablo", 222, "Mecanica");

        listaAlumnos.add(a1);
        listaAlumnos.add(a2);

        Profesor profe1 = new Profesor("Jose Rodriguez", 4444, "Quimica");
        Profesor profe2 = new Profesor("Rocio Martinez", 999, "Fisica");

        listaProfesores.add(profe1);
        listaProfesores.add(profe2);

        /*System.out.println("**** PROFESORES *****");
        System.out.println(profe1);
        System.out.println(profe2);

        System.out.println("**** ALUMNOS *****");
        System.out.println(a1);
        System.out.println(a2);*/

        mostrarListaProfesores(listaProfesores);
        mostrarListaAlumnos(listaAlumnos);

        Scanner input = new Scanner(System.in);
        int cantidadAlumnos = JavaUtils.solicitarNumero("Ingrese la cantidad de alumnos a agregar al Sistema:", 1, 100);

        for (int i = 0; i < cantidadAlumnos; i++){
            Alumno alumno = crearAlumno();
            listaAlumnos.add(alumno);
            System.out.println("Alumno ingresado al Sistema");
            System.out.println("");
        }

        mostrarListaAlumnos(listaAlumnos);

        System.out.println("Quiere eliminar algun alumno de la lista? (SI/NO)");
        String respuesta = input.next();

        if (respuesta.toUpperCase().equals("SI") == true){
            System.out.println("Ingrese el nro de estudiante: ");
            int nroEstudiante = input.nextInt();

            int posicion = 0;
            int posicionAlumno = -1;

            for (Alumno alumno: listaAlumnos ) {
                if (alumno.getNroEstudiante() == nroEstudiante){
                    posicionAlumno = posicion;
                } else {
                    posicion++;
                    System.out.println("buscando.......");
                }
            }

            if (posicionAlumno != -1) {
                listaAlumnos.remove(posicionAlumno);
                System.out.println("Se elimino el alumno de la posicion " + posicion);
            }

            mostrarListaAlumnos(listaAlumnos);
        }

        else {
            System.out.println("No se eliminaran alumnos del Sistema");
        }

        System.out.println("El programa ha finalizado....");


    }

    public static void mostrarListaAlumnos(List<Alumno> listaAlumnos){
        System.out.println("***** LISTA DE ALUMNOS ****");
        //for each...
        for (Alumno alumno: listaAlumnos){
            System.out.println(alumno);
        }
    }

    public static void mostrarListaProfesores(List<Profesor> listaProfes){
        System.out.println("***** LISTA DE PROFESORES ****");
        /*for (int i = 0; i < listaProfesores.size(); i++){
            System.out.println("Profe: "+listaProfesores.get(i));
        }*/

        for (Profesor profe: listaProfes){
            System.out.println(profe);
        }
    }

    public static Alumno crearAlumno(){
        Scanner input = new Scanner(System.in);

        System.out.println("Ingrese el nombre del alumno");
        String nombre = input.next();
        System.out.println("Ingrese el dni del alumno");
        int dni = input.nextInt();
        System.out.println("Ingrese el curso del alumno");
        String curso = input.next();

        Alumno alumno = new Alumno(nombre, dni, curso);
        return alumno;
    }

}
