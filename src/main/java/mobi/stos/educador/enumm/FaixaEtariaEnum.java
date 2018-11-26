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
public enum FaixaEtariaEnum {
    
    INTANTIL("Infantil"),
    FUNDAMENTAL("Fundamental"),
    MEDIO("Médio");
    
    private final String name;
    
    private FaixaEtariaEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    
       public static FaixaEtariaEnum retornaEnumNaPosicao (int posicao){
        return FaixaEtariaEnum.values()[posicao];
    }
    
    
}
