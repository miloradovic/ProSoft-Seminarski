package domen;

import java.io.Serializable;

/**
 *
 * @author Darko
 */
public enum TipOsiguranja implements Serializable {

    OBAVEZNO("Auto-osiguranje"), 
    KASKO("Kasko"), 
    MINI_KASKO("Mini-kasko"), 
    ZELENA_KARTA("Osiguranje u inostranstvu"), 
    AUTO_NEZGODA("Auto-nezgoda");
    
    private final String osiguranje;
    
    private TipOsiguranja(String osiguranje) {
        this.osiguranje = osiguranje;
    }
}
