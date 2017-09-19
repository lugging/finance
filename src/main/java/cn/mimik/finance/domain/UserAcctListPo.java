package cn.mimik.finance.domain;

import lombok.Data;

@Data
public class UserAcctListPo{
	
	private static final long serialVersionUID = 1L;
	
	//alias
	public static final String TABLE_ALIAS = "UserAcctList";
	public static final String ALIAS_TXN_DATE = "txnDate";
	public static final String ALIAS_TXN_TIME = "txnTime";
	public static final String ALIAS_TXN_TYPE = "txnType";
	public static final String ALIAS_CUST_NO = "custNo";
	public static final String ALIAS_TXN_AMT = "txnAmt";
	public static final String ALIAS_TXN_ADDR = "txnAddr";
	public static final String ALIAS_MEMO = "memo";
	


	//columns START
    /**
     * txnDate       db_column: txn_date 
     */ 	
	private java.util.Date txnDate;
    /**
     * txnTime       db_column: txn_time 
     */ 	
	private java.util.Date txnTime;
    /**
	 * 1装修建材 2旅游消费 3 家具家电 4助学进修 5 购车消费 6 婚庆服务 7医疗服务 8 百货消费 9 理财投资 10 生活消费
     * txnType       db_column: txn_type
     */ 	
	private String txnType;
    /**
     * custNo       db_column: cust_no 
     */ 	
	private String custNo;
    /**
     * txnAmt       db_column: txn_amt 
     */ 	
	private java.math.BigDecimal txnAmt;
    /**
     * txnAddr       db_column: txn_addr 
     */ 	
	private String txnAddr;
    /**
     * memo       db_column: memo 
     */ 	
	private String memo;
	//columns END


}

