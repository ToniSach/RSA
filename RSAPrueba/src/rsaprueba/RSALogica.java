/*
 //vamos a crear una clase que se encargue de realizar el calculo de 
 //los numeros primos y primos relativos del algoritmo RSA
 */
package rsaprueba;

/**
 *
 * @author tonis
 */
import java.util.*;
import java.math.BigInteger;
import java.io.*;

public class RSALogica {

    //variables

    int tamPrimo;
    BigInteger p, q, n;
    BigInteger phi;
    BigInteger e, d;

    //constructor de la clase
    public RSALogica(int tamPrimo) {
        this.tamPrimo = tamPrimo;
        generarPrimos();
        generarClaves();
    }

    //generar los primos
    public void generarPrimos() {
        p = new BigInteger(tamPrimo, 10, new Random());
        do {
            q = new BigInteger(tamPrimo, 10, new Random());
        } while (q.compareTo(p) == 0);

        //wiii ya tengo mis numerotes 
    }

    //vamos a generar las claves
    public void generarClaves() {
        // n = p*q

        n = p.multiply(q);

        //phi = (p-1)*(q-1)
        phi = p.subtract(BigInteger.valueOf(1)); //p-1

        phi = phi.multiply(q.subtract(BigInteger.valueOf(1)));

        //ahora hay que calcular el coprimo para e a partir del mcd
        do {
            e = new BigInteger(2 * tamPrimo, new Random());
        } while (((e.compareTo(phi)) != -1) || (e.gcd(phi).compareTo(BigInteger.valueOf(1)) != 0
        ));
        
            //calcular a d = e^ 1 mod(phi)
        d = e.modInverse(phi);

    }
/*
    //cifrar
    public BigInteger[] encriptar(String mensaje, String n) {
        //variables
        int i;
        byte[] temp = new byte[1];
        byte[] digitos = mensaje.getBytes();
        BigInteger[] bigdigitos = new BigInteger[digitos.length];
        BigInteger n2 = new BigInteger(n);

        //lo primero es recorrer a bigdigitos para integrarlos al temporal
        for (i = 0; i < bigdigitos.length; i++) {
            temp[0] = digitos[i];
            bigdigitos[i] = new BigInteger(temp);
        }

        BigInteger[] cifrado = new BigInteger[bigdigitos.length];

        //ahora que se el tamaño vamos a cifrarlo
        for (i = 0; i < bigdigitos.length; i++) {
            //ciframos
            cifrado[i] = bigdigitos[i].modPow(e, n2);
        }

        return (cifrado);
    }

    //descifrar
    public String desencriptar(BigInteger[] cifrado) {
        
        BigInteger[] descifrado = new BigInteger[cifrado.length];

        //primero tenemos que recorrerlo
        for (int i = 0; i < descifrado.length; i++) {
            //aplicado el descifrado
            descifrado[i] = cifrado[i].modPow(d, n);
        }

        //vamos a necesitar un arreglo de caracteres para toda la informacion
        char[] charArray = new char[descifrado.length];

        for (int i = 0; i < charArray.length; i++) {
            charArray[i] = (char) (descifrado[i].intValue());
        }
        return (new String(charArray));
    }
    */
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public BigInteger[] encriptar(String mensaje, String n, String e){
        //variables
        int i; 
        byte[] temp = new byte[1];
        byte[] digitos = mensaje.getBytes();
        BigInteger[] bigdigitos = new BigInteger[digitos.length];
        BigInteger n2 = new BigInteger(n);
        BigInteger e2 = new BigInteger(e);

        //lo primero es recorrer a bigdigitos para integrarlos al temporal
        for(i = 0; i < bigdigitos.length; i++){
            temp[0] = digitos[i];
            bigdigitos[i] = new BigInteger(temp);
            System.out.println(bigdigitos[i].toString());
        }

        BigInteger[] cifrado = new BigInteger[bigdigitos.length];
        System.out.println(Arrays.toString(bigdigitos));
        //ahora que se el tamaño vamos a cifrarlo
        for(i = 0; i < bigdigitos.length; i++){
            //ciframos
            cifrado[i] = bigdigitos[i].modPow(e2, n2);
        }

        return (cifrado);
    }
    
    public String desencriptar(BigInteger[] cifrado){

        BigInteger[] descifrado = new BigInteger[cifrado.length];
        //primero tenemos que recorrerlo

        for(int i = 0; i < descifrado.length; i++){
            //aplicado el descifrado
            descifrado[i] = cifrado[i].modPow(d,n);
            System.out.println(descifrado[i]);
        }

        //vamos a necesitar un arreglo de caracteres para toda la informacion
        char[] charArray = new char[descifrado.length];

        for(int i = 0; i < charArray.length; i++){
            charArray[i] = (char)(descifrado[i].intValue()); 
        }
        return (new String(charArray));
    }
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    
    
    //los metodos para enviar p, q, n, phi, e, d
    public BigInteger damep() {
        return p;
    }

    public BigInteger dameq() {
        return q;
    }

    public BigInteger damephi() {
        return phi;
    }

    public BigInteger damen() {
        return n;
    }

    public BigInteger damee() {
        return e;
    }

    public BigInteger damed() {
        return d;
    }

}
