package hashcode;

import hashcode.utils.FileIO;

/**
 * Hello world!
 */
public final class App {
    /**
     * Says hello to the world.
     *
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        try {
            String[] fileList = FileIO.list("data");

            for (String file : fileList) {
                System.out.println(file);
                System.out.println(FileIO.read("data/"+file));
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}
