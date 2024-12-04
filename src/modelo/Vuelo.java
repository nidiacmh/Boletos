package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Vuelo {
    private UUID id;
    private String origen;
    private String destino;
    private Date fecha;
    private int disponibilidad;

    public Vuelo(String origen, String destino, Date fecha, int disponibilidad) {
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.disponibilidad = disponibilidad;
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(int disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return "Vuelo {" +
                "\n  ID: " + id +
                "\n  Origen: " + origen +
                "\n  Destino: " + destino +
                "\n  Fecha: " + dateFormat.format(fecha) +
                "\n  Disponibilidad: " + disponibilidad + " asientos" +
                "\n}";
    }
}
