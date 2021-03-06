package com.cc.core.wechat.invoke

import com.cc.core.actions.Action
import com.cc.core.actions.ActionResult
import com.cc.core.wechat.HookUtils
import com.cc.core.wechat.Wechat.Hook.Account.*

class GetLoginUserInfoAction : Action {
    override fun execute(actionId : String, vararg args: Any?): ActionResult? {
        val userInfo= com.cc.core.wechat.model.user.User()
        userInfo.setWechatId(HookUtils.getLoginUserWechatId())
        userInfo.setAlias(HookUtils.getLoginUserInfo(UserInfoId_Alias).toString())
        userInfo.setNickname(HookUtils.getLoginUserInfo(UserInfoId_Nickname).toString())
        userInfo.setSignature(HookUtils.getLoginUserInfo(UserInfoId_Signature).toString())
        userInfo.setRegionCode(HookUtils.getLoginUserRegionCode());
        userInfo.setSex(HookUtils.getLoginUserInfo(UserInfoId_Sex, 0) as Int)
        userInfo.setPhone(HookUtils.getLoginUserInfo(UserInfoId_Phone).toString())
        userInfo.setAvatar(HookUtils.Companion.getSelfBigAvatarUrl())
        return ActionResult.successResult(actionId, userInfo)
    }

    override fun key(): String? {
       return "wechat:getLoginUserInfo"
    }
}