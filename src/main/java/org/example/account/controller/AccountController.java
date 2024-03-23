package org.example.account.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.account.domain.Account;
import org.example.account.dto.AccountDto;
import org.example.account.dto.AccountInfo;
import org.example.account.dto.CreateAccount;
import org.example.account.dto.DeleteAccount;
import org.example.account.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping("/account")
    public CreateAccount.Response createAccount(
            @RequestBody @Valid CreateAccount.Request request
            ) {
        AccountDto accountDto = accountService.createAccount(
                request.getUserId(),
                request.getInitialBalance()
        );
        return CreateAccount.Response.from(accountDto);
    }

    @DeleteMapping("/account")
    public DeleteAccount.Response deleteAccount(
            @RequestBody @Valid DeleteAccount.Request request
            ) {
        AccountDto accountDto = accountService.deleteAccount(
                request.getUserId(),
                request.getAccountNumber()
        );
        return DeleteAccount.Response.from(accountDto);
    }

    @GetMapping("/account")
    public List<AccountInfo> getAccountsByUserId(
            @RequestParam("user_id") Long userId
    ) {
        return accountService.getAccountsByUserId(userId)
                .stream().map(accountDto -> AccountInfo.builder()
                        .accountNumber(accountDto.getAccountNumber())
                        .balance(accountDto.getBalance()).build())
                .collect(Collectors.toList());
    }

    @GetMapping("/account/{id}")
    public Account getAccount(@PathVariable Long id) {
        return accountService.getAccount(id);
    }
}
