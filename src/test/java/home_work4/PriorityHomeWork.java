package home_work4;

import org.testng.annotations.Test;

public class PriorityHomeWork {
  /*@Test(priority = 7)
    public void a(){assert true;}

@Test(priority = 6)
public void b(){assert true;}

@Test(priority = 5)
public void c(){assert true;}

@Test(priority = 4)
public void d(){assert true;}

@Test(priority = 3)
public void e(){assert true;}

@Test(priority = 2)
public void f(){assert true;}

@Test(priority = 1)
public void g(){assert true;}*/


  @Test(dependsOnMethods = {"g", "f" ,"e" ,"d", "c","b"}  , alwaysRun = true)
  public void a(){assert true;}

    @Test (dependsOnMethods = {"g", "f" ,"e" ,"d","c"}  , alwaysRun = true)
    public void b(){assert true;}

    @Test  (dependsOnMethods = {"g", "f" ,"e" ,"d"}  , alwaysRun = true)
    public void c(){assert true;}

    @Test  (dependsOnMethods = {"g", "f" ,"e"}  , alwaysRun = true)
    public void d(){assert true;}

    @Test (dependsOnMethods = {"g", "f"}  , alwaysRun = true)
    public void e(){assert true;}

    @Test
    public void f(){assert true;}

    @Test
    public void g(){assert true;}
}
