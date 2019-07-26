package com.wallet.webservice.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Expense {
    @NotNull(message = "Tag can't be null.")
    private String tag;
    @NotNull(message = "Cost can't be null.")
    private Double cost;
    private LocalDateTime date;

    @Override
    public String toString() {
        return String.format("[id=%s, tag=%s, cost=%s, date=%s]", tag, cost.toString(), date.toString());
    }
}
