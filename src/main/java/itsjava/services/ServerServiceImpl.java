package itsjava.services;

import lombok.SneakyThrows;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerServiceImpl implements ServerService, Observable {
    public final static int PORT = 8081;
    public final List<Observer> observers = new ArrayList<>();


    @SneakyThrows
    @Override
    public void start() {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println(" ++++Server Starts++++");

        while (true) {
            Socket socket = serverSocket.accept();
            if (socket != null) {
                Thread thread = new Thread(new ClientRunnable(socket, this));
                thread.start();
            }

        }
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);

    }

    @Override
    public void deleteObserver(Observer observer) {
        observers.remove(observer);

    }

    @Override
    public void notifyObserver(String message) {

        for (Observer observer : observers) {
            observer.notifyMe(message);
        }

    }

//    @Override
//    public void notifyObserverExcpectMe(String message, Observer observ) {
//
//        if(!observ.equals(observ)){
//            for (Observer observer : observers) {
//                observer.notifyMe(message);
//            }
//        }
//
//
//    }


}
