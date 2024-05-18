package org.example.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DBConnection {
    private String url;
    private String username;
    private String password;
}
