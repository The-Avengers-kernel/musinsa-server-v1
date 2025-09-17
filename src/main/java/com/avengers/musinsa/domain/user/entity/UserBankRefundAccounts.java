package com.avengers.musinsa.domain.user.entity;

import lombok.Getter;

@Getter
public class UserBankRefundAccounts {
    private Integer userBankRefundAccountId;
    private Users user;
    private Long userId;

    private BankNameLists bankNameList;
    private Long bankNameListId;

    private String userBankRefundAccount;
}
