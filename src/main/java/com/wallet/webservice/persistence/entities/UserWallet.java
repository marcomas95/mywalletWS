package com.wallet.webservice.persistence.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter @Setter @NoArgsConstructor
public class UserWallet {
    @Id
    private String id;
    @NotNull
    private String username;
    private String name;
    private String surname;
    private List<Expense> expenses;
}
