package cn.mimik.finance.web.controller;

import cn.mimik.finance.constant.RspConstant;
import cn.mimik.finance.domain.UserBastInfoPo;
import cn.mimik.finance.domain.UserLoginInfoPo;
import cn.mimik.finance.service.UserBastInfoService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liugang on 2017/9/18.
 *
 * 用户基本信息
 *
 */
@RestController
@RequestMapping(value = "/userBastInfo")
@Slf4j
public class UserBastInfoController {

    @Autowired
    private UserBastInfoService userBastInfoService;

    /**
     * 获取用户基本信息
     */
    @RequestMapping(value = "query", method= {RequestMethod.GET, RequestMethod.POST} )
    @ApiOperation(value = "获取用户基本信息", notes = "参数描述", code = 200, produces = "application/json")
    public UserBastInfoPo getUserBastInfo(HttpServletRequest request){
        UserLoginInfoPo userLoginInfoPo = (UserLoginInfoPo) request.getSession().getAttribute(RspConstant.SESSION_USER);
        String custNo = userLoginInfoPo.getCustNo();

        UserBastInfoPo paramPo = new UserBastInfoPo();
        paramPo.setCustNo(custNo);
        UserBastInfoPo userBastInfoPo = userBastInfoService.selectUserBastInfo(paramPo);

        return userBastInfoPo;
    }

    /**
     * 添加用户基本信息
     */
    @RequestMapping(value = "/add", method= {RequestMethod.GET, RequestMethod.POST} )
    @ApiOperation(value = "添加用户基本信息", notes = "参数描述", code = 200, produces = "application/json")
    public Object addUserBastInfo(HttpServletRequest request, UserBastInfoPo po){
        UserLoginInfoPo userLoginInfoPo = (UserLoginInfoPo) request.getSession().getAttribute(RspConstant.SESSION_USER);
        String custNo = userLoginInfoPo.getCustNo();
        Map<String, Object> rsp = new HashMap<String, Object>();
        try{
            po.setCustNo(custNo);
            userBastInfoService.insertUserBastInfo(po);
            rsp.put(RspConstant.rspCode, RspConstant.success);
        }catch (Exception e){
            log.error(e.getMessage(), e);
            rsp.put(RspConstant.rspCode, RspConstant.error);
        }
        return rsp;
    }


    /**
     * 删除用户基本信息
     */


    /**
     * 修改用户基本信息
     */
    @RequestMapping(value = "/update", method= {RequestMethod.GET, RequestMethod.POST} )
    @ApiOperation(value = "修改用户基本信息", notes = "参数描述", code = 200, produces = "application/json")
    public Object updateUserBastInfo(HttpServletRequest request, UserBastInfoPo paramPo){
        UserLoginInfoPo userLoginInfoPo = (UserLoginInfoPo) request.getSession().getAttribute(RspConstant.SESSION_USER);
        String custNo = userLoginInfoPo.getCustNo();
        Map<String, Object> rsp = new HashMap<String, Object>();

        UserBastInfoPo wherePo = new UserBastInfoPo();
        wherePo.setCustNo(custNo);
        try{
            userBastInfoService.updateUserBastInfo(paramPo, wherePo);
            rsp.put(RspConstant.rspCode, RspConstant.success);
        }catch (Exception e){
            log.error(e.getMessage(), e);
            rsp.put(RspConstant.rspCode, RspConstant.error);
        }
        return rsp;
    }
}
