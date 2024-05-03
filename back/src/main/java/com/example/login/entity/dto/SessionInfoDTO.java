package com.example.login.entity.dto;


public class SessionInfoDTO {
    private Integer intentoFallido;
    private java.sql.Date fechaIngreso;
    private java.sql.Date fechaCierre;

    // Constructor, getters y setters
    public SessionInfoDTO(Integer intentoFallido, java.sql.Date fechaIngreso, java.sql.Date fechaCierre) {
        this.intentoFallido = intentoFallido;
        this.fechaIngreso = fechaIngreso;
        this.fechaCierre = fechaCierre;
    }

    public Integer getIntentoFallido() {
        return intentoFallido;
    }

    public void setIntentoFallido(Integer intentoFallido) {
        this.intentoFallido = intentoFallido;
    }

    public java.sql.Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(java.sql.Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public java.sql.Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(java.sql.Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }
}