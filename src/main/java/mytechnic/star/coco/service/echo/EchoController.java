package mytechnic.star.coco.service.echo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/echo")
public class EchoController {

    @GetMapping("/{echo}")
    public Object getCall(@PathVariable String echo) {
        List<Object> objectList = new ArrayList<>();
        objectList.add(echo);
        System.out.println(echo);
        return objectList;
    }

    @RequestMapping("/{echo}")
    public Object allCall(@PathVariable String echo, @RequestBody Object body) {
        List<Object> objectList = new ArrayList<>();
        objectList.add(echo);
        objectList.add(body);
        System.out.println(objectList);
        return objectList;
    }
}
