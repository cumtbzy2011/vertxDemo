package com.bian.Verticle;

import io.vertx.core.Vertx;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;

/**
 * MyFirstVerticle Tester.
 *
 * @author <Authors name>
 * @version 1.0
 */

@RunWith(VertxUnitRunner.class)
public class MyFirstVerticleTest {

    private Vertx vertx;

    @Before
    public void before(TestContext context) throws Exception {
        vertx = Vertx.vertx();
        vertx.deployVerticle(MyFirstVerticle.class.getName(), context.asyncAssertSuccess());
    }

    @After
    public void after(TestContext context) throws Exception {
        vertx.close(context.asyncAssertSuccess());
    }

    /**
     * Method: start()
     */
    @Test
    public void testStart(TestContext context) throws Exception {
        final Async async = context.async();
        vertx.createHttpClient().getNow(8080, "localhost", "/",
          response -> response.handler(body -> {
              context.assertTrue(body.toString().contains("Hello"));
              async.complete();
          }));
    }


} 
