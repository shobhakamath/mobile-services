
package com.mobile.application.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Hardware {

    private String audioJack;
    private String gps;
    private String battery;
}
