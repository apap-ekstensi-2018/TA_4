package com.siperpus.service;

import com.siperpus.model.UserAccountModel;

public interface UserAccountService {
	UserAccountModel selectUserAccount(String username);
}
