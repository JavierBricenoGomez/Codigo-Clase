package interfaces;

import clases.Distrito;
import java.util.List;

public interface IDistrito {
    //definir métodos
    //método save que recibe como parámetro un objeto de la clase
    //Alumno y retorna un entero
    int save(Distrito bean);
    int update(Distrito bean);
    int delete(int cod);
    List<Distrito> findAll();
}
