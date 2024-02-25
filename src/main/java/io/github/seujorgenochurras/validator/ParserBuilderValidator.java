package io.github.seujorgenochurras.validator;

import io.github.seujorgenochurras.image.ascii.ParserBuilder;
import io.github.seujorgenochurras.image.ascii.exception.NoSymbolException;

/**
 * A validator for {@link ParserBuilder} fields
 */
public class ParserBuilderValidator {

    /**
     * Validate symbols
     * @param symbols symbols to validate
     * @return builder
     */
    public ParserBuilderValidator validateSymbols(String[] symbols){
        //For now there's only this is the only thing that could break
        //But I'll use a ValidatorChain if later needed
        if(symbols.length < 1){
            throw new NoSymbolException("No symbols provided");
        }
        return this;
    }
}
