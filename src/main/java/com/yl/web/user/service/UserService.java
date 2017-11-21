package com.yl.web.user.service;

/**
 * @Description: Created by leon.yan on 2017/11/21.
 */
public class UserService {

    /**
     *  返回 true 表示 用户名密码校验通过； 反之，校验不通过
     * @param userName
     * @param password
     * @return
     */
    public boolean isValidUser(final String userName, final String password) {
        if( (null != userName) && (userName.trim().equals("jsp")) ) {
            if( (null != password) && (password.trim().equals("123")) ) {
                return true;
            }
        }

        return false;
    }

}
