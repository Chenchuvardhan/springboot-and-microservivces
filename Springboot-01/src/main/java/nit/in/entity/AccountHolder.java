package nit.in.entity;


import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Jpa_BankAccountHolder")
public class AccountHolder {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer accountHolderId;
	private String accountHolderName;
	private Long accountNumber;
	@OneToMany(mappedBy = "accountHolder",cascade = CascadeType.ALL)
	private Set<BankAccount> bankAccounts;
}
