package com.github.sdual.armeriatimeout.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.sdual.armeriatimeout.jsonobj.TimeoutParams;
import com.linecorp.armeria.common.AggregatedHttpRequest;
import com.linecorp.armeria.server.ServiceRequestContext;
import com.linecorp.armeria.server.annotation.RequestConverterFunction;
import java.util.Optional;

public class TimeoutRequestConverter implements RequestConverterFunction {

  private final ObjectMapper mapper = new ObjectMapper();

  @Override
  public Optional<TimeoutParams> convertRequest(ServiceRequestContext ctx, AggregatedHttpRequest request,
      Class<?> expectedResultType) throws Exception {
    return Optional.of(mapper.readValue(request.contentUtf8(), TimeoutParams.class));
  }

}
