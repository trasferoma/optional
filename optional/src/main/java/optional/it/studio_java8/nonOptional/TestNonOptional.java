package optional.it.studio_java8.nonOptional;

public class TestNonOptional {

    private Persona persona;

    public static void main(String[] args) {
        TestNonOptional test = new TestNonOptional();

        // test.caricaDati();

        String nomeAssicurazione = getNomeAssicurazione(test.persona);

        System.out.println("======" + nomeAssicurazione);
    }

    private static String getNomeAssicurazione(Persona persona) {
        return persona.getMacchina().getAssicurazione().getNome();
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
