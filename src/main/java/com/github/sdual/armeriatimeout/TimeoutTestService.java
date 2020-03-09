package com.github.sdual.armeriatimeout;

import com.github.sdual.armeriatimeout.converter.TimeoutRequestConverter;
import com.github.sdual.armeriatimeout.jsonobj.TimeoutParams;
import com.linecorp.armeria.common.HttpParameters;
import com.linecorp.armeria.common.HttpStatus;
import com.linecorp.armeria.server.ServiceRequestContext;
import com.linecorp.armeria.server.annotation.Get;
import com.linecorp.armeria.server.annotation.HttpResult;
import com.linecorp.armeria.server.annotation.Post;
import com.linecorp.armeria.server.annotation.RequestConverter;
import java.util.Optional;

public class TimeoutTestService {

  @Get("/timeout")
  public HttpResult<String> checkTimeout(ServiceRequestContext ctx, HttpParameters parameters) {

    ctx.setRequestTimeoutMillis(20 * 1000);
//
//    try {
//      Thread.sleep(21 * 1000);
//    } catch (InterruptedException e) {
//    }
    System.out.println("get");
    return HttpResult.of(HttpStatus.OK, "OK");
  }

  @Post("/timeout")
  public HttpResult<String> checkTimeoutpsot(ServiceRequestContext ctx,
      @RequestConverter(TimeoutRequestConverter.class) Optional<TimeoutParams> params) {
    //System.out.println(parameters.get("key"));
    System.out.println(params.get().val());
    System.out.println(params.get().val2());
    ctx.setRequestTimeoutMillis(20 * 1000);
//    try {
//      Thread.sleep(21 * 1000);
//    } catch (InterruptedException e) {
//    }
    System.out.println("post");
    return HttpResult.of(HttpStatus.OK, "OK");
  }

}
