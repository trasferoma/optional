package optional.it.studio_java8.optional;

import java.util.Optional;
import lombok.Builder;

@Builder
public class Persona {
    private Macchina macchina;

    public Optional<Macchina> getMacchina() {
        return Optional.ofNullable(macchina);
    }
}
