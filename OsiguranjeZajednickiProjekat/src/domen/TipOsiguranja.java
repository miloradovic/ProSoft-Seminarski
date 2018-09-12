package domen;

import java.io.Serializable;

/**
 *
 * @author Darko
 */
public enum TipOsiguranja implements Serializable {

    OBAVEZNO("Auto-odgovornost"),
    KASKO("Kasko"),
    MINI_KASKO("Mini-kasko"),
    ZELENA_KARTA("Osiguranje u inostranstvu"),
    AUTO_NEZGODA("Auto-nezgoda"),
    POMOC_NA_PUTU("Pomoc na putu");

    private final String osiguranje;

    private TipOsiguranja(String osiguranje) {
        this.osiguranje = osiguranje;
    }

    public String getOsiguranje() {
        return osiguranje;
    }

    @Override
    public String toString() {
        return osiguranje;
    }
       
}
