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

public class HDD {

    @lombok.Builder.Default
    String hDDOption1 = "320 GB";

    @lombok.Builder.Default
    String hDDOption2 = "400 GB [+$100.00]";
}
