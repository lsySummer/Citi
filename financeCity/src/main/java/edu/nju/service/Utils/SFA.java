package edu.nju.service.Utils;

import org.python.core.*;
import org.python.util.PythonInterpreter;

import java.io.*;
import java.util.*;

/**
 * Created by Sun YuHao on 2016/8/24.
 */
public class SFA {
    static public Double getFundScore(Double[] lnrpt, Double[] lnrmt, Double[] SBInvestRatio,
                               Double[] fundScale, Double[] ALRatioin, Double[] institutionRatio) {

        List<List<Double>> list = new ArrayList<>();
        list.add(Arrays.asList(lnrpt));
        list.add(Arrays.asList(lnrmt));
        list.add(Arrays.asList(SBInvestRatio));
        list.add(Arrays.asList(fundScale));
        list.add(Arrays.asList(ALRatioin));
        list.add(Arrays.asList(institutionRatio));

        System.out.println(list);

        return PythonInvoker.call(list);
    }

    static public Double getFundScore(List<Double> lnrpt, List<Double> lnrmt, List<Double> SBInvestRatio,
                                      List<Double> fundScale, List<Double> ALRatioin, List<Double> institutionRatio) {
        List<List<Double>> list = new ArrayList<>();
        list.add(lnrpt);
        list.add(lnrmt);
        list.add(SBInvestRatio);
        list.add(fundScale);
        list.add(ALRatioin);
        list.add(institutionRatio);

        System.out.println(list);

        return PythonInvoker.call(list);
    }

    static private class PythonInvoker {
        static String paramFile;
        static String scriptFile;
        static String resultFile;

        static {
            paramFile = (PythonInvoker.class.getClassLoader().getResource("").getPath() + "PythonParam.txt").substring(1);
            scriptFile = PythonInvoker.class.getClassLoader().getResource("sfa.py").getPath().substring(1);
            resultFile = (PythonInvoker.class.getClassLoader().getResource("").getPath() + "PythonResult.txt").substring(1);

            try {
                new File(paramFile).createNewFile();
                new File(resultFile).createNewFile();
            }
            catch (IOException io) {
                io.printStackTrace();
            }
        }

        static private void wirteParams(List<List<Double>> list) {
            File file = new File(paramFile);
            FileOutputStream fileOutputStream;

            try {
                fileOutputStream = new FileOutputStream(file);

                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

                for (int i = 0; i < list.size(); ++i) {
                    List<Double> line = list.get(i);
                    for (int j = 0; j < line.size(); ++j) {
                        bufferedWriter.write(line.get(j).toString());
                        if (j < line.size() - 1) {
                            bufferedWriter.write(' ');
                        }
                    }

                    if (i < list.size() - 1) {
                        bufferedWriter.newLine();
                    }
                }

                bufferedWriter.flush();
                bufferedWriter.close();
                outputStreamWriter.close();
                fileOutputStream.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

        static private Double getResult() {
            try {
                String os = System.getProperty("os.name");
                Process proc = Runtime.getRuntime().exec("python " + scriptFile);
                System.out.println(scriptFile);
                System.out.println(proc.waitFor());

                File file = new File(resultFile);
                InputStream inputStream = new FileInputStream(file);
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

                char[] buf = new char[100];
                inputStreamReader.read(buf);

                inputStreamReader.close();
                inputStream.close();

                return Double.valueOf(new String(buf));
            }
            catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        static public Double call(List<List<Double>> list) {
            wirteParams(list);
            return getResult();
        }
    }

    public static void main(String[] args) {
        Double[] lnrpt = new Double[] {
                0d, 0.10526316, 0.21052632, 0.31578947, 0.42105263, 0.52631579,
                0.63157895, 0.73684211, 0.84210526, 0.94736842, 1.05263158, 1.15789474,
                1.26315789, 1.36842105, 1.47368421, 1.57894737, 1.68421053, 1.78947368,
                1.89473684, 2d
        };

        Double[] lnrmt = new Double[20];
        Double[] SBInvestRatio = new Double[20];

        for (int i = 0; i < 20; ++i) {
            lnrmt[i] = 0.5 * lnrpt[i] + 0.3;
            SBInvestRatio[i] = 0d;
        }

        System.out.print(SFA.getFundScore(lnrmt, lnrpt, SBInvestRatio, SBInvestRatio, SBInvestRatio, SBInvestRatio));
    }
}
