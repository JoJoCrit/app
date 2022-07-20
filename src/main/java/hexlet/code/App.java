package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import java.util.concurrent.Callable;

@Command(
        name = "App",
        mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.",
        version = "0.1.0"
)

public final class App implements Callable<Integer> {

    @Option(names = {"-h", "--help"}, usageHelp = true,
            description = "Show this help message and exit.")
    private boolean usageHelpRequest;
    @Option(names = {"-V", "--version"}, versionHelp = true,
            description = "Print version information and exit.")
    private boolean versionInfoRequest;
    @Option(names = {"-f", "--format"}, defaultValue = "stylish",
            description = "the file to use (default: ${DEFAULT-VALUE})", paramLabel = "format")
    private String format = "stylish";
    @Parameters(paramLabel = "0",
            description = "path to first file")
    private String filepath1;
    @Parameters(paramLabel = "1",
            description = "path to second file")
    private String filepath2;

    @Override
    public Integer call() {
        try {
            System.out.println(Differ.generate("./src/main/resources/file1.json", "./src/main/resources/file2.json"));
        } catch (Exception e) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
