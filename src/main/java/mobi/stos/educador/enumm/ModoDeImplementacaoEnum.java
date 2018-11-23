/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobi.stos.educador.enumm;

/**
 *
 * @author Rafael Bloise
 */
public enum ModoDeImplementacaoEnum {
    
    DIRETO("Direto"),
    INDIRETO("Indireto");
    
    private  final String name;
    
    private ModoDeImplementacaoEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    
    
     public static ModoDeImplementacaoEnum retornaEnumNaPosicao (int posicao){
        return ModoDeImplementacaoEnum.values()[posicao];
    }
    
    
    
}
