package org.sapient.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    private String movieCode;
    private String Movie_name;
    private String dir_name;
    private String heroName;
    private LocalDate releaseDate;
}
