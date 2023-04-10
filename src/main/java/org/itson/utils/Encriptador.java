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
 * Clase que permite encriptar datos
 *
 * @author Hugo Navarro (233470)/Jorge Sánchez(233012)
 */
@Converter
public class Encriptador implements AttributeConverter<String, String> {

    private static final String aes = "AES";

    private static Key clave;

    /**
     *Constructor por omisión de la clase Encriptador
     */
    public Encriptador() {

    }

    static {
        try {
            clave = new SecretKeySpec(getContra().getBytes(), aes);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Método que desencripta lo recibido en el parámetro
     *
     * @param x Cadena de texto que será desencriptado
     * @return cadena de texto con lo recibido ya desencriptado
     */
    @Override
    public String convertToDatabaseColumn(String x) {
        try {
            Cipher cifrador = Cipher.getInstance(aes);
            cifrador.init(Cipher.ENCRYPT_MODE, clave);
            byte[] valorEncriptado = cifrador.doFinal(x.getBytes());
            return Base64.getEncoder().encodeToString(valorEncriptado);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Método que encripta los datos recibidos en el parámetro
     *
     * @param y Cadena de texto que será encriptada
     * @return cadena de texto con lo recibido ya encriptado
     */
    @Override
    public String convertToEntityAttribute(String y) {
        try {
            Cipher cifrador = Cipher.getInstance(aes);
            cifrador.init(Cipher.DECRYPT_MODE, clave);
            byte[] valorDesencriptado = cifrador.doFinal(Base64.getDecoder().decode(y));
            return new String(valorDesencriptado);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Regresa la contraseña con la que se encriptan los datos
     *
     * @return contraseña que se usa para encriptar
     */
    public static String getContra() {
        String contra = "contrasenasegura";
        return contra;

    }
}
