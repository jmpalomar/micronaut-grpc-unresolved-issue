package io.energiaplus.micronaut;

import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.Micronaut;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.SocketAddress;
import java.util.Optional;

public class Application {

    private static final Logger log = LogManager.getLogger(Application.class);

    public static void main(String[] args) {

        try (ApplicationContext appContext = Micronaut.run(Application.class, args)) {

            Optional<SocketAddress> socketAddress = appContext.getProperty("grpc.channels.test.address", SocketAddress.class);

            log.info("{}", socketAddress);

            appContext.stop();

        }

    }

}
