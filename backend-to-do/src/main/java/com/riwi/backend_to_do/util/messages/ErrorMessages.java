package com.riwi.backend_to_do.util.messages;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class ErrorMessages {
    public static String idNotFound(String entity){
        final String message = "There are no records in the entity %s with the supplied id";
        return String.format(message, entity);

    }
}
