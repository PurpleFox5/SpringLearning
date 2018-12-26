package Task1_9;

//@Component("client")
//@PropertySource("classpath:client.properties")
public class Client {

    //    @Value("${id}")
    private String id;

    //    @Value("${name}")
    private String fullName;

    //    @Autowired
    public Client(String id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
