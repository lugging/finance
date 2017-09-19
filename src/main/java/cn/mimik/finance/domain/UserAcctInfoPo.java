package cn.mimik.finance.domain;

import lombok.Data;

@Data
public class UserAcctInfoPo {
	
	private static final long serialVersionUID = 1L;
	
	//alias
	public static final String TABLE_ALIAS = "UserAcctInfo";
	public static final String ALIAS_CUST_NO = "custNo";
	public static final String ALIAS_ACCT_BAL = "acctBal";
	public static final String ALIAS_LAST_BAL = "lastBal";
	public static final String ALIAS_MEMO = "memo";
	


	//columns START
    /**
     * custNo       db_column: cust_no 
     */ 	
	private String custNo;
    /**
     * acctBal       db_column: acct_bal 
     */ 	
	private java.math.BigDecimal acctBal;
    /**
     * lastBal       db_column: last_bal 
     */ 	
	private java.math.BigDecimal lastBal;
    /**
     * memo       db_column: memo 
     */ 	
	private String memo;
	//columns END


}

