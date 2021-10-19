package Assignment_2;

 import java.util.*;
 import java.io.*;

 class Reader {

     static BufferedReader reader;
     static StringTokenizer tokenizer;

     static void init() {
         reader = new BufferedReader(new InputStreamReader(System.in));
         tokenizer = new StringTokenizer("");
     }

     static String next() throws IOException {
         return reader.readLine();
     }
 }
