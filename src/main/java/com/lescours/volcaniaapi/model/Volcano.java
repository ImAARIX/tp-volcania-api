package com.lescours.volcaniaapi.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "volcano")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Volcano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "volcano_number", nullable = false, unique = true)
    private Long volcanoNumber;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "primary_volcano_type", nullable = false)
    private String primaryVolcanoType;

    @Column(name = "activity_evidence", nullable = false)
    private String activityEvidence;

    @Column(name = "last_known_eruption")
    private Long lastKnownEruption;

    @Column(name = "region", nullable = false)
    private String region;

    @Column(name = "sub_region", nullable = false)
    private String subRegion;

    @Column(name = "latitude", nullable = false)
    private Float latitude;

    @Column(name = "longitude", nullable = false)
    private Float longitude;

    @Column(name = "elevation", nullable = false)
    private Long elevation;

    @Column(name = "dominant_rock_type")
    private String dominantRockType;

    @Column(name = "tectonic_setting")
    private String tectonicSetting;

}
