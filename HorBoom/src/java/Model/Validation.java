/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author BoomGDH559
 */
public class Validation {
    
    public static boolean checkForm(String dormName){
        boolean ck = false;
        if(dormName == null){
            ck = true;
        }
        return ck;
    }
    
}
