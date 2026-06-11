package interfaces;

import clases.Alumno;
import java.util.List;

public interface IAlumno {
    int save(Alumno bean);
    int update(Alumno bean);
    int delete(int cod);
    List<Alumno> findAll();
}
