package com.example.waa_final_project.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Like {
    @Id
    long id;
    @OneToOne
    Property property;
    @OneToOne
    Users users;
}
