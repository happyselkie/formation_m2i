package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import java.util.Date;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ProductFood extends Product{

    Date expirationDate;

}
