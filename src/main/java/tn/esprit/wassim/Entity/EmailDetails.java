package tn.esprit.wassim.Entity;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EmailDetails {
    private String recipient;
    private String msgBody;
    private String subject;
}
