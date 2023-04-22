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
public class ComboboxKey {
    Object key;
    Object value;

    public ComboboxKey(Object key, Object value) {
        this.key = key;
        this.value = value;
    }
    
    @Override
    public String toString(){
        return key.toString();
    }
    
    public String getValue(){
        return value.toString();
    }
}
