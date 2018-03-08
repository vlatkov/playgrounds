package com.playgrounds.domen;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by vlatko on 4.1.18..
 */
@Entity
@Table(name = "playground")
public class Playgrounds implements Serializable {

    static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;


}
