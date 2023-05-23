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

public class Ram {

    @lombok.Builder.Default
    String ramOption1 = "2 GB";

    @lombok.Builder.Default
    String ramOption2 = "4GB [+$20.00]";

    @lombok.Builder.Default
    String ramOption3 = "8GB [+$60.00]";
}
