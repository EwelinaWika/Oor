/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.oorlab1;

import java.io.IOException;

/**
 *
 * @author Wika
 */
public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
        Parallel parallel = new Parallel();
        parallel.downloadImages();
        parallel.factorialForLoopNumbers();

        Sequentially sequentially = new Sequentially();
        sequentially.downloadImages();
        sequentially.factorialForLoopNumbers();
    }
}
