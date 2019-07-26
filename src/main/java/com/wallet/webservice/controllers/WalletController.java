package com.wallet.webservice.controllers;

import com.wallet.webservice.models.WalletResponse;
import com.wallet.webservice.persistence.entities.Expense;
import com.wallet.webservice.persistence.entities.UserWallet;
import com.wallet.webservice.persistence.services.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class WalletController {

    @Autowired
    private WalletService walletService;

    @PostMapping("/expense/insertUserExpense/{username}")
    @ResponseBody
    public ResponseEntity<WalletResponse<UserWallet>> insertUserExpense(@RequestBody Expense expense,
                    @PathVariable("username") String username) {
        WalletResponse resp = new WalletResponse<UserWallet>();
        try {
            resp.setContent(this.walletService.insertUserExpense(username, expense));
            resp.setSuccess(Boolean.TRUE);

        } catch (Exception e) {
            resp.setSuccess(Boolean.FALSE);
            resp.setError(e.getMessage());
        }
        return new ResponseEntity<WalletResponse<UserWallet>>(resp, HttpStatus.OK);
    }
    @GetMapping("/expense/insertUser")
    public ResponseEntity<WalletResponse<UserWallet>> insertUser(@RequestParam String username,
                   @RequestParam String name, @RequestParam String surname) {
        WalletResponse resp = new WalletResponse<UserWallet>();
        try {
            resp.setContent(this.walletService.insertUser(username, name, surname));
            resp.setSuccess(Boolean.TRUE);
        } catch (Exception e) {
            resp.setSuccess(Boolean.FALSE);
            resp.setError(e.getMessage());
        }
        return new ResponseEntity<WalletResponse<UserWallet>>(resp, HttpStatus.OK);
    }

    @GetMapping("/expense/getUserWallet/{username}")
    public ResponseEntity<WalletResponse<UserWallet>> getUserWallet(@RequestParam String username) {
        WalletResponse resp = new WalletResponse<UserWallet>();
        resp.setContent(this.walletService.getUserWallet(username));
        resp.setSuccess(Boolean.TRUE);
        return new ResponseEntity<WalletResponse<UserWallet>>(resp, HttpStatus.OK);
    }

}
