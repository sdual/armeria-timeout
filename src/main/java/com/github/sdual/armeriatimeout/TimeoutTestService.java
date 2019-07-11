package com.github.sdual.armeriatimeout;

import com.linecorp.armeria.common.HttpParameters;
import com.linecorp.armeria.common.HttpStatus;
import com.linecorp.armeria.server.ServiceRequestContext;
import com.linecorp.armeria.server.annotation.Get;
import com.linecorp.armeria.server.annotation.HttpResult;

public class TimeoutTestService {

  @Get("/timeout")
  public HttpResult<String> checkTimeout(ServiceRequestContext ctx, HttpParameters parameters) {
    ctx.setRequestTimeoutMillis(20 * 1000);
    try {
      Thread.sleep(21 * 1000);
    } catch (InterruptedException e) {
    }
    return HttpResult.of(HttpStatus.OK, "OK");
  }

}
