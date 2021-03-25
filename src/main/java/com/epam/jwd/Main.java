package com.epam.jwd;


import com.epam.jwd.entity.Massive;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Massive massive = new Massive(new int[]{1, 2, 3, 4});
        for (int i = 0; i < 10; i++) {
            LOGGER.log(Level.INFO, "info");
        }
    }
}
