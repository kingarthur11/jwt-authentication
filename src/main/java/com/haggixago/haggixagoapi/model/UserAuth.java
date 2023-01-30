package com.haggixago.haggixagoapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "\"user_table\"")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserAuth {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String username;
    private String fullname;
    private String email;
    private String phone_number;
    private String password;
//    @ManyToMany(fetch = FetchType.EAGER)
//    private Collection<Role> role = new ArrayList<>();
}
