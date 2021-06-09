package resultadosapi.pojo;

import java.util.List;

public class Result {
    public String date;
    public String home;
    public String away;
    public String score;
    List<Event> homeEvents;
    List<Event> awayEvents;
}
