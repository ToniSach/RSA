/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsaprueba;

/**
 *
 * @author tonis
 */

import java.util.*;
import java.math.BigInteger;
import java.io.*;

public class RSAPrueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Ventana1 ve = new Ventana1();
        ve.setVisible(true);/**/
        
        Scanner s = new Scanner(System.in);
        RSALogica rsa = new RSALogica(512);
        System.out.println("p: " + rsa.damep() 
                + "\nq: " + rsa.dameq() 
                + "\nn: " + rsa.damen() 
                + "\nphi: " + rsa.damephi() 
                + "\ne: " + rsa.damee() 
                + "\nd: " + rsa.damed());
        System.out.println("Que quieres hacer");
        System.out.println("1-----Encriptar");
        System.out.println("2-----Desencriptar");
        String encodedString;
        BigInteger[] cifrado;
        switch(s.nextInt()){
            case 1:
                s.nextLine();
                System.out.println("Ingresa texto a cifrar");
                String texto = s.nextLine();
                
                System.out.println("Ingresa n:");
                String n2 = s.nextLine();
                
                System.out.println("Ingresa e:");
                String e2 = s.nextLine();
                
                cifrado = rsa.encriptar(texto, n2, e2);
                encodedString = codificar(cifrado);
                System.out.println(encodedString);
                break;
            case 2:
                s.nextLine();
                System.out.println("Ingresa texto cifrado y codificado");
                encodedString = s.nextLine();
                
                cifrado = decodificar(encodedString);
                
                String descifrado = rsa.desencriptar(cifrado);
                System.out.println(descifrado);                
                break;
        }
    }
    
    public static BigInteger[] decodificar(String encodedString){
        String[] inter = encodedString.split(" ");
        
        BigInteger[] cifrado = new BigInteger[inter.length];
        for (int i = 0; i < cifrado.length; i++) {
            cifrado[i] = new BigInteger(inter[i]);
        }
        
        System.out.println(Arrays.toString(cifrado));
        
        return cifrado;
    }
    
    public static String codificar(BigInteger[] cifrado){
        System.out.println(Arrays.toString(cifrado));
        String encodedString = "";
        for (BigInteger cifrado1 : cifrado) {
            encodedString += cifrado1 + " ";
        }
        
        return encodedString;
    }
}