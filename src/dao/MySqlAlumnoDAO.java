package dao;

import clases.Alumno;
import interfaces.IAlumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.MySqlConexion;

public class MySqlAlumnoDAO implements IAlumno{

    @Override
    public int save(Alumno bean) {
        int salida=-1;
     Connection cn=null;
     PreparedStatement pstm=null;
     try{
         cn=MySqlConexion.getConexion();
         String sql="insert into tb_alumno values(?,?,?,?,?,?,?)";
         pstm=cn.prepareStatement(sql);
         pstm.setInt(1, bean.getCodigo());
         pstm.setString(2, bean.getNombre());
         pstm.setString(3, bean.getPaterno());
         pstm.setString(4, bean.getMaterno());
         pstm.setString(6, bean.getDireccion());
         pstm.setInt(7, bean.getCodigoDistrito());
         salida=pstm.executeUpdate();
     } catch (Exception e){
         e.printStackTrace();
     } finally{
         try {
             if(cn!=null) cn.close();
             if(pstm!=null) pstm.close();
         } catch(Exception e){
             e.printStackTrace();
         }
     }
    return salida;
    
    }

    @Override
    public int update(Alumno bean) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(int cod) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Alumno> findAll() {
                Connection cn=null;
        PreparedStatement pstm=null;
        ResultSet rs=null;
        //crear objeto de la Colección List y usar el implemetador ArrayList
        List<Alumno> lista=new ArrayList<Alumno>();
        try {
            //PASO 1: obtener conexión de la base de datos
            cn=MySqlConexion.getConexion();
            //PASO 2: sentencia sql
            String sql="select *from tb_alumno";
            //PASO 3: crear instancia del objeto pstm y enviar la variable sql
            pstm=cn.prepareStatement(sql);
            //PASO 4: ejecutar sentencia sql "select ......"
            rs=pstm.executeQuery();
            //PASO 5: bucle para realizar recorrido sobre "rs"
            while(rs.next()){
                //PASO 6: Crear objeto de la clase Distrito
                Alumno alu=new Alumno();
                //PASO 7: asignar valores a los atributos del objeto "dis"
                //        con la fila actual
                alu.setCodigo(rs.getInt(1));//      1 es la columna código
                alu.setNombre(rs.getString(2)); //  2 es la columna nombre
                alu.setCodigoDistrito(rs.getInt(7));
                alu.setPaterno(rs.getString(3));
                alu.setMaterno(rs.getString(4));
                alu.setDireccion(rs.getString(6));
                //PASO 8: adicionar objeto "dis" dentro del arreglo "lista"
                lista.add(alu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //cerrar conexión con base de datos y liberar recursos
            try {
                if(cn!=null) cn.close();
                if(pstm!=null) pstm.close();
                if(rs!=null) rs.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return lista;
    }
    }
    

