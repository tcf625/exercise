package leetcodes.problems;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

/**
 * https://leetcode.com/problemset/all/
 */
public class MakeNewEnv {

    public static void main(final String[] args) throws IOException {
        final int start = 12;
        final int end = start;
        for (int i = start; i <= end; i++) {
            makeFiles(i);
        }
    }

    private static void makeFiles(final int problem) throws IOException {
        final String packageName = String.format("leetcodes.problems.p%04d.v01", problem);
        final File folder = new File("./src/test/java/" + packageName.replaceAll("\\.", "/"));
        final File solutionFile = new File(folder, "Solution.java");
        final File solutionTestFile = new File(folder, String.format("SolutionTest%04d.java", problem));
        if (solutionFile.exists()) {
            return;
        }

        FileUtils.writeStringToFile(solutionFile, "package " + packageName + ";class Solution {}", "UTF-8");

        final String testName = "SolutionTest" + String.format("%04d", problem);

        final StringBuilder tmpS = new StringBuilder();
        tmpS.append("package ").append(packageName).append(";\n");
        tmpS.append("import static org.junit.Assert.*;                                   ").append("\n");
        tmpS.append("import org.junit.Test;                                              ").append("\n");
        tmpS.append("public class " + testName + " {                                         ").append("\n");
        tmpS.append("    Solution target = new Solution();  @Test public void test() {}  ").append("\n");
        tmpS.append("}                                                                   ");

        FileUtils.writeStringToFile(solutionTestFile, tmpS.toString(), "UTF-8");
    }

}
