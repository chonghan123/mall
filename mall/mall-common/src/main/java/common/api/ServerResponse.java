package common.api;

import lombok.Data;

@Data
public class ServerResponse<T> {

    private Integer code;

    private String message;

    private T data;

    public ServerResponse() {

    }

    public ServerResponse(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ServerResponse<T> success(T data) {

        return new ServerResponse<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    /**
     * 成功返回结果
     *
     * @param data    获取的数据
     * @param message 提示信息
     */
    public static <T> ServerResponse<T> success(T data, String message) {
        return new ServerResponse<T>(ResultCode.SUCCESS.getCode(), message, data);
    }


    public static <T> ServerResponse<T> failed(T data) {

        return new ServerResponse<T>(ResultCode.FAILED.getCode(), ResultCode.FAILED.getMessage(), data);
    }


    /**
     * 失败返回结果
     *
     * @param errorCode 错误码
     */
    public static <T> ServerResponse<T> failed(IErrorCode errorCode) {
        return new ServerResponse<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
     * 失败返回结果
     *
     * @param message 提示信息
     */
    public static <T> ServerResponse<T> failed(String message) {
        return new ServerResponse<T>(ResultCode.FAILED.getCode(), message, null);
    }

    /**
     * 失败返回结果
     */
    public static <T> ServerResponse<T> failed() {
        return failed(ResultCode.FAILED);
    }


}

