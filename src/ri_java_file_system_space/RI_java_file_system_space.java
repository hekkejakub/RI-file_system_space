/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ri_java_file_system_space;

/**
 *
 * @author james
 */
public class RI_java_file_system_space {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String input = "";
        for (String s : args) {
            input += s + " ";
        }

        try {
            CheckSpace checker = new CheckSpace(input);
            checker.check();

        } catch (Exception e) {
            System.out.println("dupa nie wyszlo");
        }
    }

}
