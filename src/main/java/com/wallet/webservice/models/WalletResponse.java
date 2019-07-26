package com.wallet.webservice.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class WalletResponse<T> {

    private Boolean success;
    private T content;
    private String error;

}
