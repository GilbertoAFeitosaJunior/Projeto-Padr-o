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
public enum RedeEnum {
    
    PARTICULAR("Particular"),
    PUBLICA("Pública");
    
    private final String name;

    private RedeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    
    
}
