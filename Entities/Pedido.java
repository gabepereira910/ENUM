package Entities;

import java.text.DateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Pedido {
    private Integer id;
    private Date date;
    private OrderStatus status;

    public Pedido(Integer id, OrderStatus status, Date date) {
        this.id = id;
        this.status = status;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", date=" + date +
                ", status=" + status +
                '}';
    }
}
