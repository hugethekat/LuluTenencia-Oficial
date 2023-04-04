/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.utils;

import java.security.Key;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import javax.crypto.Cipher;
import java.util.Base64;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author xeron
 */

@Converter
public class Encriptador implements AttributeConverter<String, String>{

    private static final String aes = "AES";
    private static final String contra = "contrasenasegura";
    
    private static Key clave;
    
    static{
        try{
            clave = new SecretKeySpec(contra.getBytes(), aes);
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    @Override
    public String convertToDatabaseColumn(String x) {
        try{
            Cipher cifrador = Cipher.getInstance(aes);
            cifrador.init(Cipher.ENCRYPT_MODE, clave);
            byte[] valorEncriptado = cifrador.doFinal(x.getBytes());
            return Base64.getEncoder().encodeToString(valorEncriptado);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public String convertToEntityAttribute(String y) {
        try{
            Cipher cifrador = Cipher.getInstance(aes);
            cifrador.init(Cipher.DECRYPT_MODE, clave);
            byte[] valorDesencriptado = cifrador.doFinal(Base64.getDecoder().decode(y));
            return new String(valorDesencriptado);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
}
