package com.clpa_partners.gestion_bibliotheque_clap_partner.domain;

import com.clpa_partners.gestion_bibliotheque_clap_partner.entity.Address;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="author")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Author {

  private int authorId;
  private String authorName;
  private Address authoAddress;
  @ManyToOne
    @JoinColumn(name="bookId", nullable=false, insertable = false, updatable = false)
    private Book book;

}
