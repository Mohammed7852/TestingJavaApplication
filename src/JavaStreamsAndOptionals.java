import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreamsAndOptionals {


    public static void main (String []args){



        List<Optional<String>> optsList = Arrays.asList(Optional.of("Mohammed"),Optional.empty(),Optional.of("Ali"),
                Optional.empty());

        List<String> stringList = optsList.stream().filter(Optional::isPresent).map(Optional::get).collect(Collectors.toList());

        List<String> stringList2 = optsList.stream().flatMap(o->o.isPresent()? Stream.of(o.get()):Stream.empty()).collect(Collectors.toList());

        List<String> stringList3 = optsList.stream().flatMap(
                o->o.map(Stream::of).orElseGet(Stream::empty)
        ).collect(Collectors.toList());



        System.out.println("Hello");
    }

}
