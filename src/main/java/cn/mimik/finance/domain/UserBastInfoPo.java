package cn.mimik.finance.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


@Data
public class UserBastInfoPo {
	
	private static final long serialVersionUID = 1L;
	
	//alias
	public static final String TABLE_ALIAS = "UserBastInfo";
	public static final String ALIAS_CUST_NO = "custNo";
	public static final String ALIAS_CUST_NAME = "custName";
	public static final String ALIAS_SEX_FLAG = "sexFlag";
	public static final String ALIAS_EMAIL = "email";
	public static final String ALIAS_BIRTHDAY = "birthday";
	public static final String ALIAS_MOBILE = "mobile";
	


	//columns START
    /**
     * custNo       db_column: cust_no 
     */ 	
	private String custNo;
    /**
     * custName       db_column: cust_name 
     */ 	
	private String custName;
    /**
     * sexFlag       db_column: sex_flag 
     */ 	
	private String sexFlag;
    /**
     * email       db_column: email 
     */ 	
	private String email;
    /**
     * birthday       db_column: birthday 
     */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private java.util.Date birthday;
    /**
     * mobile       db_column: mobile 
     */ 	
	private String mobile;
	//columns END


}

