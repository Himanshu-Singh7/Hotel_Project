package com.user.service.Entites;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name ="micro_user")
public class User {

    @Id

    @Column(name ="id")
    private String userId;
    @Column(name="userName" ,length =20)
    private String name;
    @Column(name ="Email")
    private String email;
    @Column(name="About")
    private String about;

}
