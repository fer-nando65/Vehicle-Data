package com.kendaraan.dto.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OptionDto {
    private String text;
    private String value;
    private Boolean selected;
}
