package no.tusla.supplyservice.pact;



import au.com.dius.pact.provider.junit.Consumer;

import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import no.tusla.supplyservice.SupplyserviceApplication;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

@RunWith(PactRunner.class)
@Provider("supplyservice")
@PactFolder("target/test-classes/pacts-dependents")
public class ProducerPactTest {

  // A "source" of the requests
  @TestTarget
  public final Target target = new HttpTarget(8083);

  // The application
  private static ConfigurableApplicationContext application;

  // Start this real application before running tests.
  @BeforeClass
  public static void start(){
    application = SpringApplication.run(SupplyserviceApplication.class);
  }

  // Test that it's running.
  @Test
  public static void running(){
    assert(application.isRunning());
  }

  // Stop it afterwards
  @AfterClass
  public static void stop(){
    application.stop();
  }



  @State("Supplyservice is running")
  public void toDefaultState() {

    //Default state
  }


}

