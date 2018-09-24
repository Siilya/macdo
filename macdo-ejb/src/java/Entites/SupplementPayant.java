package Entites;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SupplementPayant implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    
    private String description;
    
    private Float prix;
    
    

    public SupplementPayant() {
    }

    public SupplementPayant(String nom) {
        this.nom = nom;
    }

    public SupplementPayant(String nom, Float prix) {
        this.nom = nom;
        this.prix = prix;
    }

    public SupplementPayant(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }

    public SupplementPayant(String nom, String description, Float prix) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
    }
    
    
    
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }
    
    

    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SupplementPayant)) {
            return false;
        }
        SupplementPayant other = (SupplementPayant) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nom + " "+ prix +'('+id+")";
    }
    
}

/*--------------- CDI1804 --------------- by CL --------------- CDI1804 ---------------*/