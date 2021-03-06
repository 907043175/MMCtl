package com.cc.core.wechat.model.message

import com.cc.core.wechat.WeChatMessageType
import com.google.gson.annotations.SerializedName

class UnsupportMessage : BaseMessage(WeChatMessageType.UNKNOWN) {
    @SerializedName("messageDetails")
    private var messageDetails: String? = null
    @SerializedName("content")
    private var content: String? = null

    fun setMessageDetails(messageDetails: String?) {
        this.messageDetails = messageDetails
    }

    fun getMessageDetails(): String? {
        return messageDetails
    }

    fun getContent(): String? {
        return content
    }

    fun setContent(content: String?) {
        this.content = content
    }
}