package com.videostreaming.sqldatabase.model;

//import jakarta.persistence.;
import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;

@Enabled
@Data
@AllArgsConstructor
@Entity
//@Table(name = "vid_meta_data")
public class VidMetaData {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String vidName;
    private String vidDescription;
    private String url;
    private String publisher;

    public VidMetaData() {

    }
}