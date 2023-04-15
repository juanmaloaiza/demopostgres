package com.example.demo.service.dtos;


import com.example.demo.domain.Yard;
import com.opencsv.bean.CsvBindByPosition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class YardDto {

    private Long id;
    @NotNull(message = "Nombre requerido" )
    @CsvBindByPosition(position = 0)
    private String name;

    @NotNull(message = "Direccion requerido" )
    @CsvBindByPosition(position = 1)
    private String address;

    @NotNull(message = "telefono requerido" )
    @CsvBindByPosition(position = 2)
    private String phone;

    @NotNull(message = "Numero punto venta requerido" )
    @CsvBindByPosition(position = 3)
    private Integer numberPointOfSale;



    public YardDto(Yard yard) {
        this.id=yard.getId();
        this.name = yard.getName();
        this.address = yard.getAddress();
        this.phone = yard.getPhone();
        this.numberPointOfSale = yard.getNumberPointOfSale();
    }

    public Yard toYard ()
    {
        Yard yard = new Yard();
        yard.setId(getId());
        yard.setName(getName());
        yard.setAddress(this.getAddress());
        yard.setPhone(this.getPhone());
        yard.setNumberPointOfSale(this.getNumberPointOfSale());
        return yard;
    }


}
