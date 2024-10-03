import Entities.OrderStatus;
import Entities.Pedido;

import java.text.DateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Pedido os1 = new Pedido(54, OrderStatus.PENDING_PAYMENT, new Date());
        System.out.println(os1);
    }
}
