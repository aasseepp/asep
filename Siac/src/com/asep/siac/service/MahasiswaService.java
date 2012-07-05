/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asep.siac.service;

import com.asep.siac.entity.Mahasiswa;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class MahasiswaService {

    public MahasiswaService() {
    }
    private final String INSERT_SQL="INSERT INTO mahasiswa (nim, nama, tempat_lahir, tgl_lahir, telepon, alamat) VALUES (?, ?, ?, ?, ?, ?)";
    private final String UPDATE_SQL="UPDATE mahasiswa SET nim=?, nama=?, tempat_lahir=?, tgl_lahir=?, telepon=?, alamat=? where nim=? ";
    private final String DELETE_SQL="DELETE FROM mahasiswa WHERE nim=?";
    private final String SELECT_SQL="SELECT nim, nama, tempat_lahir, tgl_lahir, tetepon, alamat FROM mahasiswa limit ?, ?";
    private final String SELECT_ONE_SQL="SELECT nim, nama, tempat_lahir, tgl_lahir, tetepon, alamat FROM mahasiswa WHERE nim=?";
    private final String COUNT_SQL="SELECT COUNT(nim) AS total FROM mahasiswa";
    
    public void insert(Mahasiswa mahasiswa){
        try(PreparedStatement statement=DatabaseHelper.getConnection().prepareStatement(INSERT_SQL)){
            statement.setString(1, mahasiswa.getNim());
            statement.setString(2, mahasiswa.getNama());
            statement.setString(3, mahasiswa.getTemptLahir());
            statement.setDate(4, new Date(mahasiswa.getTglLahir().getTime()));
            statement.setString(5, mahasiswa.getTelepon());
            statement.setString(6, mahasiswa.getAlamat());
            statement.executeUpdate();
        }catch(Exception e){
            e.getMessage();
        }
    } 
    
     public void update(Mahasiswa mahasiswa){
        try(PreparedStatement statement=DatabaseHelper.getConnection().prepareStatement(UPDATE_SQL)){
            statement.setString(1, mahasiswa.getNim());
            statement.setString(2, mahasiswa.getNama());
            statement.setString(3, mahasiswa.getTemptLahir());
            statement.setDate(4, new Date(mahasiswa.getTglLahir().getTime()));
            statement.setString(5, mahasiswa.getTelepon());
            statement.setString(6, mahasiswa.getAlamat());
            statement.setString(7, mahasiswa.getNim());
            statement.executeUpdate();
        }catch(Exception e){
            e.getMessage();
        }
    } 
     
     public void delete(Mahasiswa mahasiswa){
        try(PreparedStatement statement=DatabaseHelper.getConnection().prepareStatement(DELETE_SQL)){
            statement.setString(1, mahasiswa.getNim());
            statement.executeUpdate();
        }catch(Exception e){
            e.getMessage();
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
         }catch(Exception e){
             e.getMessage();
         }finally{
             return list;
         }
     }
     
     public Mahasiswa select(String nim){
         Mahasiswa mahasiswa = null;
         try(PreparedStatement statement=DatabaseHelper.getConnection().prepareStatement(SELECT_ONE_SQL)){
             statement.setString(1, nim);
             try(ResultSet resultSet=statement.executeQuery()){
                 while(resultSet.next()){
                     mahasiswa=new Mahasiswa();
                     mahasiswa.setNim(resultSet.getString("nim"));
                     mahasiswa.setNama(resultSet.getString("nama"));
                     mahasiswa.setTemptLahir(resultSet.getString("tempat_lahir"));
                     mahasiswa.setTglLahir(resultSet.getDate("tgl_lahir"));
                     mahasiswa.setTelepon(resultSet.getString("telepon"));
                     mahasiswa.setAlamat(resultSet.getString("alamat"));
                 }
             }
         }catch(Exception e){
             e.getMessage();
         }finally{
             return mahasiswa;
         }
     }
     
     public Long count(){
         Long total=0L;
         try(PreparedStatement statement=DatabaseHelper.getConnection().prepareStatement(SELECT_ONE_SQL)){
             try(ResultSet resultSet=statement.executeQuery()){
                 if(resultSet.next()){
                     total=resultSet.getLong("total");
                 }
             }
         }catch(Exception e){
             e.getMessage();
         }finally{
             return total;
         }
     }
}
