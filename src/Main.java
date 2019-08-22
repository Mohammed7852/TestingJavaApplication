import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {


        List<String> list = new ArrayList<>();
        list.add("first");
        list.add("two");
        list.add("");
        List<String> listOpt = list != null ? list : new ArrayList<>();

        Optional<List<String>> optionalS = Optional.of(list);

        List<String> listOpt2 = optionalS.orElseGet(() -> new ArrayList<>());


        // Streams

        // Empty Stream
        Stream<String> streamEmpty = Stream.empty();

        // Stream of Collection
        Collection<String> collection = Arrays.asList("a", "b", "c");
        Stream<String> streamOfCollection = collection.stream();

        // Stream of Array
        Stream<String> streamOfArray = Stream.of("a", "b", "c");

        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> streamOfArrayFull = Arrays.stream(arr);
        Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);


        // Stream.builder()
        Stream<String> streamBuilder =
                Stream.<String>builder().add("a").add("b").add("c").build();

        // Stream.generate()
        Stream<String> streamGenerated =
                Stream.generate(() -> "element").limit(10);


        // Stream.iterate()
        Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20);


        // Stream of Primitives
        IntStream intStream = IntStream.range(1, 3);
        LongStream longStream = LongStream.rangeClosed(1, 3);

        Random random = new Random();
        DoubleStream doubleStream = random.doubles(3);

        // Stream of String
        IntStream streamOfChars = "abc".chars();
        Stream<String> streamOfString =
                Pattern.compile(", ").splitAsStream("a, b, c");

        // Stream of File
//        Path path = Paths.get("C:\\file.txt");
//        Stream<String> streamOfStrings = Files.lines(path);
//        Stream<String> streamWithCharset =
//                Files.lines(path, Charset.forName("UTF-8"));

        // Referencing a Stream
        Stream<String> stream =
                Stream.of("a", "b", "c").filter(element -> !element.contains("b"));
//        Optional<String> anyElement = stream.findAny();
        Optional<String> firstElement = stream.findFirst();


        // Stream Pipeline
        Stream<String> onceModifiedStream =
                Stream.of("abcd", "bbcd", "cbcd").skip(1);

        Stream<String> twiceModifiedStream =
                stream.skip(1).map(element -> element.substring(0, 3));

        List<String> list1 = Arrays.asList("abc1", "abc2", "abc3");
        long size = list1.stream().skip(1)
                .map(element -> element.substring(0, 3)).sorted().count();





        System.out.println("Hello World");
    }
}
