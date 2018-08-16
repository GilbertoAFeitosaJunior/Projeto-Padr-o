
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Weibson
 */
public class Main {

    public static void main(String[] args) throws Exception {

        String text = "{\n"
                + "   \"destination_addresses\" : [\n"
                + "      \"Condomínio do Edf Maisson Matisse - Rua Inhuma, 47 - Madalena, Recife - PE, 50000-000, Brasil\"\n"
                + "   ],\n"
                + "   \"origin_addresses\" : [\n"
                + "      \"R. João Fernandes Viêira, 180 - Boa Vista, Recife - PE, 50050-200, Brasil\"\n"
                + "   ],\n"
                + "   \"rows\" : [\n"
                + "      {\n"
                + "         \"elements\" : [\n"
                + "            {\n"
                + "               \"distance\" : {\n"
                + "                  \"text\" : \"2,4 km\",\n"
                + "                  \"value\" : 2390\n"
                + "               },\n"
                + "               \"duration\" : {\n"
                + "                  \"text\" : \"9 minutos\",\n"
                + "                  \"value\" : 536\n"
                + "               },\n"
                + "               \"status\" : \"OK\"\n"
                + "            }\n"
                + "         ]\n"
                + "      }\n"
                + "   ],\n"
                + "   \"status\" : \"OK\"\n"
                + "}";

        JSONObject json = new JSONObject(text);
        System.out.println(json.toString());
        System.out.println(json.getString("status"));

        JSONObject elements = json.getJSONArray("rows").getJSONObject(0);
        JSONArray array = elements.getJSONArray("elements");
        System.out.println(array.getJSONObject(0).getJSONObject("distance").getDouble("value"));
        System.out.println(array.getJSONObject(0).getJSONObject("duration").getLong("value"));

//        String asterico = "*";
//        StringBuilder builder = new StringBuilder();
//        String cartao = "9999 8888 7777 6666";
//        for (int i = 0; i < (cartao.length() - 4); i++) {
//            if (Character.isWhitespace(cartao.charAt(i))) {
//                builder.append(" ");
//            } else {
//                builder.append(asterico);
//            }
//        }
//        builder.append(cartao.substring(cartao.length() - 4));
//
//        System.out.println(cartao);
//        System.out.println(builder.toString());
////        String key = Util.md5(String.valueOf(Calendar.getInstance().getTimeInMillis())).substring(0, 16);
//
//        System.out.println("key: " + key);
//
//        String hash = "WEIBSON S SANTOS|07375446431|9999 8888 7777 6666|11|2020|982";
//        byte[] bytes = AES.encrypt(hash, key);
//        System.out.print("Texto Encriptado: ");
//        StringBuilder builder = new StringBuilder();
//        for (int i = 0; i < bytes.length; i++) {
//            if (builder.length() > 0) {
//                builder.append(" ");
//            }
//            builder.append(new Integer(bytes[i]));
//        }
//        System.out.println(builder.toString());
//        String textodecriptado = AES.decrypt(bytes, key);
//        System.out.println("Texto Decriptado: " + textodecriptado);
//
//        StringTokenizer tokenizer = new StringTokenizer(builder.toString(), " ");
//        System.out.println("tokens: " + tokenizer.countTokens());
//        bytes = new byte[tokenizer.countTokens()];
//        
//        int index = 0;
//        while (tokenizer.hasMoreElements()) {
//            bytes[index] = new Integer(tokenizer.nextToken()).byteValue();
//            index++;
//        }
//        String decrypt = AES.decrypt(bytes, key);
//        System.out.println(decrypt);
    }

}
