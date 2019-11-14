package sv.edu.udb.entity;
// Generated 13-nov-2019 19:28:16 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Bitacora generated by hbm2java
 */
@Entity
@Table(name="bitacora"
    ,catalog="taller"
)
public class Bitacora  implements java.io.Serializable {


     private Integer idbitacora;
     private Caso caso;
     private String titulo;
     private String contenido;
     private int avance;
     private byte[] img;

    public Bitacora() {
    }

	
    public Bitacora(Caso caso, String titulo, String contenido, int avance) {
        this.caso = caso;
        this.titulo = titulo;
        this.contenido = contenido;
        this.avance = avance;
    }
    public Bitacora(Caso caso, String titulo, String contenido, int avance, byte[] img) {
       this.caso = caso;
       this.titulo = titulo;
       this.contenido = contenido;
       this.avance = avance;
       this.img = img;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idbitacora", unique=true, nullable=false)
    public Integer getIdbitacora() {
        return this.idbitacora;
    }
    
    public void setIdbitacora(Integer idbitacora) {
        this.idbitacora = idbitacora;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idcaso", nullable=false)
    public Caso getCaso() {
        return this.caso;
    }
    
    public void setCaso(Caso caso) {
        this.caso = caso;
    }

    
    @Column(name="titulo", nullable=false, length=50)
    public String getTitulo() {
        return this.titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    
    @Column(name="contenido", nullable=false, length=1000)
    public String getContenido() {
        return this.contenido;
    }
    
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    
    @Column(name="avance", nullable=false)
    public int getAvance() {
        return this.avance;
    }
    
    public void setAvance(int avance) {
        this.avance = avance;
    }

    
    @Column(name="img")
    public byte[] getImg() {
        return this.img;
    }
    
    public void setImg(byte[] img) {
        this.img = img;
    }




}


