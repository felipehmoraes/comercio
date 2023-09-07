package br.edu.utfpr.commerceapi.models;

import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;


import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pacote")
public class Pacote extends BaseEntity {

    //atributs...

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pacote")
    private List<Reserva> reservas = new ArrayList<>();
}
