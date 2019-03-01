package com.bayee.chapter19;

/*
 * Created by renhongjiang on 2018/10/18.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2018/10/18 10:29
 */
public class OSExecute {

    public static void command(String command) {
        boolean err = false;
        try {
            Process process = new ProcessBuilder(command.split(" ")).start();

            //输出流
            BufferedReader results = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String s;
            while ((s = results.readLine()) != null) {
                System.out.println(s);
            }

            //错误流
            BufferedReader errors = new BufferedReader(new InputStreamReader(process
                    .getErrorStream()));

            //打印错误
            while ((s = errors.readLine()) != null) {
                System.err.println(s);
                err = true;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (err) {
            throw new OSExecuteException("Errors executing " + command);
        }
    }
}