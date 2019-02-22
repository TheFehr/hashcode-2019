package sha.bfj;

import sha.bfj.utils.FileIO;
import sha.bfj.utils.Parser;

public class Main {
    public static void main(String[] args) {
        try {
            String[] fileList = FileIO.list("data");

            for (String file : fileList) {
                System.out.println(file);

                Parser p = new Parser(FileIO.read("data/" + file));
            }
        } catch (Exception e) {

        }
    }
}
