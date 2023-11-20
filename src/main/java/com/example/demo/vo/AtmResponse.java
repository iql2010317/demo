package com.example.demo.vo;

import com.example.demo.constants.RtnCode;
import com.example.demo.entity.Atm;

public class AtmResponse {

	private Atm atm;

	private RtnCode rtncode;

	public AtmResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AtmResponse(Atm atm, RtnCode rtncode) {
		super();
		this.atm = atm;
		this.rtncode = rtncode;
	}

	public Atm getAtm() {
		return atm;
	}

	public void setAtm(Atm atm) {
		this.atm = atm;
	}

	public RtnCode getRtncode() {
		return rtncode;
	}

	public void setRtncode(RtnCode rtncode) {
		this.rtncode = rtncode;
	}

}
