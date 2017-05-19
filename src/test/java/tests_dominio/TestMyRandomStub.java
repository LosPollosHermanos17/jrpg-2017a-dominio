package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.MyRandomStub;
import dominio.RandomGenerator;

public class TestMyRandomStub {

    @Test
    public void test() {
        RandomGenerator r = new MyRandomStub(4);  
        double d = r.nextDouble();
        Assert.assertEquals(4.0, r.nextDouble(),0.001);
        Assert.assertEquals(4, r.nextInt(4));
    }
}