package com.bian;

import com.bian.Verticle.MyFirstVerticle;
import io.vertx.core.Vertx;

public class Bootstrap {
    public static void main(String[] args){
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(MyFirstVerticle.class.getName());
    }
}
