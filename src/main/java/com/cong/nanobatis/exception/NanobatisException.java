package com.cong.nanobatis.exception;

/**
 * <p>
 * 自定义异常
 * </p>
 *
 * @author cong
 * @date 2024/04/22
 */
public class NanobatisException extends RuntimeException {
	public NanobatisException(Throwable cause) {
		super(cause);
	}
	public NanobatisException(String message) {
		super(message);
	}
	public NanobatisException(String message, Throwable cause) {
		super(message, cause);
	}
}
