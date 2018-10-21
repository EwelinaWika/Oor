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
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Wika
 */
public class Parallel {

    private int fact;

    public void downloadImages() throws InterruptedException, IOException {
        List<Thread> threads = new ArrayList<>();
        double time;
        double start = System.nanoTime();
        File file = new File("img/parallel/");
        FileUtils.cleanDirectory(file);

        for (int i = 0; i < 10; i++) {
            int index = i;
            Thread thread = new Thread(() -> {
                try (InputStream in = new URL("https://picsum.photos/200/300/?random").openStream()) {
                    Files.copy(in, Paths.get("img/parallel/" + index + ".jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(index + ".jpg download successful!");
            });

            thread.start();
            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.join();
        }
        double stop = System.nanoTime();

        time = stop - start;

        System.out.println("Parallel downloaded image,s time: " + time);
    }

    public void factorialForLoopNumbers() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        double time;
        double start = System.nanoTime();

        for (int i = 0; i < 15; i++) {
            int index = i;

            Thread thread = new Thread(() -> {
                fact = factorial(index);
                System.out.println("Factorial of: " + index + " is: " + fact);
            });
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.join();
        }
        double stop = System.nanoTime();
        time = stop - start;
        System.out.println("Parallel factorial time: " + time);
    }

    private int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return (n * factorial(n - 1));
        }
    }
}
