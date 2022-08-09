package optional.it.studio_java8.optional;

import java.util.Optional;

public class AccessoCatena {

    private Persona persona;

    public static void main(String[] args) {
        AccessoCatena accessoCatena = new AccessoCatena();

        accessoCatena.caricaDati();

        Optional<Persona> optionalPersona = accessoCatena.getPersona();

        String nomeAssicurazione = getNomeAssicurazione(optionalPersona);

        System.out.println("======" + nomeAssicurazione);
    }


    private Optional<Persona> getPersona() {
        return Optional.ofNullable(persona);
    }

    private static String getNomeAssicurazione(Optional<Persona> optionalPersona) {
        return optionalPersona.flatMap(Persona::getMacchina)
                .flatMap(Macchina::getAssicurazione)
                .map(Assicurazione::getNome)
                .orElse("Sconosciuto");
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
