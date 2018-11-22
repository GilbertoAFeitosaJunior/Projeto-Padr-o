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
public enum NivelSecretariaEnum {
    
    ESTADUAL("Estadual"),
    MNICIPAL("Municipal");
    
    private final String name;
    
    private NivelSecretariaEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
}
