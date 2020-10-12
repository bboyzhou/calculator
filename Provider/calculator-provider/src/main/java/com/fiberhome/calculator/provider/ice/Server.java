package com.fiberhome.calculator.provider.ice;

/**
 * @author zhoujian
 * @date 2020/7/24
 */
public class Server {
    public static void main(String[] args)
    {
        try(com.zeroc.Ice.Communicator communicator = com.zeroc.Ice.Util.initialize(args))
        {
//            communicator.getProperties().setProperty("Ice.Default.Package", "com.zeroc.demos.Ice.minimal");
            //
            // Install shutdown hook to (also) destroy communicator during JVM shutdown.
            // This ensures the communicator gets destroyed when the user interrupts the application with Ctrl-C.
            //
            Runtime.getRuntime().addShutdownHook(new Thread(() -> communicator.destroy()));

            com.zeroc.Ice.ObjectAdapter adapter =
                    communicator.createObjectAdapterWithEndpoints("Calculator", "default -h localhost -p 12345");
            adapter.add(new CalculatorIce(), com.zeroc.Ice.Util.stringToIdentity("calculator"));
            adapter.activate();

            communicator.waitForShutdown();
        }
    }
}
