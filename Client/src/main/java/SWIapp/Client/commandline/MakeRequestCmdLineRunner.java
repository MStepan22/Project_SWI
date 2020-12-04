package SWIapp.Client.commandline;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

public class MakeRequestCmdLineRunner {

    @Component
    public class MakeRequestCmdLIneRunner implements CommandLineRunner {

        private final orderControllerApi orderControllerApi;

        public MakeRequestCmdLIneRunner(orderControllerApi orderControllerApi) {
            this.orderControllerApi = orderControllerApi;
        }

        @Override
        public void run(String... args) throws Exception {
            insertOrder insertOrder = new insertOrder();
            insertOrder.setOrderName("A new order name");

            final Order insertedOrder = orderControllerApi.insertrder(insertOrder);
            System.out.printf("A new order has ID '%d'\n", insertedOrder.getId());
        }
    }
}
