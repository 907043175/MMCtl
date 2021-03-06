package com.cc.core.wechat

import com.cc.core.wechat.model.message.*
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.JsonParseException
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import java.lang.reflect.Type

class MessageTypeAdapter : JsonSerializer<WeChatMessage>, JsonDeserializer<WeChatMessage> {
    override fun serialize(obj: WeChatMessage, interfaceType: Type, context: JsonSerializationContext): JsonElement {
        return context.serialize(obj, interfaceType)
    }

    override fun deserialize(elem: JsonElement, interfaceType: Type, context: JsonDeserializationContext): WeChatMessage {
        val wrapper = elem.getAsJsonObject()

        val messageTypeElem = get(wrapper, "type")
        val messageType = messageTypeElem.getAsInt()

        val actualType = getMessageActualType(messageType)
        return context.deserialize(elem, actualType)
    }

    @Throws(JsonParseException::class)
    private operator fun get(wrapper: JsonObject, memberName: String): JsonElement {
        return wrapper.get(memberName) ?: throw JsonParseException(
                "no '"
                        + memberName
                        + "' member found in what was expected to be an interface wrapper"
        )
    }

    private fun getMessageActualType(type: Int): Type {
        when (type) {
            WeChatMessageType.IMAGE, WeChatMessageType.EMOJI -> return ImageMessage::class.java
            WeChatMessageType.VIDEO -> return VideoMessage::class.java
            WeChatMessageType.TEXT -> return TextMessage::class.java
            WeChatMessageType.CARD -> return CardMessage::class.java
            else -> return UnsupportMessage::class.java
        }
    }
}