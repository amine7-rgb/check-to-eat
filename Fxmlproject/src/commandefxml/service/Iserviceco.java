/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandefxml.service;


import java.util.List;
/**
 *
 * @author User
 */
public interface Iserviceco<T> {
    
        void insert(T t);
     void update(T t);
     void updateperId(int value1, String value2, String value3, int value4 );
      List<T>read();
       void delete(int id);
      T readById(int id);
    
}
