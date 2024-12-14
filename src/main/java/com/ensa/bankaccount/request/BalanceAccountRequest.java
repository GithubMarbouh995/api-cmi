package com.ensa.bankaccount.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BalanceAccountRequest {
    private Long accountId;
    private Float amount;
}
