package cn.mimik.finance.web.controller;

import cn.mimik.finance.constant.RspConstant;
import cn.mimik.finance.domain.UserAcctListPo;
import cn.mimik.finance.domain.UserLoginInfoPo;
import cn.mimik.finance.service.UserAcctListService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liugang on 2017/9/18.
 * 用户资金记录流水表
 *
 */
@RestController
@RequestMapping("/userAcctList")
@Slf4j
public class UserAcctListController {

    @Autowired
    private UserAcctListService userAcctListService;

    /**
     * 新增交易记录
     * @param po
     * @return
     */
    @RequestMapping(value = "add", method= {RequestMethod.GET, RequestMethod.POST} )
    @ApiOperation(value = "查询用户资金账号信息", notes = "参数描述", code = 200, produces = "application/json")
    public Object addUserAcctList(UserAcctListPo po, HttpServletRequest request){
        UserLoginInfoPo userLoginInfoPo = (UserLoginInfoPo) request.getSession().getAttribute(RspConstant.SESSION_USER);
        String custNo = userLoginInfoPo.getCustNo();
        Map<String, Object> rsp = new HashMap<String, Object>();
        try{
            userAcctListService.addUserAcctList(po);
            rsp.put(RspConstant.rspCode, RspConstant.success);
        }catch (Exception e){
            log.error(e.getMessage(), e);
            rsp.put(RspConstant.rspCode, RspConstant.error);
        }
        return rsp;
    }

    /**
     * 查询全部交易记录
     * @return
     */
    @RequestMapping(value = "query", method= {RequestMethod.GET, RequestMethod.POST} )
    @ApiOperation(value = "查询用户资金账号信息", notes = "参数描述", code = 200, produces = "application/json")
    public Object selectUserAcctList(UserAcctListPo po, HttpServletRequest request){
        UserLoginInfoPo userLoginInfoPo = (UserLoginInfoPo) request.getSession().getAttribute(RspConstant.SESSION_USER);
        String custNo = userLoginInfoPo.getCustNo();
        Map<String, Object> rsp = new HashMap<String, Object>();
        try{
            List<UserAcctListPo> userAcctListPoList = userAcctListService.getUserAcctList(po);
            rsp.put(RspConstant.rspCode, RspConstant.success);
            rsp.put("item", userAcctListPoList);
        }catch (Exception e){
            log.error(e.getMessage(), e);
            rsp.put(RspConstant.rspCode, RspConstant.error);
        }
        return rsp;
    }


    /**
     * 删除交易记录
     * @return
     */
    @RequestMapping(value = "delete", method= {RequestMethod.GET, RequestMethod.POST} )
    @ApiOperation(value = "查询用户资金账号信息", notes = "参数描述", code = 200, produces = "application/json")
    public Object deleteUserAcctList(UserAcctListPo po){
        Map<String, Object> rsp = new HashMap<String, Object>();
        try{
            userAcctListService.deleteUserAcctList(po);
            rsp.put(RspConstant.rspCode, RspConstant.success);
        }catch (Exception e){
            log.error(e.getMessage(), e);
            rsp.put(RspConstant.rspCode, RspConstant.error);
        }
        return rsp;
    }

}
