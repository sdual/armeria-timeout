package com.github.sdual.armeriatimeout;

//import com.github.sdual.armeriatimeout.converter.TimeoutRequestConverter;
//import com.github.sdual.armeriatimeout.jsonobj.TimeoutParams;
//import com.linecorp.armeria.common.HttpParameters;
import com.linecorp.armeria.common.HttpStatus;
import com.linecorp.armeria.common.QueryParams;
import com.linecorp.armeria.common.logging.RequestLogProperty;
import com.linecorp.armeria.server.ServiceRequestContext;
import com.linecorp.armeria.server.annotation.Get;
import com.linecorp.armeria.server.annotation.HttpResult;
import com.linecorp.armeria.server.annotation.Post;
import com.linecorp.armeria.server.annotation.RequestConverter;
import java.util.Optional;

public class TimeoutTestService {


  @Get("/timeout")
  public HttpResult<String> checkTimeout(ServiceRequestContext ctx, QueryParams parameters) {

    // 0.95.0からtimeoutが効かない
    //DefaultServiceRequestContext ctx2 = (DefaultServiceRequestContext) ServiceRequestContext.current();
//
//    long requestStartTimeMillis = ctx.log().ensureAvailable(RequestLogProperty.REQUEST_START_TIME)
//        .requestStartTimeMillis();

    // https://github.com/line/armeria/issues/2535
    //ctx.setRequestTimeoutAtMillis(requestStartTimeMillis + 3 * 1000);
    ServiceRequestContext.current().setRequestTimeoutAfterMillis(2 * 1000);
    // ctx.setRequestTimeoutAfterMillis(2 * 1000);


    System.out.println(ctx.requestTimeoutMillis());
    try {
      Thread.sleep(20 * 1000);
    } catch (InterruptedException e) {
    }
    System.out.println("get");
    return HttpResult.of(HttpStatus.OK, "OK");
  }

//  @Post("/timeout")
//  public HttpResult<String> checkTimeoutpsot(ServiceRequestContext ctx,
//      @RequestConverter(TimeoutRequestConverter.class) Optional<TimeoutParams> params) {
//    //System.out.println(parameters.get("key"));
//    System.out.println(params.get().val());
//    System.out.println(params.get().val2());
//    ctx.setRequestTimeoutMillis(20 * 1000);
////    try {
////      Thread.sleep(21 * 1000);
////    } catch (InterruptedException e) {
////    }
//    System.out.println("post");
//    return HttpResult.of(HttpStatus.OK, "OK");
//  }

}
