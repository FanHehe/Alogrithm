import java.lang.annotation.*;

@interface Persons {
        Person[]  value();
}


@Repeatable(Persons.class)
@interface Person{
        String role();
}


@Person(role="artist")
@Person(role="coder")
@Person(role="PM")
public class SuperMan {

}
