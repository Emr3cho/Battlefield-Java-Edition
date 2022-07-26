package models.contacts;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class General {
    private String name;
    private int age;
    private int warKnowledge;

}
