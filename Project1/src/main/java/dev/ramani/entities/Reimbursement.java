package dev.ramani.entities;

import java.text.SimpleDateFormat;

public class Reimbursement {

	private int RID;
	private int EIDRequester;
	private double AMOUNT;
	private String DESCRIPTION;
	//String pattern = "yyyy-MM-dd";
	//private SimpleDateFormat DATE1 = new SimpleDateFormat(pattern);
	private String DATE1;
	private String RSTATUS;
	private String RCOMMENT;
	
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reimbursement(int rID, int eIDRequester, double aMOUNT, String dESCRIPTION, String dATE1, String rSTATUS,
			String rCOMMENT) {
		super();
		RID = rID;
		EIDRequester = eIDRequester;
		AMOUNT = aMOUNT;
		DESCRIPTION = dESCRIPTION;
		DATE1 = dATE1;
		RSTATUS = rSTATUS;
		RCOMMENT = rCOMMENT;
	}

	public int getRID() {
		return RID;
	}

	public void setRID(int rID) {
		RID = rID;
	}

	public int getEIDRequester() {
		return EIDRequester;
	}

	public void setEIDRequester(int eIDRequester) {
		EIDRequester = eIDRequester;
	}

	public double getAMOUNT() {
		return AMOUNT;
	}

	public void setAMOUNT(double aMOUNT) {
		AMOUNT = aMOUNT;
	}

	public String getDESCRIPTION() {
		return DESCRIPTION;
	}

	public void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
	}

	public String getDATE1() {
		return DATE1;
	}

	public void setDATE1(String dATE1) {
		DATE1 = dATE1;
	}

	public String getRSTATUS() {
		return RSTATUS;
	}

	public void setRSTATUS(String rSTATUS) {
		RSTATUS = rSTATUS;
	}

	public String getRCOMMENT() {
		return RCOMMENT;
	}

	public void setRCOMMENT(String rCOMMENT) {
		RCOMMENT = rCOMMENT;
	}

	@Override
	public String toString() {
		return "Reimbursement [RID=" + RID + ", EIDRequester=" + EIDRequester + ", AMOUNT=" + AMOUNT + ", DESCRIPTION="
				+ DESCRIPTION + ", DATE1=" + DATE1 + ", RSTATUS=" + RSTATUS + ", RCOMMENT=" + RCOMMENT + "]";
	}
	
	
	
}
