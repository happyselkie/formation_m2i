package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ProductElectronic extends Product{

    private int autonomy;

}
