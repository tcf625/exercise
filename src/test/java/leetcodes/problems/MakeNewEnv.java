package leetcodes.problems;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class MakeNewEnv {

    public static void main(String[] args) throws IOException {

        makeFiles(8);
    }

    private static void makeFiles(int problem) throws IOException {
        String packageName = String.format("leetcodes.problems.p%04d.v01", problem);
        File folder = new File("./src/test/java/" + packageName.replaceAll("\\.", "/"));
        File solutionFile = new File(folder, "Solution.java");
        File solutionTestFile = new File(folder, String.format("SolutionTest%04d.java", problem));
        if (solutionFile.exists()) {
            return;
        }

        FileUtils.writeStringToFile(solutionFile, "package " + packageName + ";class Solution {}", "UTF-8");

        String testName = "SolutionTest" + String.format("%04d", problem);

        StringBuilder tmpS = new StringBuilder();
        tmpS.append("package ").append(packageName).append(";\n");
        tmpS.append("import static org.junit.Assert.*;                                   ").append("\n");
        tmpS.append("import org.junit.Test;                                              ").append("\n");
        tmpS.append("public class " + testName + " {                                         ").append("\n");
        tmpS.append("    Solution target = new Solution();  @Test public void test() {}  ").append("\n");
        tmpS.append("}                                                                   ");

        FileUtils.writeStringToFile(solutionTestFile, tmpS.toString(), "UTF-8");
    }

}
