package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BatailleNavaleTest.class, BateauTest.class, JoueurTest.class,
		PortionTest.class })
public class AllTests {

}
