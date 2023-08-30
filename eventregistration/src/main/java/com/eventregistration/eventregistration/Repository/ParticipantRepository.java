package com.eventregistration.eventregistration.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.eventregistration.eventregistration.Model.ParticipantModel;

public interface ParticipantRepository extends JpaRepository<ParticipantModel, Integer>
{
    
}
