package com.pryabykh.onetomanyassotiation.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "petitions")
public class Petition implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @JsonIgnoreProperties({"petition", "user"})
    @OneToMany(mappedBy = "petition", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Signature> signatures = new ArrayList<>();

    public void addSignature(Signature signature) {
        signature.setPetition(this);
        signatures.add(signature);
    }

    public void removeSignature(Signature signature) {
        signatures.remove(signature);
        signature.setPetition(null);
    }

    public void removeSignatures() {
        for (Signature signature : new ArrayList<>(signatures)) {
            removeSignature(signature);
        }
    }
}
