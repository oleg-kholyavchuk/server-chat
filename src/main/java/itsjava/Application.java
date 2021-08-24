package itsjava;

import itsjava.services.ServerService;
import itsjava.services.ServerServiceImpl;

public class Application {


    public static void main(String[] args) {

        ServerService serverService = new ServerServiceImpl();
        serverService.start();


    }

}

