package org.trebol.jpa.entities;

import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.trebol.jpa.GenericEntity;

/**
 *
 * @author Benjamin La Madrid <bg.lamadrid@gmail.com>
 */
@Entity
@Table(name = "customers")
@NamedQueries({ @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c") })
public class Customer
    implements GenericEntity {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "customer_id")
  private Long id;
  @JoinColumn(name = "person_id", referencedColumnName = "person_id", insertable = true, updatable = true)
  @OneToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private Person person;

  public Customer() {
  }

  public Customer(Long customerId, Person person) {
    this.id = customerId;
    this.person = person;
  }

  @Override
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 97 * hash + Objects.hashCode(this.id);
    hash = 97 * hash + Objects.hashCode(this.person);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Customer other = (Customer)obj;
    if (!Objects.equals(this.id, other.id)) {
      return false;
    }
    if (!Objects.equals(this.person, other.person)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Customer{id=" + id +
        ", person=" + person + '}';
  }

}
