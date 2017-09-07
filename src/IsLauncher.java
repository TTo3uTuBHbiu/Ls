

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.Option;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.CmdLineException;

import java.io.File;
import java.io.IOException;


public class IsLauncher {


    @Option(name = "-l", usage = "Вывод")
    public static boolean longOutputing;
    @Option(name = "-h", usage = "Вывод в человеко-читаемый формат")
    public static boolean humanOutputing;
    @Option(name = "-r", usage = "Противоположный порядок вывода")
    public static boolean reversing;
    @Option(name = "-o", usage = "Вывод результата в файл")
    public static boolean output;

    @Argument(required = true, usage = "Расположение входного файла")
    public static String input;

    public String output1;

    public static void main(String[] args) {
        new IsLauncher().launch(args);
    }


    private void launch(String[] args) {
        CmdLineParser pars = new CmdLineParser(this);
        try {
            pars.parseArgument(args);
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            pars.printUsage(System.err);
            return;
        }

        Is is = new Is(output1);
        if (longOutputing && !humanOutputing && !reversing && !output) {
            try {
                is.longOutputing();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (longOutputing && humanOutputing && !reversing && !output) {
            try {
                is.humanOutputing();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if ((longOutputing && reversing && !output) || (longOutputing && humanOutputing && reversing && !output)) {
            try {
                is.reversing();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if ((longOutputing && output) || (longOutputing && humanOutputing && output)
                || (longOutputing && humanOutputing && reversing && output)) {
            try {
                is.outputing();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else System.out.print("Неверный порядок флагов");
    }
}






