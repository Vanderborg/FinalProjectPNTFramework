package nopcommerceobjects;

import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder

public class OS {

    @lombok.Builder.Default
    String oSOption1 = "Vista Home [+$50.00]";

    @lombok.Builder.Default
    String oSOption2 = "Vista Premium [+$60.00]";
}
