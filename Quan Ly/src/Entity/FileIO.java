package Entity;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class FileIO {
    public static final String FILE_HEADER = "id | name | gender | numberPhone | mark1 | mark2 | mark3 | mark4 | avgMark";
    public static final String line = "\n";
    public static final String comma = "  | ";
    public static final String filename = "src/File/sour.txt";

    public static void writerStudent(HashMap<String, Students> listStudent) {
        FileWriter fileWriter = null;
        try {
            File file = new File(filename);
            fileWriter = new FileWriter(file);
            fileWriter.append(FILE_HEADER);
            fileWriter.append(line);
            for (Students students : listStudent.values()) {
                fileWriter.append(students.getIdStudent());
                fileWriter.append(comma);
                fileWriter.append(students.getName());
                fileWriter.append(comma);
                fileWriter.append(students.getGender());
                fileWriter.append(comma);
                fileWriter.append(students.getNumberPhone());
                fileWriter.append(comma);
                fileWriter.append(students.getMark1());
                fileWriter.append(comma);
                fileWriter.append(students.getMark2());
                fileWriter.append(comma);
                fileWriter.append(students.getMark3());
                fileWriter.append(comma);
                fileWriter.append(students.getMark4());
                fileWriter.append(comma);
                fileWriter.append(students.getAvgMark());
                fileWriter.append(line);
            }
        } catch (Exception e) {
            System.out.println("Error in writerFile.");
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception ex) {
                System.out.println("Error when flush in closer.");
            }
        }
    }

    public static HashMap<String, Students> readerStudent() {
        BufferedReader buff = null;
        HashMap<String, Students> listStudent = new HashMap<>();
        Path path = Paths.get(filename);
        if (!Files.exists(path)){
            try {
                Writer writer =new FileWriter(filename);
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            String line;
            buff = new BufferedReader(new FileReader(filename));
            while ((line = buff.readLine()) != null){
                String[] slip = line.split(",");
                if (slip[0].equals("id")){
                    continue;
                }
                Students students = new Students();
                students.setName(slip[0]);
                students.setGender(slip[1]);
                students.setNumberPhone(slip[2]);
                students.setMark1(slip[3]);
                students.setMark2(slip[4]);
                students.setMark3(slip[5]);
                students.setMark4(slip[6]);
                students.setAvgMark(slip[7]);
                listStudent.put(students.idStudent, students);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                buff.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return listStudent;
    }

}
