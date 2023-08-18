package com.jys.jysInfo;

import com.google.firebase.database.*;
import org.springframework.stereotype.Service;

@Service
public class FirebaseService {
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    public String getUserDetails(Member member) {
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("member").child("spring1");


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //    Iterable<DataSnapshot> values = dataSnapshot.getValue(Member.class);
                Member member;
                member. = dataSnapshot.child("name").getValue();
                //   member = values.toString(Member.class);
                //  return member;
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
    }
}