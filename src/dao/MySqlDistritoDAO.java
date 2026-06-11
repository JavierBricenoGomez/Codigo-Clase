package dao;

import clases.Distrito;
import interfaces.IDistrito;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.MySqlConexion;

public class MySqlDistritoDAO implements IDistrito{

    @Override
    public int save(Distrito bean) {
     int salida=-1;
     Connection cn=null;
     PreparedStatement pstm=null;
     try{
         cn=MySqlConexion.getConexion();
         String sql="insert into tb_distrito values(?,?)";
         pstm=cn.prepareStatement(sql);
         pstm.setInt(1, bean.getCodigo());
         pstm.setString(2, bean.getNombre());
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
    public int update(Distrito bean) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(int cod) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Distrito> findAll() {
        //para listados registros se trabaja con 3 interfaces del
        //API JDBC
        Connection cn=null;
        PreparedStatement pstm=null;
        ResultSet rs=null;
        //crear objeto de la Colección List y usar el implemetador ArrayList
        List<Distrito> lista=new ArrayList<Distrito>();
        try {
            //PASO 1: obtener conexión de la base de datos
            cn=MySqlConexion.getConexion();
            //PASO 2: sentencia sql
            String sql="select *from tb_distrito";
            //PASO 3: crear instancia del objeto pstm y enviar la variable sql
            pstm=cn.prepareStatement(sql);
            //PASO 4: ejecutar sentencia sql "select ......"
            rs=pstm.executeQuery();
            //PASO 5: bucle para realizar recorrido sobre "rs"
            while(rs.next()){
                //PASO 6: Crear objeto de la clase Distrito
                Distrito dis=new Distrito();
                //PASO 7: asignar valores a los atributos del objeto "dis"
                //        con la fila actual
                dis.setCodigo(rs.getInt(1));//      1 es la columna código
                dis.setNombre(rs.getString(2)); //  2 es la columna nombre
                //PASO 8: adicionar objeto "dis" dentro del arreglo "lista"
                lista.add(dis);
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
