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

public class CPU {

    @lombok.Builder.Default
    String cPUOption1 = "2.2 GHz Intel Pentium Dual-Core E2200";

    @lombok.Builder.Default
    String cPUOption2 = "2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]";
}
