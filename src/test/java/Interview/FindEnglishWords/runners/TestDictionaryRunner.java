package Interview.FindEnglishWords.runners;

import org.junit.runner.notification.Failure;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class TestDictionaryRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(DictionaryRunner.class);

        // print passed tests
        System.out.println("Passed: " + result.wasSuccessful() + " counted " + result.getRunCount() + " tests");

        // print failed tests
        for (Failure failure : result.getFailures()){
            System.out.println(failure.toString());
        }
    }
}
