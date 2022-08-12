package optional.it.studio_java8.optional;

import java.util.Optional;

public class CalcolaAssicurazione {

    private Persona persona;

    public static void main(String[] args) {
        CalcolaAssicurazione accessoCatena = new CalcolaAssicurazione();

        accessoCatena.caricaDati();

        Optional<Persona> optionalPersona = accessoCatena.getPersona();
        Optional<Macchina> optionalMacchina = accessoCatena.getMacchina(optionalPersona);

        calcolaAssicurazione(optionalPersona, optionalMacchina);
    }

    private static Optional<Assicurazione> calcolaAssicurazione(Optional<Persona> optionalPersona, Optional<Macchina> optionalMacchina) {
        return optionalPersona
                .flatMap(p -> optionalMacchina.map(m -> calcola(p, m)));

    }


    private static Assicurazione calcola(Persona p, Macchina m) {
        // TODO Auto-generated method stub
        return null;
    }


    private Optional<Persona> getPersona() {
        return Optional.ofNullable(persona);
    }

    private Optional<Macchina> getMacchina(Optional<Persona> optionalPersona) {
        return optionalPersona.flatMap(Persona::getMacchina);
    }

    private void caricaDati() {
        Assicurazione assicurazione = Assicurazione.builder()
                .nome("Alliance")
                .build();

        Macchina macchina = Macchina.builder()
                .assicurazione(assicurazione)
                .build();

        persona = Persona.builder()
                .macchina(macchina)
                .build();
    }
}
