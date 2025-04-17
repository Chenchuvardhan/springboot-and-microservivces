package nit.in.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Jpa_BankAccounts")
public class BankAccount {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer bankId;
private String bankName;
@ManyToOne
@JoinColumn(name="accountHolderId")
private AccountHolder accountHolder;
}
