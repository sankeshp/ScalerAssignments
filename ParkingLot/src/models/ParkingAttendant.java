package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class ParkingAttendant {
    private int attendantId;
    private String name;
}
