package com.user.service.Entites;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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


    @Transient
    private List<Rating>  rating = new ArrayList();

}
