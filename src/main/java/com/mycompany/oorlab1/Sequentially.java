/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.oorlab1;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.apache.commons.io.FileUtils;



/**
 *
 * @author Wika
 */
public class Sequentially {

    public void downloadImages() throws IOException {
        double time;
        double start = System.nanoTime();
        File file = new File("img/sequentially/");
        FileUtils.cleanDirectory(file);

        for (int i = 0; i < 10; i++) {
            try (InputStream in = new URL("https://picsum.photos/200/300/?random").openStream()) {
                Files.copy(in, Paths.get("img/sequentially/" + i + ".jpg"));
            }
            System.out.println(i + ".jpg downloaded");
        }
        double stop = System.nanoTime();
        time = stop - start;
        System.out.println("Sequntially dowloaded image, time: " + time);
    }

    public void factorialForLoopNumbers() {
        double time;
        double start = System.nanoTime();
        int fact = 0;
        for (int i = 0; i < 15; i++) {
            fact = factorial(i);
            System.out.println("Factorial of: " + i + " is: " + fact);
        }
        double stop = System.nanoTime();
        time = stop - start;
        System.out.println("Sequentially factorial time: " + time);
    }

    private int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return (n * factorial(n - 1));
        }
    }
}
