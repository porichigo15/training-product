package com.example.product.models.template;

import lombok.Getter;
import lombok.Setter;

public class RequestBodyModel<T> {
    @Getter @Setter private String action;
    @Getter @Setter private T objectValue;
}
