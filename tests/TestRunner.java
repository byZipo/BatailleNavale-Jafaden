package tests;
 
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

 
public class TestRunner {
	public static void main(String[] args) {

		Result resultPortionTest = JUnitCore.runClasses(PortionTest.class);
		for (Failure failure : resultPortionTest.getFailures()) {
			System.out.println(failure.toString());
		}

		Result resultBateauTest = JUnitCore.runClasses(BateauTest.class);
		for (Failure failure : resultBateauTest.getFailures()) {
			System.out.println(failure.toString());
		}

		Result resultJoueurTest = JUnitCore.runClasses(JoueurTest.class);
		for (Failure failure : resultJoueurTest.getFailures()) {
			System.out.println(failure.toString());
		}
		
		Result resultBatailleNavaleTest = JUnitCore.runClasses(BatailleNavaleTest.class);
		for (Failure failure : resultBatailleNavaleTest.getFailures()) {
			System.out.println(failure.toString());
		}


		System.out.println("PortionTest : "+ resultPortionTest.wasSuccessful());
		System.out.println("BateauTest : "+ resultBateauTest.wasSuccessful());
		System.out.println("JoueurTest : "+ resultJoueurTest.wasSuccessful());
		System.out.println("BatailleNavaleTest : "+ resultBatailleNavaleTest.wasSuccessful());
	}
}