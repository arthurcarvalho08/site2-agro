package com.agromono.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "maquinarios")
public class Maquinario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String modelo;
    private String tipo;
    private Integer horasUso;
    private LocalDate proximaManutencao;
    private Boolean alertaManutencao;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public Integer getHorasUso() { return horasUso; }
    public void setHorasUso(Integer horasUso) { this.horasUso = horasUso; }
    public LocalDate getProximaManutencao() { return proximaManutencao; }
    public void setProximaManutencao(LocalDate proximaManutencao) { this.proximaManutencao = proximaManutencao; }
    public Boolean getAlertaManutencao() { return alertaManutencao; }
    public void setAlertaManutencao(Boolean alertaManutencao) { this.alertaManutencao = alertaManutencao; }
}