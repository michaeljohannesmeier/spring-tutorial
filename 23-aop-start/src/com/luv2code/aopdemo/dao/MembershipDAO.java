package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	public int addAccount() {
		System.out.println("addAccount in MembershipDAO");
		return 1;
	}
}
