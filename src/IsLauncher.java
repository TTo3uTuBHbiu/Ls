

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.Option;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.CmdLineException;
import java.io.IOException;


public class IsLauncher {


    @Option(name = "-l", usage = "Вывод")
    private boolean longOutputing;
    @Option(name = "-h", usage = "Вывод в человеко-читаемый формат")
    private boolean humanOutputing;
    @Option(name = "-r", usage = "Противоположный порядок вывода")
    private boolean reversing;
    @Option(name = "-o", usage = "Вывод результата в файл")
    private String output;

    @Argument(required = true, usage = "Расположение входного файла")
    private String input;


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

        Is is = new Is(input, output);
        if (longOutputing) {
            try {
                is.longOutputing();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (humanOutputing) {
            try {
                is.humanOutputing();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (reversing) {
            try {
                is.reversing();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}




