package cn.mimik.finance.web.controller;

import cn.mimik.finance.constant.RspConstant;
import cn.mimik.finance.domain.UserAcctInfoPo;
import cn.mimik.finance.domain.UserLoginInfoPo;
import cn.mimik.finance.service.UserAcctInfoService;
import cn.mimik.finance.service.UserLoginInfoService;
import cn.mimik.finance.util.Number;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liugang on 2017/9/18.
 *
 * 用户登录表
 *
 */
@Controller
@RequestMapping("/userLoginInfo")
@Slf4j
public class UserLoginInfoController {

    @Autowired
    private UserLoginInfoService userLoginInfoService;

    @Autowired
    private UserAcctInfoService userAcctInfoService;
    /**
     * 用户登录
     */
    @RequestMapping(value = "/login", method= {RequestMethod.GET, RequestMethod.POST} )
    @ApiOperation(value = "用户登录", notes = "参数描述", code = 200, produces = "application/json")
    public String login(UserLoginInfoPo po, Model model, HttpServletRequest request){
        if(po != null){
            String pwd = po.getPwd();
            UserLoginInfoPo userLoginInfoPo = userLoginInfoService.login(po);
            if(userLoginInfoPo != null && userLoginInfoPo.getPwd().equals(pwd)){
                request.getSession().setAttribute(RspConstant.SESSION_USER, userLoginInfoPo);
                model.addAttribute("name", po.getLoginName());
                return "index";
            }else {
                return "login";
            }
        }else {
            return "login";
        }
    }


    /**
     * 用户注册
     */
    @RequestMapping(value = "register", method= {RequestMethod.GET, RequestMethod.POST} )
    @ApiOperation(value = "用户注册", notes = "参数描述", code = 200, produces = "application/json")
    @ResponseBody
    public Object registUser(UserLoginInfoPo po){
        Map<String, Object> rsp = new HashMap<String, Object>();
        String custNo = Number.generCustNumber();
        try{
            po.setCustNo(custNo);
            po.setRegistDate(new Date());
            userLoginInfoService.registUser(po);

            //添加余额信息
            UserAcctInfoPo userAcctInfoPo = new UserAcctInfoPo();
            userAcctInfoPo.setCustNo(custNo);
            userAcctInfoPo.setAcctBal(new BigDecimal("0.00"));
            userAcctInfoPo.setMemo(po.getLoginName());
            userAcctInfoService.insertUserAcctInfo(userAcctInfoPo);

            rsp.put(RspConstant.rspCode, RspConstant.success);
        }catch (Exception e){
            log.error(e.getMessage(), e);
            rsp.put(RspConstant.rspCode, RspConstant.error);
        }
        return rsp;
    }

    /**
     * 修改登录密码
     */
    @RequestMapping(value = "updatePwd", method= {RequestMethod.GET, RequestMethod.POST} )
    @ApiOperation(value = "修改登录密码", notes = "参数描述", code = 200, produces = "application/json")
    @ResponseBody
    public Object updatePwd(String pwd, HttpServletRequest request){
        Map<String, Object> rsp = new HashMap<String, Object>();
        try{
            UserLoginInfoPo userLoginInfoPo = (UserLoginInfoPo)request.getSession().getAttribute(RspConstant.SESSION_USER);
            userLoginInfoPo.setPwd(pwd);
            userLoginInfoService.updatePwd(userLoginInfoPo);
            rsp.put(RspConstant.rspCode, RspConstant.success);
        }catch (Exception e){
            log.error(e.getMessage(), e);
            rsp.put(RspConstant.rspCode, RspConstant.error);
        }
        return rsp;
    }
}
