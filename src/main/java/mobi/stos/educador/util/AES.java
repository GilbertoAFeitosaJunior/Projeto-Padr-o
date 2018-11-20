package mobi.stos.educador.util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Weibson
 */
public class AES {

    public static final String IV = "AAAAAAAAAAAAAAAA";
    public static final String chaveencriptacao = "0987654321HUYTEF";   
    
//    public static void main(String[] args) {
//               try {
//
//            String textopuro = "WELLINGTON SANTOS#0837328732923#0399320238923#092018#123";
//            String chaveencriptacao = "0987654321HUYTEF";
//
//            System.out.println("Texto Puro: " + textopuro);
//
//            byte[] textoencriptado = encrypt(textopuro, chaveencriptacao);
//            System.out.print("Texto Encriptado: ");
//
//            StringBuilder builder = new StringBuilder();
//            for (int i = 0; i < textoencriptado.length; i++) {
//                builder.append(new Integer(textoencriptado[i])).append(":");
//            }
//            System.out.println(builder.toString());
//
//            String textodecriptado = decrypt(textoencriptado, chaveencriptacao);
//
//            System.out.println("Texto Decriptado: " + textodecriptado);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    
    public static byte[] encrypt(String textopuro, String chaveencriptacao) throws Exception {
        Cipher encripta = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec key = new SecretKeySpec(chaveencriptacao.getBytes("UTF-8"), "AES");
        encripta.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(IV.getBytes("UTF-8")));
        return encripta.doFinal(textopuro.getBytes("UTF-8"));
    }

    public static String decrypt(byte[] textoencriptado, String chaveencriptacao) throws Exception {
        Cipher decripta = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec key = new SecretKeySpec(chaveencriptacao.getBytes("UTF-8"), "AES");
        decripta.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(IV.getBytes("UTF-8")));
        return new String(decripta.doFinal(textoencriptado), "UTF-8");
    }
}
