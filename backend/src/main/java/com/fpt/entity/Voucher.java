package com.fpt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "voucher")
public class Voucher implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Name invalid!")
    @NotBlank(message = "Name invalid!")
    @Column(name = "name")
    private String name;

    @Column(name = "conditions")
    private BigDecimal conditions;

    @Column(name = "discount")
    private BigDecimal discount;

    @Column(name = "code")
    private String code;

    @NotNull
    @Column(name = "status")
    private Integer status;

    @NotNull
    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @OneToMany(mappedBy = "voucher")
    @JsonIgnore
    private List<Order> orders;
}
