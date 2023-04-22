/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Vitaliy
 */
public class MyCombobox {
    Object key;
    Object value;
    
    public MyCombobox(Object key, Object value){
        this.key = key;
        this.value = value;
    }
    
    @Override
    public String toString(){
        return key.toString();
    }
    
    public String getKey(){
        return key.toString();
    }
    
    public String getValue(){
        return value.toString();
    }
    //Hàm lấy value kiểu int
    public int MaInt(){
        return Integer.parseInt(key.toString());
    }
    
//    //Hàm lấy value kiểu String
//    public String MaString(){
//        return key.toString();
//    }
}
