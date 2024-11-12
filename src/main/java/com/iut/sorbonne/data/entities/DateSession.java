package com.iut.sorbonne.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "dateSessions")
public class DateSession extends AbstractEntity {
    @DateTimeFormat(pattern = "EEEE dd MMMM yyyy")
    private LocalDate dateDebut;
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime heureDebut;
    @DateTimeFormat(pattern = "EEEE dd MMMM yyyy")
    private LocalDate dateFin;
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime heureFin;

    @OneToOne
    private SessionVote sessionVote;
}
