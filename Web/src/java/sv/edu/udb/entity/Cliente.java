package sv.edu.udb.entity;
// Generated 13-nov-2019 19:28:16 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Cliente generated by hbm2java
 */
@Entity
@Table(name = "cliente",
         catalog = "taller",
         uniqueConstraints = {
            @UniqueConstraint(columnNames = "nombreusu")
            , @UniqueConstraint(columnNames = "dui")}
)
public class Cliente implements java.io.Serializable {

    @NotNull
    private Integer idcliente;
    @NotBlank(message = "requerido")
    private String nombreusu;
    @NotBlank(message = "requerido")
    private String password;
    @NotBlank(message = "requerido")
    private String nombre;
    @NotBlank(message = "El telefono1 es requerido")
    @Pattern(regexp = "[267][0-9]{3}[0-9]{4}", message = "El telefono no tiene "
            + "el formato correcto")
    private String telefono;
    @Pattern(regexp = "[267][0-9]{3}[0-9]{4}", message = "El telefono no tiene "
            + "el formato correcto")
    private String telefono2;
    @NotBlank(message = "requerido")
    private String direccion;
    @NotBlank(message = "requerido")
    private String dui;
    private Set<Vehiculo> vehiculos = new HashSet<Vehiculo>(0);

    public Cliente() {
    }

    public Cliente(String nombreusu, String password, String nombre, String telefono, String dui) {
        this.nombreusu = nombreusu;
        this.password = password;
        this.nombre = nombre;
        this.telefono = telefono;
        this.dui = dui;
    }

    public Cliente(String nombreusu, String password, String nombre, String telefono, String telefono2, String direccion, String dui, Set<Vehiculo> vehiculos) {
        this.nombreusu = nombreusu;
        this.password = password;
        this.nombre = nombre;
        this.telefono = telefono;
        this.telefono2 = telefono2;
        this.direccion = direccion;
        this.dui = dui;
        this.vehiculos = vehiculos;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "idcliente", unique = true, nullable = false)
    public Integer getIdcliente() {
        return this.idcliente;
    }

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    @Column(name = "nombreusu", unique = true, nullable = false, length = 50)
    public String getNombreusu() {
        return this.nombreusu;
    }

    public void setNombreusu(String nombreusu) {
        this.nombreusu = nombreusu;
    }

    @Column(name = "password", nullable = false, length = 50)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "nombre", nullable = false, length = 50)
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "telefono", nullable = false, length = 8)
    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Column(name = "telefono2", length = 8)
    public String getTelefono2() {
        return this.telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    @Column(name = "direccion", length = 50)
    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Column(name = "dui", unique = true, nullable = false, length = 9)
    public String getDui() {
        return this.dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
    public Set<Vehiculo> getVehiculos() {
        return this.vehiculos;
    }

    public void setVehiculos(Set<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

}
