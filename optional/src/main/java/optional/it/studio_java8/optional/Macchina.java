package optional.it.studio_java8.optional;

import java.util.Optional;

@lombok.Builder
public class Macchina {
    private Assicurazione assicurazione;

    public Optional<Assicurazione> getAssicurazione() {
        return Optional.ofNullable(assicurazione);
    }

}
