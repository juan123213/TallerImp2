import java.util.*;


public class ProcesoInscripciones {

    private HashMap<String,Estudiante> estudiantes;
    private LectorArchivo lector;



    /*
    public List<String> procesarArchivo(String ruta){
    }
     */



    private void procesarLinea(String linea){
        String[] res = linea.split("[,]", 0);
        if (res.length !=4){
            System.exit(1);
        }
        else{
            String cedula=res[0];
            Estudiante estudiante1=buscarEstudiante(cedula);
            if(estudiante1==null){
                System.out.print("no existe el estudiante");
            }else{
                Estudiante nuevoestudiante=new Estudiante(res[1],res[2]);
                estudiantes.put(res[1],estudiante1);
                nuevoestudiante.adicionarMateria(res[3]);
            }
        }

    }

    private Estudiante buscarEstudiante(String cedula){
        for (Map.Entry<String, Estudiante> entry : estudiantes.entrySet()) {
            String key = entry.getKey();
            Estudiante value = entry.getValue();
            if(key==cedula){
                return value;
            }
            else{
                continue;
            }


        }
        return null;
    }
}
