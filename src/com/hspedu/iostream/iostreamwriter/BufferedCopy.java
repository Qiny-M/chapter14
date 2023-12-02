package com.hspedu.iostream.iostreamwriter;

import java.io.*;

public class BufferedCopy {
    public static void main(String[] args) {

        String srcFilePath = "/Users/meng/Downloads/合集/影视.txt";
        String destFilePath = "/Users/meng/Downloads/合集/影视3.txt";

        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        String line;
        try {
            bufferedReader = new BufferedReader(new FileReader(srcFilePath));
            bufferedWriter = new BufferedWriter(new FileWriter(destFilePath));
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            System.out.println("复制成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
