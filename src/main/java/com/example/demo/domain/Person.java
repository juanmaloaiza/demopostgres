package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person extends BaseEntity  implements Serializable {


    @NotNull
    @Column (name = "per_documento", length = 15, nullable = false, unique = true)
    private String documentNumber;

    @NotNull
    @Column (name = "per_nombres", length = 50)
    @Size(max = 50, message = "nombre demasiado largo")
    private String firstName;

    @Column (name = "per_apellidos", length = 50)
    @NotNull
    private String lastName;

    @Column (name = "per_direccion", length = 100)
    @NotNull
    private String address;

    @Column (name = "per_telefono", length = 15)
    @NotNull
    private String phone;

    @Column (name = "per_edad", length = 15)
    @NotNull
    private Integer age;


}
