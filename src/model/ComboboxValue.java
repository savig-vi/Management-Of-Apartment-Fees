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
public class ComboboxValue {
    Object key;
    Object value;

    public ComboboxValue(Object key, Object value) {
        this.key = key;
        this.value = value;
    }
    
    @Override
    public String toString(){
        return value.toString();
    }
    
    public String getKey(){
        return key.toString();
    }
}
