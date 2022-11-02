import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ModelImplTest {
  Model models;
  Controller controller;
  View viewer;
  InputStream input;
  OutputStream outStream;

  @Before
  public void setUp(){
    outStream = new ByteArrayOutputStream();
    viewer = new View(new PrintStream(outStream));
    models = new ModelImpl();
  }

  @Test
  public void initialTest(){
    
  }



}