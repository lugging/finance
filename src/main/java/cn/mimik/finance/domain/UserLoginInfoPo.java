package cn.mimik.finance.domain;

import lombok.Data;

@Data
public class UserLoginInfoPo {
	
	private static final long serialVersionUID = 1L;
	
	//alias
	public static final String TABLE_ALIAS = "UserLoginInfo";
	public static final String ALIAS_CUST_NO = "custNo";
	public static final String ALIAS_PWD = "pwd";
	public static final String ALIAS_REGIST_DATE = "registDate";
	public static final String ALIAS_MEMO = "memo";
	


	//columns START
    /**
     * custNo       db_column: cust_no 
     */ 	
	private String custNo;
    /**
     * pwd       db_column: pwd 
     */ 	
	private String pwd;

	/**
	 * login
	 */
	private String loginName;
    /**
     * registDate       db_column: regist_date 
     */ 	
	private java.util.Date registDate;
    /**
     * memo       db_column: memo 
     */ 	
	private String memo;
	//columns END


}

