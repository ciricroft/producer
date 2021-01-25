package models;

import lombok.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Component
@Controller
@Getter @AllArgsConstructor  @EqualsAndHashCode @ToString
public class Obj {
    private int value;
    private Date date;
}
