package movie.ticket.dto.customer;

public class CustomersDto {

    private final Long id;
    private final String name;

    public CustomersDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
