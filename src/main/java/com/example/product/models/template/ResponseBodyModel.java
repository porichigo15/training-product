package com.example.product.models.template;

import lombok.Getter;
import lombok.Setter;

public class ResponseBodyModel<T> {
    @Getter @Setter private Boolean status;
    @Getter @Setter private T objectValue;
}
