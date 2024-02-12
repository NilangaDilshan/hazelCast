package com.dilshan.hazelCast.serializer;

import com.dilshan.hazelCast.entities.Division;
import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.StreamSerializer;

import java.io.IOException;

public class DivisionSerializer implements StreamSerializer<Division> {
    
    @Override
    public void write(ObjectDataOutput objectDataOutput, Division division) throws IOException {
        objectDataOutput.writeInt(division.getId());
        objectDataOutput.writeString(division.getName());
        objectDataOutput.writeInt(division.getStaffCount());
    }

    @Override
    public Division read(ObjectDataInput objectDataInput) throws IOException {
        return Division.builder().id(objectDataInput.readInt()).name(objectDataInput.readString())
                .staffCount(objectDataInput.readInt()).build();
    }

    @Override
    public int getTypeId() {
        return 1;
    }
}
