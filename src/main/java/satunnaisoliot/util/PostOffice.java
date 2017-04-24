/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package satunnaisoliot.util;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author juuso_j0pbwen
 */
public class PostOffice {

    private static HashMap<String, ArrayList<MessageListener>> listeners = new HashMap<>();

    public static void register(MessageListener listener, String message) {
        if (listeners.get(message) == null) {
            listeners.put(message, new ArrayList<MessageListener>());
        }
        listeners.get(message).add(listener);
    }

    public static void sendMessage(String message) {
        if (listeners.get(message) != null) {
            for (MessageListener lis : listeners.get(message)) {
                lis.receiveMessage(message);
            }
        }

    }

}
