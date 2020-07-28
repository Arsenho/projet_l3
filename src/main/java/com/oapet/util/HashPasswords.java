/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oapet.util;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

/**
 *
 * @author Arseme Vadele
 */
public class HashPasswords {
    
    public static String generateHash(String password){
        String output = null;
        try {
            output = Hashing.sha256().hashString(password, Charsets.UTF_8).toString();
            System.out.println(output);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output;
    }
}
