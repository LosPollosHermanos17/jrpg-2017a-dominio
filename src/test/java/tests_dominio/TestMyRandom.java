package tests_dominio;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import dominio.MyRandom;

public class TestMyRandom {

	@Test  
	  public void test() {
	    MyRandom z = new MyRandom();
	    for (int i = 1; i < 3000; i *= 2) {
		      Assert.assertTrue(MyRandom.nextInt(i) == (i - 1));
	  }
	    Assert.assertTrue(0.49 == MyRandom.nextDouble());
	}
}