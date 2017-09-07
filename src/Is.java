/**
 * Created by z on 07.06.2017.
 */

import java.util.Date;
import java.io.*;
import java.util.ArrayList;

public class Is {

    public static File input;
    public static File output;


    public Is(String output1) {

        input = new File(IsLauncher.input);
        if (output1 == null) output = new File("output.txt");
        else output = new File(output1);

    }


    public static String longOutput(File DirInput) throws IOException {
        String l = IsLauncher.input;
        File Direct = new File(l);


        String result = "";

        if (Direct.isDirectory()) {
            for (File item : Direct.listFiles()) {
                if (item.isDirectory()) {

                    result += (item.getName() + "\tкаталог");

                } else {

                    result += (item.getName() + "  \tфайл");
                }
                result += "\tПрава доступа - ";
                if (item.canExecute()) result += "1";
                else result += "0";
                if (item.canRead()) result += "1";
                else result += "0";
                if (item.canWrite()) result += "1";
                else result += "0";

                long time = item.lastModified();
                result += "\tДата последнего изменения - " + new Date(time);

                result += "\tРазмер файла - " + item.length() * 8 + " бит" + "\n";
            }

        }
        return result;
    }

    public static String humanOutput(File DirInput) throws IOException {

        String l = IsLauncher.input;
        File Direct = new File(l);
        String result = "";

        if (Direct.isDirectory()) {
            for (File item : Direct.listFiles()) {
                if (item.isDirectory()) {

                    result += (item.getName() + "\tкаталог");

                } else {

                    result += (item.getName() + "  \tфайл");
                }
                if (item.canRead() || item.canWrite() || item.canExecute()) {
                    result += "\tПрава доступа:Доступен для";
                    if (item.canExecute()) {
                        result += " выполнения";
                        if (item.canRead() || item.canWrite()) result += ",";
                    }
                    if (item.canRead()) {
                        result += "чтения";
                        if (item.canWrite()) result += ",";
                    }
                    if (item.canWrite()) result += "изменения";
                } else result += "Право доступа ограничено";

                long time = item.lastModified();
                result += "\tДата последнего изменения - " + new Date(time);

                if (item.length() == 0) result += "\tФайл пуст " + "\n";
                else {
                    if (item.length() < 8) result += "\tРазмер файла - " + item.length() + " бит" + "\n";
                    if ((item.length() >= 8) && (item.length() < 1024 * 8))
                        result += "\tРазмер файла - " + item.length() + " байт" + "\n";
                    if ((item.length() >= 1024 * 8) && (item.length() < 1024 * 1024 * 8))
                        result += "\tРазмер файла - " + (item.length()) / 1024 + " килобайт" + "\n";
                    if ((item.length() >= 1024 * 1024 * 8) && (item.length() < 1024 * 1024 * 1024 * 8))
                        result += "\tРазмер файла - " + ((item.length()) / 1024) / 1024 + " мегобайт" + "\n";
                    if ((item.length() >= 1024 * 1024 * 1024 * 8) && (item.length() < 1024 * 1024 * 1024 * 1024))
                        result += "\tРазмер файла - " + (((item.length()) / 1024) / 1024) / 1024 + " гигобайт" + "\n";
                }
            }

        }
        return result;
    }


    public static String reverse(File in) throws IOException {
        String result = "";
        String result1 = "";

        if (IsLauncher.humanOutputing) {
            result1 = humanOutput(in);
        }

        if (IsLauncher.longOutputing && !IsLauncher.humanOutputing) {
            result1 = longOutput(in);
        }

        ArrayList<String> strings = new ArrayList<>();
        int count = -1;
        try {
            BufferedReader br = new BufferedReader(new StringReader(result1));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                count += 1;
                strings.add(count, strLine);
            }
        } catch (IOException e) {
            System.out.println("Ошибка");
        }
        for (int i = count; i >= 0; i--) {
            result += strings.get(i) + "\n";
        }
        return result;
    }


    public void reversing() throws IOException {
        System.out.print(reverse(input));
    }

    public void longOutputing() throws IOException {
        System.out.print(longOutput(input));
    }


    public void humanOutputing() throws IOException {
        System.out.print(humanOutput(input));
    }

    public void outputing() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(output))) {
            if (IsLauncher.longOutputing && !IsLauncher.humanOutputing && !IsLauncher.reversing)
                writer.write(longOutput(input));
            if (IsLauncher.humanOutputing && !IsLauncher.reversing) writer.write(humanOutput(input));
            if (IsLauncher.reversing) writer.write(reverse(input));
        }
    }
}



