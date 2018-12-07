package me.yohom.amapbase.map.handlers.createmap

import com.amap.api.maps.AMap
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import me.yohom.amapbase.map.MapMethodHandler
import me.yohom.amapbase.map.success
import me.yohom.amapbase.common.log

object ShowIndoorMap : MapMethodHandler {

    lateinit var map: AMap

    override fun with(map: AMap): ShowIndoorMap {
        this.map = map
        return this
    }

    override fun onMethodCall(call: MethodCall, result: MethodChannel.Result) {
        val enabled = call.argument<Boolean>("showIndoorMap") ?: false

        log("方法map#showIndoorMap android端参数: enabled -> $enabled")

        map.showIndoorMap(enabled)

        result.success(success)
    }
}