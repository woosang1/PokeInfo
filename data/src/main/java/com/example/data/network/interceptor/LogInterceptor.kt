package com.example.data.network.interceptor

import com.example.data.log.logDebug
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import okio.Buffer
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class LogInterceptor : Interceptor {
    companion object {
        private const val TAG = "RetrofitLog"
        private const val REQUEST_LOG_STRING = ".\n" +
            "-----------------------------------------\n" +
            "RequestMethod : %s\n" +
            "RequestUrl : %s\n" +
            "RequestBody : %s\n\n" +
            "----- Request headers ----- \n%s-----------------------------------------\n\n" +
            "current Thread : %s\n" +
            "Response code : %d\n\n" +
            "----- ResponseBody ----- \n%s\n" +
            "-----------------------------------------\n."
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder().build()
        val response = chain.proceed(request)
        val bodyString = response.body?.string().toString()
        logDebug(String.format(
            REQUEST_LOG_STRING,
            request.method,
            request.url,
            bodyToString(request),
            request.headers,
            Thread.currentThread().name,
            response.code,
            try {
                JSONObject(bodyString).toString(4)
                    .replace("\\", "\"")
                    .replace("\"/\"", "/")
                    .replace("\"/", "/")
            } catch (e: JSONException) {
                bodyString
            }
        ))

        return response.newBuilder()
            .body(bodyString.toResponseBody(response.body?.contentType()))
            .build()
    }


    /**
     * 리스폰스바디의 값 가져오기
     *
     * @param request 가져와야할 리퀘스트
     * @return 바디 값
     */
    private fun bodyToString(request: Request): String? {
        return try {
            val copy = request.newBuilder().build()
            val buffer = Buffer()
            copy.body?.writeTo(buffer).toString()
            buffer.readUtf8()
        } catch (e: IOException) {
            "did not work"
        } catch (e: NullPointerException) {
            "did not have body"
        }
    }
}
