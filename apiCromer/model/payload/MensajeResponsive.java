package com.cromer.apiCromer.model.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
@Data
@AllArgsConstructor
@ToString
@Builder
public class MensajeResponsive implements Serializable {

    private String mensaje;
    private Object object;
}
