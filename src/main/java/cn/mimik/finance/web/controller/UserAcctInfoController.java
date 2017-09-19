package cn.mimik.finance.web.controller;

import cn.mimik.finance.constant.RspConstant;
import cn.mimik.finance.domain.UserAcctInfoPo;
import cn.mimik.finance.domain.UserLoginInfoPo;
import cn.mimik.finance.service.UserAcctInfoService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

/**
 * Created by liugang on 2017/9/18.
 */
@RestController
@RequestMapping("/userAcctInfo")
@Slf4j
public class UserAcctInfoController {

    @Autowired
    private UserAcctInfoService userAcctInfoService;

    /**
     * 获取用户资金账号信息
     */
    @RequestMapping(value = "query", method= {RequestMethod.GET, RequestMethod.POST} )
    @ApiOperation(value = "查询用户资金账号信息", notes = "参数描述", code = 200, produces = "application/json")
    public UserAcctInfoPo getUserAcctInfo(HttpServletRequest request){
        UserLoginInfoPo userLoginInfoPo = (UserLoginInfoPo) request.getSession().getAttribute(RspConstant.SESSION_USER);
        String custNo = userLoginInfoPo.getCustNo();
        UserAcctInfoPo userAcctInfoPo = new UserAcctInfoPo();
        userAcctInfoPo.setCustNo(custNo);

        userAcctInfoPo = userAcctInfoService.selectUserAcctInfo(userAcctInfoPo);
        return userAcctInfoPo;
    }

    @RequestMapping(value = "update", method= {RequestMethod.GET, RequestMethod.POST} )
    @ApiOperation(value = "更新用户资金账号信息", notes = "参数描述 type[D 余额增加， C 余额减少]", code = 200, produces = "application/json")
    public void updateUserAcctInfo(HttpServletRequest request, String amt, String type){
        UserLoginInfoPo userLoginInfoPo = (UserLoginInfoPo) request.getSession().getAttribute(RspConstant.SESSION_USER);
        String custNo = userLoginInfoPo.getCustNo();
        UserAcctInfoPo wherePo = new UserAcctInfoPo();
        wherePo.setCustNo(custNo);

        try{
            UserAcctInfoPo paramPo = userAcctInfoService.selectUserAcctInfo(wherePo);

            BigDecimal bigAmt = new BigDecimal(amt);
            BigDecimal acctbal = paramPo.getAcctBal();
            if(type.equals("D")){ // 余额增加
                acctbal = acctbal.add(bigAmt);
            }else if(type.equals("C")){ // 余额减少
                acctbal = acctbal.subtract(bigAmt);
            }
            paramPo.setAcctBal(acctbal);
            userAcctInfoService.updateUserAcctInfo(paramPo);
        }catch (Exception e){
            log.error(e.getMessage(), e);
        }
    }

}
