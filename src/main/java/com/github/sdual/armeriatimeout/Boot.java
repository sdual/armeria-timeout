package com.github.sdual.armeriatimeout;


import com.linecorp.armeria.server.Server;
import com.linecorp.armeria.server.ServerBuilder;

public class Boot {

  public static void main(String[] args) {

    final int port = 8080;

    ServerBuilder sb = Server.builder();
    sb.http(port);

//    sb.requestTimeoutMillis(1000 * 2);
    sb.annotatedService(new TimeoutTestService());

    Server server = sb.build();
    server.start().join();
  }

}
