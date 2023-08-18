package com.jys.jysInfo;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;

@Service
public class FirebaseInitialize {

    @PostConstruct //has to be Run during the Start of
    public void initialize() {
        try {
            FileInputStream serviceAccount =
                    new FileInputStream("src/main/resources/jys-information-firebase-adminsdk-7ktod-a7ea65c83c.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://jys-information-default-rtdb.firebaseio.com")
                    .build();

            FirebaseApp.initializeApp(options);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}