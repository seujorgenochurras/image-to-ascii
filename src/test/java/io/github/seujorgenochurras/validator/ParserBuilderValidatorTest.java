package io.github.seujorgenochurras.validator;

import io.github.seujorgenochurras.image.ascii.exception.NoSymbolException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParserBuilderValidatorTest {

    @Test
    void givenValidator_whenHasNoSymbols_thenThrowNoSymbolsException() {
        ParserBuilderValidator validator = new ParserBuilderValidator();

        assertThrows(NoSymbolException.class, () -> validator.validateSymbols(new String[0]));
    }
}
