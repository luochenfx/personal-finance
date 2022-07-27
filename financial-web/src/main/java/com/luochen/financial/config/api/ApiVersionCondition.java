package com.luochen.financial.config.api;

import org.jetbrains.annotations.NotNull;
import org.springframework.web.servlet.mvc.condition.RequestCondition;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApiVersionCondition implements RequestCondition<ApiVersionCondition> {
	private final static Pattern VERSION_PREFIX_PATTERN = Pattern.compile(".*v(\\d+).*");

	private final int apiVersion;

	ApiVersionCondition(int apiVersion) {
		this.apiVersion = apiVersion;
	}

	private int getApiVersion() {
		return apiVersion;
	}


	@NotNull
	@Override
	public ApiVersionCondition combine(ApiVersionCondition apiVersionCondition) {
		return new ApiVersionCondition(apiVersionCondition.getApiVersion());
	}

	@Override
	public ApiVersionCondition getMatchingCondition(HttpServletRequest httpServletRequest) {
		Matcher m = VERSION_PREFIX_PATTERN.matcher(httpServletRequest.getRequestURI());
		if (m.find()) {
			int version = Integer.parseInt(m.group(1));
			if (version >= this.apiVersion) {
				return this;
			}
		}
		return null;
	}

	@Override
	public int compareTo(ApiVersionCondition apiVersionCondition, @NotNull HttpServletRequest httpServletRequest) {
		return apiVersionCondition.getApiVersion() - this.apiVersion;
	}
}
