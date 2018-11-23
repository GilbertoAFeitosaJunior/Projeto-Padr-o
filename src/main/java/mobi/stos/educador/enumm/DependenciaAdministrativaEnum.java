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
public enum DependenciaAdministrativaEnum {
    
    ESTADUAL("Estadual"),
    MUNICIPAL("Municipal"),
    FEDERAL("Federal");
    
    private final String name;

    private DependenciaAdministrativaEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    
  
    
}
