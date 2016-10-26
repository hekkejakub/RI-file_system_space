/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ri_java_file_system_space;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author james
 */
public class CheckSpace {

    private final String path;
    private boolean flag = false;
    private final int freespace;

    public CheckSpace(String input) {
        String[] result = input.split("\\s");
        path = result[0];
        freespace = Integer.parseInt(result[1]);
        if (result.length > 2) {
            flag = Boolean.valueOf(result[2]);
        }

    }

    public void check() {
        Path path_p = Paths.get(path);
        if (!Files.exists(path_p) & flag == false) {
            System.out.println("Path does not exist");
            System.exit(1);
        } else {
            checkfreespace();
        }
        if (flag == true) {
            setpath();
            checkfreespace();

        }
    }

    private void setpath() {  // nie dziala ta funkcja. sprawdz w poprzednim skrypcie czy tez nie dziala bo jest skopionwane.
        try {
            Path path_p = Paths.get(path);
            Files.createDirectories(path_p);
        } catch (Exception e) {
            System.out.println("Directory can't be created");
            System.exit(1);
        }
    }

    private void checkfreespace() {
        File file_p = new File(path);
        System.out.println(file_p.getFreeSpace() / 1024/1024/1024 + " GB");
        if (file_p.getFreeSpace() / 1024/1024/1024 < freespace){
            System.out.println("Not enough free space on file system.Required space(GB): "+freespace+" .Space on filesystem "+ file_p.getFreeSpace()/1024/1024/1024);
            System.exit(1);
        }

    }

}
