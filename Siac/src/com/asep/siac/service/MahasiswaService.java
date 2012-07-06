/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asep.siac.service;


import com.asep.siac.entity.Mahasiswa;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mahasiswa
 */
public class MahasiswaService {

    public MahasiswaService() {
    }
    private final String INSERT_SQL="insert into mahasiswa (nim, nama, tempat_lahir, tgl_lahir, telepon, alamat) values (?, ?, ?, ?, ?, ?)";
    private final String UPDATE_SQL="update mahasiswa set nama=?, tempat_lahir=?, tgl_lahir=?, telepon=?, alamat=? where nim=?";
    private final String DELETE_SQL="delete from mahasiswa where nim=?";
    private final String SELECT_SQL="select nim, nama, tempat_lahir, tgl_lahir, telepon, alamat from mahasiswa limit ?, ? ";
    private final String COUNT_SQL="select count(nim) as total from mahasiswa ";
    private final String SELECT_ONE_SQL="select nim, nama, tempat_lahir, tgl_lahir, telepon, alamat from mahasiswa where nim like ?";
    
    public void insert(Mahasiswa mahasiswa){
        try(PreparedStatement statement=DatabaseHelper.getConnection().prepareStatement(INSERT_SQL)){
            statement.setString(1, mahasiswa.getNim());
            statement.setString(2, mahasiswa.getNama());
            statement.setString(3, mahasiswa.getTemptLahir());
            statement.setDate(4, new Date(mahasiswa.getTglLahir().getTime()));
            statement.setString(5, mahasiswa.getTelepon());
            statement.setString(6, mahasiswa.getAlamat());
            statement.executeUpdate();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void update(Mahasiswa mahasiswa){
        try(PreparedStatement statement=DatabaseHelper.getConnection().prepareStatement(UPDATE_SQL)){
           
            statement.setString(1, mahasiswa.getNama());
            statement.setString(2, mahasiswa.getTemptLahir());
            statement.setDate(3, new Date(mahasiswa.getTglLahir().getTime()));
            statement.setString(4, mahasiswa.getTelepon());
            statement.setString(5, mahasiswa.getAlamat());
             statement.setString(6, mahasiswa.getNim());
            statement.executeUpdate();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void delete(Mahasiswa mahasiswa){
         try(PreparedStatement statement=DatabaseHelper.getConnection().prepareStatement(DELETE_SQL)){
             statement.setString(1, mahasiswa.getNim());
             statement.executeUpdate();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public List<Mahasiswa> select(int skip, int max){
        ArrayList<Mahasiswa> list=new ArrayList<>();
        try(PreparedStatement statement=DatabaseHelper.getConnection().prepareStatement(SELECT_SQL)){
            statement.setInt(1, skip);
            statement.setInt(2, max);
            try(ResultSet resultSet=statement.executeQuery()){
                while(resultSet.next()){
                    Mahasiswa mahasiswa=new Mahasiswa();
                    mahasiswa.setNim(resultSet.getString("nim"));
                    mahasiswa.setNama(resultSet.getString("nama"));
                    mahasiswa.setTemptLahir(resultSet.getString("tempat_lahir"));
                    mahasiswa.setTglLahir(resultSet.getDate("tgl_lahir"));
                    mahasiswa.setTelepon(resultSet.getString("telepon"));
                    mahasiswa.setAlamat(resultSet.getString("alamat"));
                    list.add(mahasiswa);
                }
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally{
            return list;
        }
    }
    
    public Long count(){
        Long total=0L;
        try(PreparedStatement statement=DatabaseHelper.getConnection().prepareStatement(COUNT_SQL);
                ResultSet resultSet=statement.executeQuery()){
            if(resultSet.next()){
                total=resultSet.getLong("total");
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally{
            return total;
        }
    }
    
    public Mahasiswa select(int kode){
        Mahasiswa mahasiswa=null;
        try(PreparedStatement statement=DatabaseHelper.getConnection().prepareStatement(SELECT_ONE_SQL)){
            statement.setInt(1, kode);
            try(ResultSet resultSet=statement.executeQuery()){
                if(resultSet.next()){
                    mahasiswa=new Mahasiswa();
                    mahasiswa.setNim(resultSet.getString("nim"));
                    mahasiswa.setNama(resultSet.getString("nama"));
                    mahasiswa.setTemptLahir(resultSet.getString("tempat_lahir"));
                    mahasiswa.setTglLahir(resultSet.getDate("tgl_lahir"));
                    mahasiswa.setTelepon(resultSet.getString("telepon"));
                    mahasiswa.setAlamat(resultSet.getString("alamat"));
                }
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally{
            return mahasiswa;
        }
    }
    
    
}
