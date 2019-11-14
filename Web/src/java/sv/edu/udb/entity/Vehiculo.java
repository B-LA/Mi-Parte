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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Vehiculo generated by hbm2java
 */
@Entity
@Table(name="vehiculo"
    ,catalog="taller"
    , uniqueConstraints = {@UniqueConstraint(columnNames="placa"), @UniqueConstraint(columnNames="nchasis")} 
)
public class Vehiculo  implements java.io.Serializable {


     private Integer idvehiculo;
     private Cliente cliente;
     private String marca;
     private String modelo;
     private String placa;
     private String color;
     private String nchasis;
     private Set<Caso> casos = new HashSet<Caso>(0);

    public Vehiculo() {
    }

	
    public Vehiculo(String marca, String modelo, String placa, String nchasis) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.nchasis = nchasis;
    }
    public Vehiculo(Cliente cliente, String marca, String modelo, String placa, String color, String nchasis, Set<Caso> casos) {
       this.cliente = cliente;
       this.marca = marca;
       this.modelo = modelo;
       this.placa = placa;
       this.color = color;
       this.nchasis = nchasis;
       this.casos = casos;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idvehiculo", unique=true, nullable=false)
    public Integer getIdvehiculo() {
        return this.idvehiculo;
    }
    
    public void setIdvehiculo(Integer idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idcliente")
    public Cliente getCliente() {
        return this.cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    
    @Column(name="marca", nullable=false, length=30)
    public String getMarca() {
        return this.marca;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }

    
    @Column(name="modelo", nullable=false, length=30)
    public String getModelo() {
        return this.modelo;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    
    @Column(name="placa", unique=true, nullable=false, length=7)
    public String getPlaca() {
        return this.placa;
    }
    
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    
    @Column(name="color", length=25)
    public String getColor() {
        return this.color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }

    
    @Column(name="nchasis", unique=true, nullable=false, length=8)
    public String getNchasis() {
        return this.nchasis;
    }
    
    public void setNchasis(String nchasis) {
        this.nchasis = nchasis;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="vehiculo")
    public Set<Caso> getCasos() {
        return this.casos;
    }
    
    public void setCasos(Set<Caso> casos) {
        this.casos = casos;
    }




}


